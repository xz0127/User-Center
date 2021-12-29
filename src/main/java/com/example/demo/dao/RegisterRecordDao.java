package com.example.demo.dao;

import com.example.demo.pojo.RegisterRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRecordDao extends JpaRepository<RegisterRecord, String> {

    RegisterRecord findByUsername(String username);
}
