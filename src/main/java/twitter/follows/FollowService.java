package twitter.follows;

import twitter.users.User;
import twitter.users.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FollowService {

    private FollowRepository followRepository;
    private UserService userService;
    public FollowService(FollowRepository followRepository, UserService userService){
        this.followRepository = followRepository;
        this.userService = userService;
    }

    public void follow(Follow follow){
        User from = userService.getUser(x->x.getNickName().equals(follow.getUser()));
        User to = userService.getUser(x->x.getNickName().equals(follow.getOther()));

        //TODO throws an exception
        if(!userService.existsUserByNickname(follow.getUser()) || !userService.existsUserByNickname(follow.getOther()))
            return;

       Optional<Follow> followage = getFollowage(follow.getUser(), follow.getOther());
       if(followage.isEmpty())
           followRepository.follow(follow);
       else{
            followRepository.save(follow);
        }
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
