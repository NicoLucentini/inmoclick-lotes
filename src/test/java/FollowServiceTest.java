import follows.FollowService;
import follows.Follow;
import infra.InMemoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserService;

import java.util.List;

public class FollowServiceTest {
    private FollowService followService;
    private UserService userService;

    private User current;
    private User target;

    @Before
    public void init(){

        InMemoryRepository memory = new InMemoryRepository();
        userService = new UserService(memory);

        followService = new FollowService(memory, userService);

        current = new User("Nico Lucentini", "@nicol");
        target = new User("Pepe Lucentini", "@pepel");

        userService.register(current);
        userService.register(target);
    }


    @Test
    public void aUserFollowsOtherUser(){
        followService.follow(current.getNickName(), target.getNickName());
        List<Follow> follows = followService.getFollows(current.getNickName());
        Assert.assertTrue(follows
                .stream()
                .anyMatch(x-> x.getUser().equals(current.getNickName()) && x.getOther().equals(target.getNickName())));
    }

}
