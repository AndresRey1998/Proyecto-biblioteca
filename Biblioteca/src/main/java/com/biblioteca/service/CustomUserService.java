package com.biblioteca.service;

import com.biblioteca.entity.User;
import com.biblioteca.entity.UserSecurity;
import com.biblioteca.repository.UserSecurityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("myUserDetailService")
@Transactional
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserSecurityRepository userDetailsRepository;

    public CustomUserService(UserSecurityRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user=this.userDetailsRepository.findByUserName(userName);
        UserSecurity userSecurity = new UserSecurity(user);
        return userSecurity;

    }
}
