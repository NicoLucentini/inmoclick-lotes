import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InMemoryUserRepository implements UserRepository{

    private List<User> users = new ArrayList<>();
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
        //Mapear todos los campos que quisiera updatear o reemplazar el user
        inMemory.setRealName(user.getRealName());
    }
}
