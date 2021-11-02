package com.soda_flavour.train.spring.howtotest.addresses;

import com.soda_flavour.train.spring.howtotest.core.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    
}
