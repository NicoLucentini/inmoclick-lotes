package tweets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.tweets.Tweet;
import twitter.tweets.TweetController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TweetsControllerTest {

    @Autowired
    private TweetController tc;

    @Test
    public  void aUserCanTweet(){
        Tweet tweet = new Tweet("test tweet", "nico");
        ResponseEntity res = tc.tweet(tweet);
        assertEquals(201,res.getStatusCodeValue());
        assertTrue(res.hasBody());
    }
    @Test
    public  void userCanSeeOtherUserTweets(){
        var res = tc.getTweets("nico");
        assertEquals(200, res.getStatusCodeValue());
        assertTrue(res.hasBody());
    }
}
