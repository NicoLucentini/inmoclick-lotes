package users;

import java.util.function.Predicate;

public interface UserRepository {
    void addUser(User user);
    User getUser(Predicate<User> option);
    void updateUser(User user);
}
