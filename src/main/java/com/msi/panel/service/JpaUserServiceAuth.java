package com.msi.panel.service;


import com.msi.panel.entity.User;
import com.msi.panel.repository.UserRepository;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserServiceAuth implements UserDetailsService {


    private static final String UserNotFound = "Username %s not found";
    private UserRepository userRepository;

    @Autowired
public JpaUserServiceAuth(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Optional<User> optUsername = userRepository.findByUsername(username);
        if(!optUsername.isPresent()){
            throw new UsernameNotFoundException(UserNotFound);
        }
        User user = optUsername.get();
        return user;
    }
}
