package com.soda_flavour.train.spring.relationship.addresses;

import com.soda_flavour.train.spring.relationship.core.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    
}
