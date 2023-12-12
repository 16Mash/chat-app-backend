package com.mash.userregister.repository;

import com.mash.userregister.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByContact(String contact);
    public User findByEmailAndPassword(String email,String password);

}
