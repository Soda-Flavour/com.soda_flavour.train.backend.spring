package com.soda_flavour.train.spring.cruds.core;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressSet {
    
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_group_id")
    private AddressGroup addressGroup;


    public void setAddress(Address address) {
        this.address = address;
        address.getAddressSets().add(this);
    }

    public void setAddressGroup(AddressGroup addressGroup) {
        this.addressGroup = addressGroup;
        addressGroup.getAddressSets().add(this);
    }



    public static AddressSet createAddressSet(Address address, AddressGroup... addressGroups) {
        AddressSet addressSet = new AddressSet();
        addressSet.setAddress(address);
        for(AddressGroup addressGroup : addressGroups){
            addressSet.setAddressGroup(addressGroup);
        }
        return addressSet;
    }


}
