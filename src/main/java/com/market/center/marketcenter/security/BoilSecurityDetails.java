package com.market.center.marketcenter.security;

import com.market.center.marketcenter.models.entity.UserEntity;
import com.market.center.marketcenter.repositoies.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoilSecurityDetails implements UserDetailsService {


    private final UserRepository userRepository;




    public BoilSecurityDetails(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {






        UserEntity userEntity = this.userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User with name" + username + "was not found")
        );


        return this.mapToUserDetail(userEntity);


    }

    private UserDetails mapToUserDetail(UserEntity userEntity) {

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();


        grantedAuthorityList.add(new SimpleGrantedAuthority(
                "ROLE_" + userEntity.getRoleEnum().getUserRoleEnumeration().name()));


        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                grantedAuthorityList
        );


    }
}
