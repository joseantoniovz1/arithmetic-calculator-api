package com.challenge.api.repository;

import com.challenge.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReporsitory extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

}
