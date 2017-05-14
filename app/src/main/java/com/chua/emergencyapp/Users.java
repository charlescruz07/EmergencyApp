package com.chua.emergencyapp;

/**
 * Created by Acer on 14/05/2017.
 */

public class Users {
    private String name;
    private String displayPicture;
    private String role;

    public Users() {
    }

    public Users(String name, String displayPicture, String role) {
        this.name = name;
        this.displayPicture = displayPicture;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
