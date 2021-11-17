package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UserService {
    Flux<User> getAllUsers();
}
