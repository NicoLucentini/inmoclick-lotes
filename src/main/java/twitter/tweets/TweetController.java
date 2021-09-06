package twitter.tweets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter.tweets.Tweet;

import java.util.ArrayList;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping("/tweet")
    public ResponseEntity tweet(@RequestBody Tweet tweet) {
        tweetService.tweet(tweet);
        return ResponseEntity.status(201).body(tweet);
    }

    @GetMapping("/tweets/{nickname}")
    public ResponseEntity getTweets(@PathVariable String nickname) {
        return ResponseEntity.ok(tweetService.getTweetsByUser(nickname));
    }
}
