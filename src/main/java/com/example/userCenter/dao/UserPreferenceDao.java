package com.example.userCenter.dao;

import com.example.userCenter.pojo.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceDao extends JpaRepository<UserPreference, String> {
}
