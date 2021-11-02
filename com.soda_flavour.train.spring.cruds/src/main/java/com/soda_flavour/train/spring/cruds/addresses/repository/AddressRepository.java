package com.soda_flavour.train.spring.cruds.addresses.repository;

import com.soda_flavour.train.spring.cruds.core.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    
}
