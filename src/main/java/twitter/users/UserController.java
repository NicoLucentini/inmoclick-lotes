package twitter.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user){
        try {
            userService.register(user);
            return  ResponseEntity.ok(user);
        }
        catch (DuplicateUserException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody User user){
        try {
            userService.update(user);
            return  ResponseEntity.ok(user);
        }
        catch (NonExistentUserException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
