package com.security;

import com.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findBySsoId(String ssoId);
}

public class userRepository {

}
