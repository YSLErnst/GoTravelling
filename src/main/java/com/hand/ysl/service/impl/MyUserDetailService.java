package com.hand.ysl.service.impl;

import com.hand.ysl.dto.MyUserDetail;
import com.hand.ysl.dto.Role;
import com.hand.ysl.dto.User;
import com.hand.ysl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ernst on 2017/12/4.
 */
@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<User> users = userMapper.getByUserName(userName);
        if(users!=null && users.size()>0){
            return new MyUserDetail(users.get(0),getAuthorities(userName));
        }else{
            throw new UsernameNotFoundException("User "+userName+" has no GrantedAuthority");
        }
    }

    private Collection<GrantedAuthority> getAuthorities(String userName) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList();
        List<Role> roles = userMapper.getRolesByUserName(userName);
        for(Role role:roles){
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        return grantedAuthorities;
    }
}
