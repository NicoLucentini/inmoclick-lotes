package twitter.tweets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public void tweet(Tweet tweet) {
        tweetRepository.save(tweet.toJpa());
    }

    public List<Tweet> getTweetsByUser(String nickname) {
        return  tweetRepository.findAllByNickname(nickname).stream().map(x->Tweet.fromJpa(x)).collect(Collectors.toList());
    }
}
