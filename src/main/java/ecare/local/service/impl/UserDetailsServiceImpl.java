package ecare.local.service.impl;

import ecare.local.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// https://o7planning.org/11543/create-a-login-application-with-spring-boot-spring-security-spring-jdbc
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return Optional.ofNullable(userService.findByLogin(userName))
                .map(user -> User.withUsername(user.getLogin())
                        .password(user.getPassword())
                        .roles(user.getRole().getName())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
