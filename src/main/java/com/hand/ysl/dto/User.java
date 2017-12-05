package com.hand.ysl.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "user")
public class User{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String password;

    private Boolean enabledFlag;

    private Set<Role> roles;

    public User(){
    }

    public User(Integer id,String name, String password, Boolean enabledFlag, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.enabledFlag = enabledFlag;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enabledFlag=" + enabledFlag +
                ", roles=" + roles +
                '}';
    }
}