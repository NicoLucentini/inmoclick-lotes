package twitter.users;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    void addUser(User user);
    User getUser(String nickname);
    void updateUser(User user);
}
