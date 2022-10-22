package com.market.center.marketcenter.models.serviceModels;

public class UserRegisterServiceModel {


    private String username;
    private String firstName;
    private String familyName;
    private String password;
    private String email;

    public UserRegisterServiceModel() {
    }


    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public UserRegisterServiceModel setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
