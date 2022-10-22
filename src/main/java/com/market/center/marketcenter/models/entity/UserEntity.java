package com.market.center.marketcenter.models.entity;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String firstName;
    private String familyName;
    private String password;
    private String email;
    private String roleName;
    private UserRoleEntity roleEnum;
    private String resetToken;


    public UserEntity() {
    }

    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "family_name", nullable = false)
    public String getFamilyName() {
        return familyName;
    }

    public UserEntity setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "email", nullable = false)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }


    public UserEntity setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }


    @Column(name = "reset_token")
    public String getResetToken() {
        return resetToken;
    }

    public UserEntity setResetToken(String resetToken) {
        this.resetToken = resetToken;
        return this;
    }

    @OneToOne()
    @JoinColumn(name = "role_enum_id", referencedColumnName = "id")
    @Enumerated(EnumType.STRING)
    public UserRoleEntity getRoleEnum() {
        return roleEnum;
    }

    public UserEntity setRoleEnum(UserRoleEntity roleEnum) {
        this.roleEnum = roleEnum;
        return this;
    }

}
