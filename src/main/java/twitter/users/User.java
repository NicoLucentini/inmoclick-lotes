package twitter.users;

public class User {
    private String realName;
    private String nickName;

    public User(String realName, String nickName) {
        this.realName = realName;
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public UserJpa convert(){
       return new UserJpa(this.realName, this.nickName);
    }
    public static User parse(UserJpa user){
        return new User(user.getRealname(), user.getNickname());
    }
}
