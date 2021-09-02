package twitter.users;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User addUser(User user);
    User getUser(String nickname);
    void updateUser(User user);
}
