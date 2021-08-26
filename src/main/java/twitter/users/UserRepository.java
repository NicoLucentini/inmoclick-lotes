package twitter.users;

public interface UserRepository {
    void addUser(User user);
    User getUser(String nickname);
    void updateUser(User user);
}
