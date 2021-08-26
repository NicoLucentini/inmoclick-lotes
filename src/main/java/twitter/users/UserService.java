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
        User user = getUser(newUserData.getNickName());
        if(user == null)
            System.out.println("Usuario no existente");
        else
            userRepository.updateUser(user);
    }
    public User getUser(String nickname){
        return  userRepository.getUser(nickname);
    }
    public boolean existsUserByNickname(String nickName){
        return getUser(nickName) != null;
    }
}
