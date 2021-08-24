package follows;

import users.User;
import users.UserService;
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

    public void follow(String current, String target){
        User from = userService.getUser(x->x.getNickName().equals(current));
        User to = userService.getUser(x->x.getNickName().equals(target));

        if(from == null || to ==null)
            return;

       Optional<Follow> followage = getFollowage(current, target);
       if(followage.isEmpty())
           followRepository.follow(current, target);
       else{
           Follow follow = followage.get();
           if(!follow.isActive())
           {
                follow.setActive(true);
                followRepository.save(follow);
           }
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
        return followRepository.getFollows(from).stream().filter(x->x.getOther().equals(to)).findFirst();
    }
}
