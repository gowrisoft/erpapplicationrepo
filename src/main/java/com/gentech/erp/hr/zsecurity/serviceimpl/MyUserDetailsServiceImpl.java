package com.gentech.erp.hr.zsecurity.serviceimpl;

import com.gentech.erp.hr.zsecurity.entity.MyUser;
import com.gentech.erp.hr.zsecurity.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MyUserRepository repository;

    @Override
         public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             MyUser existingUser = repository.findByUsername(username)
                     .orElseThrow(() -> new UsernameNotFoundException("The User " + username + " has not found in database"));

             return User.builder()
                     .username(existingUser.getUsername())
                     .password(existingUser.getPassword())
                     .roles(getRoles(existingUser))
                     .build();
         }

    public String[] getRoles(MyUser user) {
            return user.getRole().split(",");
    }
}