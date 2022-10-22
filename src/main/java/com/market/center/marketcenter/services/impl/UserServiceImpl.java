package com.market.center.marketcenter.services.impl;


import com.market.center.marketcenter.models.entity.UserEntity;
import com.market.center.marketcenter.models.serviceModels.UserLoginServiceModel;
import com.market.center.marketcenter.models.serviceModels.UserRegisterServiceModel;
import com.market.center.marketcenter.repositoies.UserRepository;
import com.market.center.marketcenter.security.BoilSecurityDetails;
import com.market.center.marketcenter.services.UserRoleService;
import com.market.center.marketcenter.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final BoilSecurityDetails boilSecurityDetails;
    private final ModelMapper modelMapper;
    private final JavaMailSender javaMailSender;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService,
                           PasswordEncoder passwordEncoder, BoilSecurityDetails boilSecurityDetails,
                           ModelMapper modelMapper, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.boilSecurityDetails = boilSecurityDetails;
        this.modelMapper = modelMapper;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public boolean existingUsername(String username) {

        return this.userRepository.findByUsername(username).isPresent();


    }

    @Override
    public boolean existingEmail(String email) {
        return this.userRepository.findUserEntityByEmail(email).isPresent();
    }

    @Override
    public void addUserRegister(UserRegisterServiceModel userRegisterServiceModel) {


        UserEntity user = this.modelMapper.map(userRegisterServiceModel, UserEntity.class);

        user.setPassword(this.passwordEncoder.encode(userRegisterServiceModel.getPassword()));


        if (this.userRepository.count() == 0) {

            this.userRoleService.setAdmin(user);
        } else {
            this.userRoleService.setUser(user);
        }


        this.userRepository.save(user);

    }

    @Override
    public void loginUsers(UserLoginServiceModel userLoginServiceModel) {

        UserEntity userEntity = this.modelMapper.map(userLoginServiceModel, UserEntity.class);

        UserDetails principal = this.boilSecurityDetails.loadUserByUsername(userEntity.getUsername());


        Authentication authentication = new UsernamePasswordAuthenticationToken(

                principal,
                userEntity.getPassword(),
                principal.getAuthorities()

        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


    }

    @Override
    public boolean confirmPassword(String confirmPassword, String password) {

        return (!(confirmPassword).equals(password));
    }

    @Override
    public UserEntity findUserByUsername(String username) {


        return this.userRepository.findByUsername(username)
                .orElseThrow(IllegalAccessError::new);


    }

    @Override
    public void resetToken(String email, HttpServletRequest request) {


        Optional<UserEntity> user = this.userRepository.findUserEntityByEmail(email);


        UserEntity currentUser = user.get();


        currentUser.setResetToken(UUID.randomUUID().toString());

        this.userRepository.save(currentUser);


        this.sendEmailToken(request, currentUser);


    }

    @Override
    @Async
    public void sendEmail(SimpleMailMessage email) {
        this.javaMailSender.send(email);
    }

    @Override
    public void cerateNewPassword(String resetToken, String confirmPassword) {

        UserEntity currentUser = this.userRepository.findUserEntityByResetToken(resetToken)
                .orElseThrow(IllegalAccessError::new);


        currentUser.setPassword(this.passwordEncoder.encode(confirmPassword));
        currentUser.setResetToken(null);
        this.userRepository.save(currentUser);


    }

    //todo private methode
    @Override
    public UserEntity getUserByAuthentication() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        String user = authentication.getName();


        if (user.equals("anonymousUser")) {


            return null;
        }




        return findUserByUsername(user);
    }

    @Override
    public String ascertainmentUserRole() {


        String userRole = "";

        if (this.isAnonymousUser()) {

            userRole = "anonymousUser";
        } else {
            UserEntity user = this.getUserByAuthentication();
            userRole = user.getRoleName();
        }


        String roleName = "";

        switch (userRole) {

            case "USER":
                roleName = "USER";
                break;
            case "ADMIN":
                roleName = "ADMIN";
                break;
            case "MODERATOR":
                roleName = "MODERATOR";
                break;
            case "anonymousUser":
                roleName = "anonymousUser";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + userRole);
        }

        return roleName;
    }

    @Override
    public String helloUser() {


        if (isAnonymousUser()) {

            return "anonymousUser";

        }

        UserEntity courrentUser = this.getUserByAuthentication();

        return courrentUser.getFirstName().toString();
    }

    private boolean isAnonymousUser() {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String courantUser = authentication.getName();


        return courantUser.equals("anonymousUser");

    }

    private void sendEmailToken(HttpServletRequest request, UserEntity user) {

        String appUrl = request.getScheme() + "://" + request.getServerName();


        SimpleMailMessage passwordResteMail = new SimpleMailMessage();

        passwordResteMail.setFrom("service@market-center.de");
        passwordResteMail.setTo(user.getEmail());
        passwordResteMail.setSubject("Password Reset Request");
//todo mahni    8080
        passwordResteMail.setText("Neues Passwort festlegen : " + appUrl + ":8080/reset?token=" + user.getResetToken());


        this.sendEmail(passwordResteMail);


    }
}
