package com.soda_flavour.train.spring.cruds.addressGroups.controller;

import java.util.Map;

import com.soda_flavour.train.spring.cruds.addressGroups.AddressGroupRepository;
import com.soda_flavour.train.spring.cruds.core.AddressGroup;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/addressGroups")
@RestController
@RequiredArgsConstructor
public class AddressGroupController {
    
    private final AddressGroupRepository addressGroupRepository;

    
    ///////////////////////////////////////////////////////////////
    // CREATE
    ///////////////////////////////////////////////////////////////
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String,String> map) {
        String title = map.get("title");
        String owner = map.get("owner");

        AddressGroup addressGroup = addressGroupRepository.save(AddressGroup.builder()
                                                .title(title)
                                                .owner(owner)
                                                .build());
    
        return ResponseEntity.ok().body(addressGroup.getId());
    }
}
