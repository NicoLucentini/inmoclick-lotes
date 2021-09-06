package twitter.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  UserService(){}
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(User user) throws DuplicateUserException{
       if(existsUserByNickname(user.getNickName()))
           throw  new DuplicateUserException("Usuario ya existente");

      return  userRepository.addUser(user);
    }
    public  void update(User newUserData) throws NonExistentUserException{
        if(!existsUserByNickname(newUserData.getNickName()))
           throw new NonExistentUserException("Usuario no existente");

        userRepository.updateUser(newUserData);
    }


    public User getUser(String nickname){
        return  userRepository.getUser(nickname);
    }
    public boolean existsUserByNickname(String nickName){
        return getUser(nickName) != null;
    }
}
