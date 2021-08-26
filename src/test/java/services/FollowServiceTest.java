package services;

import twitter.follows.FollowService;
import twitter.follows.Follow;
import twitter.infra.InMemoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import twitter.users.User;
import twitter.users.UserService;

import java.util.List;

public class FollowServiceTest {
    private FollowService followService;
    private UserService userService;
    InMemoryRepository memory;
    private User current;
    private User target;
    Follow follow;

    @Before
    public void init(){

        memory = new InMemoryRepository();
        userService = new UserService(memory);

        followService = new FollowService(memory, userService);

        current = new User("Nico Lucentini", "@nicol");
        target = new User("Pepe Lucentini", "@pepel");

        follow = new Follow(current.getNickName(), target.getNickName(), true);

        userService.register(current);
        userService.register(target);
    }


    @Test
    public void aUserFollowsOtherUser(){
        followService.follow(follow);
        List<Follow> follows = followService.getFollows(current.getNickName());
        Assert.assertTrue(follows
                .stream()
                .anyMatch(x-> x.matches(current.getNickName(), target.getNickName())));
    }

    @Test
    public void getFollowersTest(){
        //Inserto manualmente el objeto en la memoria
        memory.follow(follow);

        List<Follow> followers = followService.getFollowers(target.getNickName());

        Assert.assertTrue(followers.stream()
                .anyMatch(x-> x.matches(current.getNickName(), target.getNickName())));
    }

    @Test
    public  void aNonExistentUserWantToFollowOtherUser(){
        Follow follow1 = new Follow("@pepe", "@nicol",true);

        followService.follow(follow1);
        List<Follow> followers = followService.getFollowers("@nicol");

        Assert.assertFalse(followers.stream()
                .anyMatch(x-> x.matches("@pepe", "@nicol")));
    }
}
