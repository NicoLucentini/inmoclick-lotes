import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {

    private  static UserService userService;
    private  static InMemoryUserRepository inMemoryUserRepository;
    @BeforeClass
    public  static void AfterClass(){
     inMemoryUserRepository = new InMemoryUserRepository();
     userService = new UserService(inMemoryUserRepository);
    }
    @Test
    public  void RegisterSuccesfull(){
        User user = new User("Nicolas Lucentini", "@nicolaslucentini");
        userService.register(user);

        Assert.assertNotNull(userService.getUser(x->x.equals(user)));
    }
    @Test
    public  void RegisterUnsuccesfull(){
        User user = new User("Nicolas Lucentini", "@nicolucentini");
        userService.register(user);

        User user2 = new User("Pepe Lucentini", "@nicolucentini");
        userService.register(user2);

        Assert.assertNull(userService.getUser(x->x.equals(user2)));
    }
    @Test
    public  void UpdateNameSuccesfull(){
        User user = new User("Nicolas Lucentini", "@nicol");
        userService.register(user);

        user.setRealName("Nico Lucentini");

        userService.update(user);

        Assert.assertEquals("Nico Lucentini",
                userService.getUser(x->x.getNickName().equals(user.getNickName()))
                        .getRealName());

    }
}
