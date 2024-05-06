package com.security;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.security.userRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
private UsersRepository usersRepository;

    @Override
public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        User user = (User) usersRepository.findBySsoId(ssoId);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with ssoId '%s' not found.", ssoId));
        }
        return (UserDetails) user;
    }
}
