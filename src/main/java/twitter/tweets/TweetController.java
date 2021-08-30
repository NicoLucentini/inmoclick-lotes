package twitter.tweets;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter.tweets.Tweet;

import java.util.ArrayList;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @PostMapping("/tweet")
    public ResponseEntity tweet(@RequestBody Tweet tweet) {
        return ResponseEntity.status(201).body(tweet);
    }

    @GetMapping("/tweets/{id}")
    public ResponseEntity getTweets(@RequestParam String nickname) {
        return ResponseEntity.ok(new ArrayList<Tweet>());
    }
}
