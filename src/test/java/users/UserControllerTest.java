package users;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.users.User;
import twitter.users.UserController;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserControllerTest {

    @Autowired
    private UserController uc;

    @Test
    public void addUserCorrect(){
        ResponseEntity res = uc.registerUser(new User("pepe", UUID.randomUUID().toString()));
        Assert.assertTrue(res.hasBody());
        Assert.assertEquals(201, res.getStatusCodeValue());

    }
    @Test
    public void addUserError(){
        ResponseEntity first = uc.registerUser(new User("pepe", "pepe"));

        ResponseEntity res = uc.registerUser(new User("pepe", "pepe"));
        Assert.assertEquals("Usuario ya existente", res.getBody());
        Assert.assertEquals(400, res.getStatusCodeValue());

    }
}
