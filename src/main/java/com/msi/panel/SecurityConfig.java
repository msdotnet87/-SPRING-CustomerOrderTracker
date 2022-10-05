package com.msi.panel;


import com.msi.panel.components.DaoAuthProvider;
import com.msi.panel.service.JpaUserServiceAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.annotation.AccessType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
        //(debug=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JpaUserServiceAuth jpaUserServiceAuth;
    @Autowired
    DaoAuthProvider daoAuthProvider;

    @Autowired
    public SecurityConfig(JpaUserServiceAuth jpaUserServiceAuth){
        this.jpaUserServiceAuth = jpaUserServiceAuth;
    }


    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(jpaUserServiceAuth);
        authenticationManagerBuilder.authenticationProvider(daoAuthProvider);

    }

    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/sign_up").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/admin_panel").hasAuthority("ADMIN")
                .antMatchers("/").hasAuthority("ADMIN")
                .anyRequest().permitAll()
                .and()
           .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/show")
                .deleteCookies("cookies")
                .and()
           .csrf().disable();

    }


}
