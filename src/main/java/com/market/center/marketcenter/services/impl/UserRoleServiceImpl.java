package com.market.center.marketcenter.services.impl;


import com.market.center.marketcenter.models.entity.UserEntity;
import com.market.center.marketcenter.models.entity.UserRoleEntity;
import com.market.center.marketcenter.models.entity.enumerationsEntities.UserRoleEnumeration;
import com.market.center.marketcenter.repositoies.UserRoleRepository;
import com.market.center.marketcenter.services.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initRole() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity admin = new UserRoleEntity(UserRoleEnumeration.ADMIN);
            UserRoleEntity user = new UserRoleEntity(UserRoleEnumeration.USER);

            this.userRoleRepository.saveAll(List.of(admin, user));
        }

    }

    @Override
    public void setUser(UserEntity user) {


        user.setRoleEnum(this.findRole(UserRoleEnumeration.USER));
        user.setRoleName(this.findRole(UserRoleEnumeration.USER).getUserRoleEnumeration().name());


    }


    @Override
    public void setAdmin(UserEntity user) {


        this.initRole();


        user.setRoleName(this.findRole(UserRoleEnumeration.ADMIN).getUserRoleEnumeration().name());

        user.setRoleEnum(this.findRole(UserRoleEnumeration.ADMIN));


    }

    @Override
    public UserRoleEntity findRole(UserRoleEnumeration role) {


        return this.userRoleRepository.findByUserRoleEnumeration(role).orElse(null);

    }
}
