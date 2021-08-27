package twitter.users;

public class DuplicateUserException extends  Exception{

    public DuplicateUserException(String message) {
        super(message);
    }
}
