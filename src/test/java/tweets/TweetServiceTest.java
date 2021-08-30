package tweets;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.tweets.Tweet;
import twitter.tweets.TweetService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TweetServiceTest {

    @Autowired
    private TweetService ts;

    @Test
    public void aUserCanTweet(){
        Tweet tweet = new Tweet("Test tweet", "nico");
        ts.tweet(tweet);
    }
    @Test
    public void getTweets(){

        Tweet tweet = new Tweet("Test tweet", "nico");
        List<Tweet> tweets = ts.getTweetsByUser("nico");

        Assert.assertTrue(!tweets.isEmpty());
    }
}
