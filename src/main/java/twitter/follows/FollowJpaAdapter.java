package twitter.follows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class FollowJpaAdapter implements  FollowRepository{

    @Autowired
    private FollowJpaRepository followRepository;

    @Override
    public void follow(Follow follow) {
        followRepository.save(follow.toJpa());
    }

    @Override
    public List<Follow> getFollows(String nickname) {
        //forma vaga..
        return followRepository.findAll().stream()
                .filter(x->x.getFollower().equals(nickname) )
                .map(x-> Follow.fromJpa(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<Follow> getFollowers(String nickname) {
        return followRepository.findAll().stream()
                .filter(x->x.getFollowee().equals(nickname) )
                .map(x-> Follow.fromJpa(x))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Follow follow) {
        followRepository.save(follow.toJpa());
    }
}
