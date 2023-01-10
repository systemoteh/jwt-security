package ru.systemoteh.jwtsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static ru.systemoteh.jwtsecurity.common.Constants.ADMIN_ROLE;
import static ru.systemoteh.jwtsecurity.common.Constants.EMPTY_STRING;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Value("${auth.login.username:username}")
    private String username;
    @Value("${auth.login.password:password}")
    private String password;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(ADMIN_ROLE));
        username = this.username.equalsIgnoreCase(username) ? username : EMPTY_STRING;
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        return new org.springframework.security.core.userdetails.User(username, encodedPassword, grantedAuthorities);
    }
}