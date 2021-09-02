package twitter.tweets;

public class Tweet {
    private String message;
    private String user;

    public Tweet(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

    public TweetJpa toJpa() {
        return new TweetJpa(user, message);
    }
    public static Tweet fromJpa(TweetJpa tweet) {
        return new Tweet(tweet.getMessage(), tweet.getNickname());
    }
}
