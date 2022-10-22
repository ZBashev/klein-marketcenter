package com.market.center.marketcenter.services;


import com.market.center.marketcenter.models.entity.UserEntity;
import com.market.center.marketcenter.models.serviceModels.UserLoginServiceModel;
import com.market.center.marketcenter.models.serviceModels.UserRegisterServiceModel;
import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpServletRequest;

public interface UserService {



    boolean existingUsername(String username);

    boolean existingEmail(String email);

    void addUserRegister(UserRegisterServiceModel userRegisterServiceModel);

    void loginUsers(UserLoginServiceModel userLoginServiceModel);

    boolean confirmPassword(String confirmPassword,String password);

    UserEntity findUserByUsername(String username);


    void resetToken(String email, HttpServletRequest request);

    void sendEmail(SimpleMailMessage email);

    void cerateNewPassword(String resetToken, String confirmPassword);

    UserEntity getUserByAuthentication();

    String ascertainmentUserRole();

    String   helloUser();
}
