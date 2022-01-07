package com.example.userCenter.dao;

import com.example.userCenter.pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, String> {
}
