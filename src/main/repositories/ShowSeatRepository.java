package main.repositories;

import jakarta.persistence.LockModeType;
import main.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    Optional<ShowSeat> findById(Long showSeatId);
    // select * from show_seat where id = showSeatId

    // select * from show_seat where Id in (.....) for update
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findAllByIdIn(List<Long> showSeatId);

    ShowSeat save(ShowSeat showSeat); // upsert -> update + Insert
}
