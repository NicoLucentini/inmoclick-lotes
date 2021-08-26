package services;

import twitter.infra.InMemoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import twitter.users.User;
import twitter.users.UserService;

public class UserServiceTest {

    private   UserService userService;
    private   InMemoryRepository inMemoryUserRepository;

    private  User user;
    @Before
    public  void init(){
     inMemoryUserRepository = new InMemoryRepository();
     userService = new UserService(inMemoryUserRepository);
     user = new User("Nicolas Lucentini", "@nicolaslucentini");
    }

    @Test
    public void GetUserTest(){
        //voy a inyectar a mano el usuario en el repository.
        inMemoryUserRepository.addUser(user);

        User res = userService.getUser(user.getNickName());
        Assert.assertEquals(user,res);
    }

    @Test
    public  void RegisterSuccesfull(){
        userService.register(user);

        Assert.assertNotNull(userService.getUser(user.getNickName()));
    }
    @Test
    public  void RegisterUnsuccesfull(){
        userService.register(user);

        User user2 = new User("Pepe Lucentini", "@nicolaslucentini");
        userService.register(user2);

        User res = userService.getUser(user2.getNickName());

        Assert.assertNotEquals(res, user2);
    }
    @Test
    public  void UpdateNameSuccesfull(){
        User user = new User("Nicolas Lucentini", "@nicol");
        userService.register(user);

        user.setRealName("Nico Lucentini");

        userService.update(user);

        User res = userService.getUser(user.getNickName());

        Assert.assertEquals(res.getRealName(), "Nico Lucentini");

    }
}
