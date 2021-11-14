package com.soda_flavour.train.spring.cruds.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter @Builder
@ToString(of = {"title", "description"})
public class Address {
    
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;
    private String owner;
    
    
    @OneToMany(mappedBy = "address")
    private List<AddressSet> addressSets = new ArrayList<>();
    

    public void addAddressSet(AddressSet addressSet) {
        this.addressSets.add(addressSet);
        addressSet.setAddress(this);
    }


    public static Address createAddress(Address address, List<AddressGroup> addressGroups) {
        for(AddressGroup addressGroup: addressGroups){
            AddressSet addressSet = new AddressSet();
            addressSet.setAddress(address);
            addressSet.setAddressGroup(addressGroup);
            address.addAddressSet(addressSet);
        }
        return address;
    }


    // public static Address createAddress(Address address, List<AddressGroup> addressGroups) {
    //     address.
    //     return address;
    // }
    

}
