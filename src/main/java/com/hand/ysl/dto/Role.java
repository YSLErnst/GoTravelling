package com.hand.ysl.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Ernst on 2017/12/4.
 */
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Set<User> users;

    public Role(){}

    public Role(Integer id,String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
