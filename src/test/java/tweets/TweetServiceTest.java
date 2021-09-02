package tweets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.tweets.Tweet;
import twitter.tweets.TweetService;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TweetServiceTest {

    @Autowired
    private TweetService ts;

    @Test
    public void aUserCanTweet(){
        String id = UUID.randomUUID().toString();
        Tweet tweet = new Tweet(id, "nico");
        ts.tweet(tweet);
        List<Tweet> tweets = ts.getTweetsByUser("nico");
        assertTrue(tweets.stream().anyMatch(x->x.getMessage().equals(id)));
    }
    @Test
    public void getTweets(){
        List<Tweet> tweets = ts.getTweetsByUser("nico");
        assertFalse(tweets.isEmpty());
    }
}
