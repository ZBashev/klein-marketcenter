package com.market.center.marketcenter.repositoies;


import com.market.center.marketcenter.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String>{


    Optional<UserEntity>findByUsername(String Username);

    Optional<UserEntity>findUserEntityByEmail(String Email);


    Optional<UserEntity> findUserEntityByResetToken(String resetToken);


}
