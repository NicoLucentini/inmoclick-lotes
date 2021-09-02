package twitter.follows;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository {
    Follow follow(Follow follow);
    List<Follow> getFollows(String nickname);
    List<Follow> getFollowers(String nickname);
    void save(Follow follow);
}
