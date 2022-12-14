package com.market.center.marketcenter.models.bindingModels;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {


    private String username;
    private String password;


    public UserLoginBindingModel() {
    }

    @Size(min = 3)
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 3)
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
