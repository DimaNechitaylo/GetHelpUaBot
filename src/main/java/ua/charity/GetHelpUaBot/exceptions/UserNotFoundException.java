package ua.charity.GetHelpUaBot.exceptions;

public class UserNotFoundException  extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
