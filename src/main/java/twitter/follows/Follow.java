package twitter.follows;

public class Follow {
    private String user;
    private String other;
    private boolean active; // 0 user follows other, 1 other follows user, 2 each follows each

    public Follow(String user, String other, boolean status) {
        this.user = user;
        this.other = other;
        this.active = status;
    }

    public String getUser() {
        return user;
    }

    public String getOther() {
        return other;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }

    public  boolean matches(String user,String other){
        return this.user.equals(user) && this.other.equals(other);
    }
}
