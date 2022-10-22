package com.market.center.marketcenter.services;


import com.market.center.marketcenter.models.entity.UserEntity;
import com.market.center.marketcenter.models.entity.UserRoleEntity;
import com.market.center.marketcenter.models.entity.enumerationsEntities.UserRoleEnumeration;

public interface UserRoleService {


    void initRole();


    void setAdmin(UserEntity user);

    UserRoleEntity findRole(UserRoleEnumeration role);

    void setUser(UserEntity user);
}
