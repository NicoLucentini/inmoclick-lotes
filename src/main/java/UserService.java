import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void register(User user){
       if(existsUser(x->x.getNickName().equals(user.getNickName())))
        System.out.println("Usuario Ya existente");
       else
        userRepository.addUser(user);
    }
    public  void update(User newUserData){
        User user = getUser(x->x.getNickName().equals(newUserData.getNickName()));
        if(user == null)
            System.out.println("Usuario no existente");
        else
            userRepository.updateUser(user);
    }
    public User getUser(Predicate<User> option){
        return  userRepository.getUser(option);
    }
    private  boolean existsUser(Predicate<User> option){
        return getUser(option) != null;
    }
}
