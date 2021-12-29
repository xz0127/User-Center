package com.example.demo.service.impl;

import com.example.demo.dao.AddressDao;
import com.example.demo.pojo.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, String>
        implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    protected JpaRepository getRepository() {
        return addressDao;
    }


}
