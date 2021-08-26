package twitter.follows;

import java.util.List;

public interface FollowRepository {
    void follow(Follow follow);
    List<Follow> getFollows(String nickname);
    List<Follow> getFollowers(String nickname);
    void save(Follow follow);
}
