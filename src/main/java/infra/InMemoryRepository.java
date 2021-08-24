package infra;

import follows.Follow;
import follows.FollowRepository;
import users.User;
import users.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryRepository implements UserRepository, FollowRepository {

    private List<User> users = new ArrayList<>();
    private List<Follow> follows = new ArrayList<>();
    @Override
    public User getUser(Predicate<User> option) {
      return users.stream()
              .filter(option)
              .findFirst()
              .orElse(null);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
    @Override
    public void updateUser(User user) {
        User inMemory = getUser(x->x.getNickName().equals(user.getNickName()));
        if(inMemory != null)
            inMemory.setRealName(user.getRealName());
    }

    @Override
    public void follow(String from, String to) {
        follows.add(new Follow(from, to, true));
    }

    @Override
    public List<Follow> getFollows(String nickname) {
       return follows.stream()
               .filter(x->x.getUser().equals(nickname) )
               .collect(Collectors.toList());
    }

    @Override
    public List<Follow> getFollowers(String nickname) {
        return follows.stream()
                .filter(x->x.getOther().equals(nickname) )
                .collect(Collectors.toList());
    }

    @Override
    public void save(Follow follow) {

    }
}
