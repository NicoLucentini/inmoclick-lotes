package twitter.follows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity follow(@RequestBody  Follow follow){
        followService.follow(follow);
        return  ResponseEntity.status(201).build();
    }
    @GetMapping("/follows/{nickname}")
    public ResponseEntity getFollows(@PathVariable String nickname){
        List<Follow> follows = followService.getFollows(nickname);
        return  ResponseEntity.ok(follows);
    }
}
