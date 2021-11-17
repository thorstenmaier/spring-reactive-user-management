package com.trivadis.spring.user.service;


import com.trivadis.spring.user.domain.User;
import com.trivadis.spring.user.repository.UserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAllUsers() {
    	return userRepository.findAll();
    }
}