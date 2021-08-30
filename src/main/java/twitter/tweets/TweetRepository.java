package twitter.tweets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<TweetJpa, Long> {

    List<TweetJpa> findAllByNickname(String nickname);
}
