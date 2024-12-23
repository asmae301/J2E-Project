package com.uic.userandbank.security;

import com.uic.userandbank.repositories.SecurityUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SecurityUserRepository userRepository;

    public CustomUserDetailsService(SecurityUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SecurityUser user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with email");
        }

        System.out.println("Loading user: " + user.getEmail());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}