package twitter.users;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USERS")
public class UserJpa {
    @Id
    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REALNAME")
    private String realname;

    public UserJpa(String nickname, String realname) {
        this.nickname = nickname;
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
