package com.market.center.marketcenter.repositoies;


import com.market.center.marketcenter.models.entity.UserRoleEntity;
import com.market.center.marketcenter.models.entity.enumerationsEntities.UserRoleEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,String> {


       Optional<UserRoleEntity> findByUserRoleEnumeration(UserRoleEnumeration role);
}
