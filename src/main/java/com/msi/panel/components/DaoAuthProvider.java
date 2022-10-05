package com.msi.panel.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DaoAuthProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;


 private PasswordEncoder passwordEncoder;



    @Autowired
    public DaoAuthProvider(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;

    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
     String username = authentication.getName();
     Object credentials = authentication.getCredentials();
        Assert.notNull(username, "Username cannot be null");
        Assert.notNull(credentials, "Password cannot be null");
     if (!(credentials instanceof String)){
       return null;
     }
     String password = credentials.toString();
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    boolean PassMatch = passwordEncoder.matches(password, userDetails.getPassword());
    if (!PassMatch){
        throw new BadCredentialsException("Incorrect password provided");
    }
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
            new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

    return usernamePasswordAuthenticationToken;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
