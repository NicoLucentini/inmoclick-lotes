package twitter.users;

import java.util.function.Predicate;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void register(User user){
       if(existsUserByNickname(user.getNickName()))
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
    public boolean existsUserByNickname(String nickName){
        return getUser(x->x.getNickName().equals(nickName)) != null;
    }
}
