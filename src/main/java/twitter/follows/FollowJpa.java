package twitter.follows;

import javax.persistence.*;

@Entity
@Table(name="follows")
public class FollowJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="follower")
    private String follower;
    @Column(name="followee")
    private String followee;
    @Column(name="active")
    private boolean active;


    public FollowJpa(){}

    public FollowJpa(String follower, String followee, boolean active) {
        this.follower = follower;
        this.followee = followee;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowee() {
        return followee;
    }

    public void setFollowee(String followee) {
        this.followee = followee;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
