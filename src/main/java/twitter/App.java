package twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter.follows.FollowService;
import twitter.inmoclick.InmoclickConsumer;
import twitter.users.UserService;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static UserService userService;
    private static FollowService followService;


    @Autowired
    private InmoclickConsumer consumer;

    @Override
    public void run(String... strings) {
        Date date=new Date();
        Timer timer = new Timer();

        timer.schedule(new TimerTask(){
            public void run(){
                consumer.LoadValues();
            }
        },date, 24*60*60*1000);

    }

    public static void main(String args[]){
        SpringApplication.run(App.class, args);

    }



}
