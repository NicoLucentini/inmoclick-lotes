package twitter.users;

public class NonExistentUserException extends Exception{
    public NonExistentUserException(String message) {
        super(message);
    }
}
