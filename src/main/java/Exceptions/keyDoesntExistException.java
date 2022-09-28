package main.java.Exceptions;

public class keyDoesntExistException extends Exception {
    public keyDoesntExistException(String errorMessage){
        super(errorMessage);
    }
}
