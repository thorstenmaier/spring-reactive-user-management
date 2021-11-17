package com.trivadis.spring.user.repository;

import com.trivadis.spring.user.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
