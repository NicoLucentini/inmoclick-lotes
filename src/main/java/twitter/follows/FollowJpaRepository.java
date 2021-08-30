package twitter.follows;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowJpaRepository extends JpaRepository<FollowJpa, Long> {
}
