package com.hypers.service.impl;

import com.hypers.crius.message.util.MessageUtils;
import com.hypers.dao.UserDao;
import com.hypers.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynne
 * @date 2021/12/13
 */

@Service("userService")
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException  {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("登录用户[" + username + "]未注册!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()), getAuthority());
    }

    private List<GrantedAuthority> getAuthority() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return grantedAuthorityList;
    }

}
