package com.soda_flavour.train.spring.cruds.addresses.service;

import java.util.ArrayList;
import java.util.List;

import com.soda_flavour.train.spring.cruds.addressGroups.AddressGroupRepository;
import com.soda_flavour.train.spring.cruds.addresses.repository.AddressRepository;
import com.soda_flavour.train.spring.cruds.core.Address;
import com.soda_flavour.train.spring.cruds.core.AddressGroup;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class AddressService {
    
    private final AddressRepository addressRepository;
    private final AddressGroupRepository addressGroupRepository;

    @Transactional
    public void create(Address address, List<Long> groupIds) {
        
        List<AddressGroup> addressGroups = addressGroupRepository.findAllById(groupIds);
        log.info("{}", addressGroups);
        addressRepository.save(Address.createAddress(address, addressGroups));


    }
}
