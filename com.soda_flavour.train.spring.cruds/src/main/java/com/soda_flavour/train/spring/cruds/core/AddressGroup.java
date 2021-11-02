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
@ToString(of = {"title", "description"})
@Getter @Builder
@AllArgsConstructor
public class AddressGroup {
    
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;

    private String owner;

    @OneToMany(mappedBy = "addressGroup")
    private List<AddressSet> addressSets = new ArrayList<>();

}
