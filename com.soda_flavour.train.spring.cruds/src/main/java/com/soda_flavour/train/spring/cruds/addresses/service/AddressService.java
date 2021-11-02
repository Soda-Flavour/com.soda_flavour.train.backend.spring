package com.soda_flavour.train.spring.cruds.addresses.service;

import com.soda_flavour.train.spring.cruds.addresses.repository.AddressRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AddressService {
    
    private final AddressRepository addressRepository;

    public void create() {
        
    }
}
