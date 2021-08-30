package services;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.follows.Follow;
import twitter.follows.FollowJpaAdapter;
import twitter.follows.FollowJpaRepository;
import twitter.follows.FollowRepository;
import twitter.users.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class FollowRepositoryTest {


    @Autowired
    private FollowRepository repository;

    @Autowired
    private UserService userService;

    @Before
    public void init(){
    }

    @Test
    public  void registerFollow(){
        repository.follow(new Follow("nico", "anto",true));
    }
    @Test
    public  void getUser(){
        repository.follow(new Follow("nico", "anto",true));
        List<Follow> follows = repository.getFollows("nico");
        Assert.assertTrue(follows.stream().anyMatch(x->x.matches("nico","anto")));
    }
}
