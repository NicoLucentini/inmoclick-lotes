import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private List<User> users;
    public Twitter(){
        users = new ArrayList<User>();
    }
    public void register(User user){
        if(users.stream().anyMatch(x->x.getNickName().equals(user.getNickName())))
            System.out.println("Usuario ya existente");
        else
            users.add(user);
    }
    public User getUserByNickname(String nickName) {
        return  users.stream().filter(x->x.getNickName().equals(nickName)).findFirst().orElse(null);
    }
}
