package com.soda_flavour.train.spring.cruds.addressGroups;

import com.soda_flavour.train.spring.cruds.core.AddressGroup;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressGroupRepository extends PagingAndSortingRepository<AddressGroup, Long> {

}
