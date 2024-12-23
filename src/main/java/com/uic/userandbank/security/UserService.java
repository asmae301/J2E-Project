package com.uic.userandbank.security;

import com.uic.userandbank.repositories.SecurityUserRepository;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final SecurityUserRepository userRepository;

    public UserService(SecurityUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public SecurityUser getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public SecurityUser createUser(SecurityUser user){
        return userRepository.save(user);
    }
}


