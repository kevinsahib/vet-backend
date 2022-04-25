package com.login.auth.repositorio;

import com.login.auth.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);
    User save(User user);
}