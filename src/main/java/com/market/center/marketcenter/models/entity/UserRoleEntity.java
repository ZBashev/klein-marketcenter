package com.market.center.marketcenter.models.entity;

import com.market.center.marketcenter.models.entity.enumerationsEntities.UserRoleEnumeration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity  extends BaseEntity{




    private UserRoleEnumeration roleEnumeration;


    public UserRoleEntity() {


    }

    @Autowired
    public UserRoleEntity(UserRoleEnumeration roleEnumeration) {
        this.roleEnumeration = roleEnumeration;
    }

    @Column(name = "user_role_enumeration", nullable = true)
    @Enumerated(EnumType.STRING)
    public UserRoleEnumeration getUserRoleEnumeration() {
        return roleEnumeration;
    }

    public UserRoleEntity setUserRoleEnumeration(UserRoleEnumeration userRoleEnumeration) {
        this.roleEnumeration = userRoleEnumeration;
        return this;
    }
}
