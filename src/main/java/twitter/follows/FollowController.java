package twitter.follows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter.users.NonExistentUserException;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity follow(@RequestBody  Follow follow){
        try {
            Follow data = followService.follow(follow);
            return  ResponseEntity.status(201).body(data);
        }
        catch (NonExistentUserException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/follows/{nickname}")
    public ResponseEntity getFollows(@PathVariable String nickname){
        //List<Follow> follows = followService.getFollows(nickname);
        ;
        return  ResponseEntity.ok(followService.fromFollows(nickname));
    }
}
