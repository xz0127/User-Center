package com.example.userCenter.service.impl;

import com.example.userCenter.dao.AddressDao;
import com.example.userCenter.pojo.Address;
import com.example.userCenter.service.AddressService;
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
