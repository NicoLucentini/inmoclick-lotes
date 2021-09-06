package follows;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.follows.Follow;
import twitter.follows.FollowController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class FollowControllerTest {


    @Autowired
    FollowController fc;
    @Test
    public  void getFollowsCorrect(){
        ResponseEntity response = fc.getFollows("default");

        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertTrue(response.hasBody());
    }
    @Test
    public  void addFollowCorrect(){
        ResponseEntity response = fc.follow(new Follow("default", "default1", true));
        Assert.assertEquals(201, response.getStatusCodeValue());
    }
}
