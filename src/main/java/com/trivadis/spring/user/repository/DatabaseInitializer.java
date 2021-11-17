package com.trivadis.spring.user.repository;

import com.trivadis.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    private final UserRepository users;
    private final DatabaseClient database;

    public DatabaseInitializer(UserRepository users, DatabaseClient database) {
        this.users = users;
        this.database = database;
    }

    @PostConstruct
    public void init() {

        Flux.just(
                "DROP TABLE IF EXISTS user;",
                "CREATE TABLE user (id int, lastname varchar(255), firstname varchar(255));")
                .map(it -> database.sql(it).fetch().rowsUpdated())
                .blockLast().subscribe();

        for (int i = 0; i < 2_000; i++) {
            users.save(new User("Thorsten", "Maier")).subscribe();
            if (i % 1000 == 0) {
                System.out.println(i);
            }

        }
//        users.findAll().subscribe(System.out::println);

    }
}
