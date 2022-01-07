package com.example.userCenter.dao;

import com.example.userCenter.pojo.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDao extends JpaRepository<UserProfile, String> {
}
