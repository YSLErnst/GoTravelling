package com.hand.ysl.provider;

import com.hand.ysl.service.impl.MyUserDetailService;
import com.hand.ysl.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Ernst on 2017/12/5.
 */
public class SecurityProvider implements AuthenticationProvider{

    @Autowired
    private MyUserDetailService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String userName = (String)token.getPrincipal();
        Object credential = token.getCredentials();
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        if (userDetails == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if(!userDetails.getPassword().equals(MD5Util.encodeByMD5((String)credential).toLowerCase())){
            throw new UsernameNotFoundException("用户密码不对");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, credential,
                userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
