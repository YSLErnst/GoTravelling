package com.hand.ysl.dto;

import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "b_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String password;

    private Integer level;

    private String des;

    //电话号码
    private String tel;

    private String address;

    private Long lastLoginTime;

    private String enabledFlag;

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
        this.password = password == null ? null : password.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", level=" + level + ", des=" + des + ", tel=" + tel
				+ ", address=" + address + "]";
	}
    
}