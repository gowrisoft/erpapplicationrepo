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

        Optional<MyUser> user = repository.findByUsername(username);
        MyUser existingUser = user.get();
        if (user.isPresent()) {
            return User.builder()
                    .username(existingUser.getUsername())
                    .password(existingUser.getPassword())
                    .roles(getRoles(existingUser))
                    .build();
        } else {
            throw new UsernameNotFoundException("The User " + username + " has not found in database");
        }
    }

    public String[] getRoles(MyUser user) {
        if (user.getRole() == null) {
            return new String[]{"USER"};
        } else {
            return user.getRole().split(",");
        }
    }

}