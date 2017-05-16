package com.chua.emergencyapp;

/**
 * Created by Acer on 16/05/2017.
 */

public class SafePeople {

    private String userPic;
    private String userName;

    public SafePeople() {
    }

    public SafePeople(String userPic, String userName) {
        this.userPic = userPic;
        this.userName = userName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
