package com.parkjeongsu.modeler.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USERDEFINITION")
public class UserDefinition implements Serializable {
    @Id
    @Column(name = "USERID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "USERLEVEL")
    private UserLevel userLevel;

    @Column(name = "GROUPNAME")
    private String groupName;

    public UserDefinition() {
    }

    public UserDefinition(String userId, String password, String email, String phoneNumber, UserLevel userLevel, String groupName) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userLevel = userLevel;
        this.groupName = groupName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
