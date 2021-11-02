package com.soda_flavour.train.spring.cruds.addresses.controller;

import java.nio.charset.Charset;

import com.soda_flavour.train.spring.cruds.addresses.controller.request.AddressCreateRequest;
import com.soda_flavour.train.spring.cruds.addresses.repository.AddressRepository;
import com.soda_flavour.train.spring.cruds.addresses.service.AddressService;
import com.soda_flavour.train.spring.cruds.core.Address;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/addresses")
@RepositoryRestController
@Slf4j
@RequiredArgsConstructor
public class AddressController {
    

    private final AddressService addressService;
    private final AddressRepository addressRepository;

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressReadResponse> read(@PathVariable("addressId") Long addressId) {
        log.info("이곳을 타고 끝납니다...");
        Address address = addressRepository.findById(addressId).get();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(new AddressReadResponse(address.getId(), address.getName()), header, HttpStatus.OK);
    }


    @PostMapping()
    public void create(@RequestBody AddressCreateRequest request) {
        
        Address address = Address.builder().name(request.getName()).phoneNumber(request.getPhoneNumber()).build();
    
    
    
    }



    @Data
    @AllArgsConstructor
    public static class AddressReadResponse {
        private Long id;
        private String name;
    }
}
