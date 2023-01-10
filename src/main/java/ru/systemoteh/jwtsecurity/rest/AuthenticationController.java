package ru.systemoteh.jwtsecurity.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.systemoteh.jwtsecurity.configuration.JwtTokenProvider;
import ru.systemoteh.jwtsecurity.dto.AuthenticationRequestDto;
import ru.systemoteh.jwtsecurity.dto.AuthenticationResponseDto;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwtsecurity/auth")
public class AuthenticationController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    /*
        curl --location --request POST 'http://localhost:8080/jwtsecurity/auth/login' \
        --header 'Content-Type: application/json' \
        --data-raw '{
           "username":"username",
           "password":"password"
        }'
     */
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (userDetails == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            AuthenticationResponseDto responseDto = fillResponse(userDetails);

            return ResponseEntity.ok(responseDto);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private AuthenticationResponseDto fillResponse(UserDetails userDetails) {
        String token = jwtTokenProvider.createToken(userDetails);

        Set<String> roles = new HashSet<>();
        for (GrantedAuthority grantedAuthority : userDetails.getAuthorities()) {
            roles.add(grantedAuthority.getAuthority());
        }

        return new AuthenticationResponseDto(userDetails.getUsername(), userDetails.getPassword(), token, roles);
    }
}
