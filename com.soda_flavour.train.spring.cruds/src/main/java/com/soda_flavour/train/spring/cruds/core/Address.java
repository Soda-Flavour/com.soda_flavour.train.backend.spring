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
    
    
    @OneToMany(mappedBy = "address")
    private List<AddressSet> addressSets = new ArrayList<>();
    

    public Address(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    

}
