package twitter.tweets;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
public class TweetJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "message")
    private String message;

    public  TweetJpa(){}

    public TweetJpa( String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }
}
