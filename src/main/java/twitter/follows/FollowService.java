package twitter.follows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter.users.User;
import twitter.users.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserService userService;

    public FollowService(FollowRepository followRepository, UserService userService){
        this.followRepository = followRepository;
        this.userService = userService;
    }

    public  FollowService(){}

    public void follow(Follow follow){
        User from = userService.getUser(follow.getUser());
        User to = userService.getUser(follow.getOther());

        //TODO throws an exception
        if(!userService.existsUserByNickname(follow.getUser()) || !userService.existsUserByNickname(follow.getOther()))
            return;

       Optional<Follow> followage = getFollowage(follow.getUser(), follow.getOther());
       if(followage.isEmpty())
           followRepository.follow(follow);

   }

    public List<Follow> getFollows(String nickName){
        return followRepository.getFollows(nickName)
                .stream()
                .filter(x->x.isActive())
                .collect(Collectors.toList());
    }

    public List<Follow> getFollowers(String nickName)
    {
        return followRepository.getFollowers(nickName)
                .stream()
                .filter(x->x.isActive())
                .collect(Collectors.toList());
    }

    private Optional<Follow> getFollowage(String from, String to){
        return followRepository.getFollows(from)
                .stream()
                .filter(x->x.getOther().equals(to))
                .findFirst();
    }
}
