package follows;

import users.User;

import java.util.List;

public interface FollowRepository {
    void follow(String from, String to);
    List<Follow> getFollows(String nickname);
    List<Follow> getFollowers(String nickname);
    void save(Follow follow);
}
