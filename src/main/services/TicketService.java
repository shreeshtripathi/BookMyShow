package main.services;

import main.exceptions.ShowSeatNotFoundException;
import main.models.*;
import main.repositories.ShowSeatRepository;
import main.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;;

    TicketService(ShowSeatRepository showSeatRepository,
                  UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIds,
                             Long userId,
                             Long showId) throws ShowSeatNotFoundException {
        /* steps :
         * 1. Fetch show seat from the list of showSeatIds (No Lock)
         * 2. Check the status of show seats
         * 3. If anyone of them is not available then throw an exception
         * 4. Acquire the lock -> call findAllById() with lock
         * 5. check the status of show seat again (with lock)
         * 6. If all of them are available then generate the ticket
         * 7. Last Payment services
         * */
        // step 1
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);
        // step 2+3
        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                throw new ShowSeatNotFoundException(showSeat.getId());
            }
        }
        // step 4+5
        showSeats = showSeatRepository.findAllByIdIn(showSeatIds); // with lock

        for(ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }
        // step 6
        Ticket ticket = new Ticket();
        Optional<User> userOptional = userRepository.findById(userId);
        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setShowSeats(showSeats);

        // additional
        /*
         * If payment status is not equal to SUCCESS
         * roll out the entire transaction
         */
        return ticket;
    }
}
