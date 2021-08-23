import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterTest {

    private static Twitter twitter;
    @BeforeClass
    public static void SetUp(){
        twitter = new Twitter();
    }

    @Test
    public  void RegisterSuccesfull(){

        User user = new User("Nicolas Lucentini", "@nicolaslucentini");
        twitter.register(user);

        Assert.assertNotNull(twitter.getUserByNickname(user.getNickName()));
    }
    @Test
    public  void RegisterUnsuccesfull(){
        User user = new User("Nicolas Lucentini", "@nicolucentini");
        twitter.register(user);

        User user2 = new User("Pepe Lucentini", "@nicolucentini");
        twitter.register(user2);

        Assert.assertNotEquals(user2.getRealName(), twitter.getUserByNickname(user.getNickName()).getRealName());
    }
}
