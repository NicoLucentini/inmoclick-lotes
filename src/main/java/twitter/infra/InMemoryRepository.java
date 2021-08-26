package twitter.infra;

import twitter.follows.FollowRepository;
import twitter.follows.Follow;
import twitter.users.User;
import twitter.users.UserRepository;

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
        //Quizas reemplazar la position
        if(inMemory != null)
            inMemory.setRealName(user.getRealName());
    }

    @Override
    public void follow(Follow follow) {
        follows.add(follow);
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
        Optional<Follow> fetch = follows.stream().filter(x->x.matches(follow.getUser(), follow.getOther())).findFirst();
        if(fetch.isPresent())
            fetch.get().setActive(follow.isActive());
    }

}
