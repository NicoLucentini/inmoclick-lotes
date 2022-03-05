package twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter.follows.FollowService;
import twitter.test.Perro;
import twitter.users.UserService;

@SpringBootApplication
public class App extends Perro {
    private static UserService userService;
    private static FollowService followService;



    public static void main(String args[]){
        SpringApplication.run(App.class, args);
    }
    void bla(){

    }


}
