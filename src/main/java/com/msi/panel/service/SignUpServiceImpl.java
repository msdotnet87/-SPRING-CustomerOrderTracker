package com.msi.panel.service;

import com.msi.panel.entity.User;
import com.msi.panel.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SignUpServiceImpl {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUpuser(User user){
       //logika sprawdzania pustych i zajetych uzytkownikow
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser=userRepository.save(user);
        return newUser;
    }
}
