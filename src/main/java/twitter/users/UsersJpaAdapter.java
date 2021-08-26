package twitter.users;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UsersJpaAdapter implements  UserRepository{

    @Autowired
    private UserJpaRepository repository;

    @Override
    public void addUser(User user) {
        repository.save(user.convert());
    }

    @Override
    public User getUser(String nickname) {

        Optional<UserJpa> user = repository.findById(nickname);
        if(user.isPresent())
            return  User.parse(user.get());
        return null;
    }

    @Override
    public void updateUser(User user) {
        repository.save(user.convert());
    }
}
