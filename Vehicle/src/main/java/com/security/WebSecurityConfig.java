package com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .requestMatchers("/", "/index").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")).formLogin(login -> login.loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password")
                .defaultSuccessUrl("/admin")).logout(logout -> logout.logoutSuccessUrl("/index").invalidateHttpSession(true));
    }
}
