package main.exceptions;

public class ShowSeatNotFoundException extends Exception {
    public ShowSeatNotFoundException(Long showSeatId) {
        super("Show seat with id " + showSeatId + " not found");
    }
}
