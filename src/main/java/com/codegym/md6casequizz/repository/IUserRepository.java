package com.codegym.md6casequizz.repository;

import com.codegym.md6casequizz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    //tim kiem co ton tai trong DB khong
    Optional<User> findByUsername(String name);

    //kt xem user da co torng DB chua khi tao du lieu
    Boolean existsByUsername(String name);

    //kt xem email da co torng DB chua khi tao du lieu
    Boolean existsByEmail(String email);
}
