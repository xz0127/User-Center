package com.example.userCenter.dao;

import com.example.userCenter.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    User getByUsername(String username);
}
