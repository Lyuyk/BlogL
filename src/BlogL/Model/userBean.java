package BlogL.Model;

public class userBean {
    private String userID;
    private String userName;
    private String userPassword;
    private String userProfileImgUrl=null;


    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserProfileImgUrl(String userProfileImgUrl)
    {
        this.userProfileImgUrl=userProfileImgUrl;
    }

    public String getUserProfileImgUrl() {
        return userProfileImgUrl;
    }
}
