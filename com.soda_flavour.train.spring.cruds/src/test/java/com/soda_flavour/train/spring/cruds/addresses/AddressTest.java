package com.soda_flavour.train.spring.cruds.addresses;

import com.soda_flavour.train.spring.cruds.RestMockMvcBuilder;
import com.soda_flavour.train.spring.cruds.RestMockMvcBuilder.RestMockMvc;
import com.soda_flavour.train.spring.cruds.addressGroups.AddressGroupRepository;
import com.soda_flavour.train.spring.cruds.addresses.repository.AddressRepository;
import com.soda_flavour.train.spring.cruds.core.Address;
import com.soda_flavour.train.spring.cruds.core.AddressGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest
@Transactional
@Slf4j
public class AddressTest {
    
    protected RestMockMvc $;

    private @Autowired AddressRepository addressRepository;
    private @Autowired AddressGroupRepository addressGroupRepository;


    @BeforeEach
    public void setUp(WebApplicationContext context, RestDocumentationContextProvider restDocumentation) {
        this.$ = RestMockMvcBuilder.of(context).docs(restDocumentation).secure(false).build();


        addressGroupRepository.save(AddressGroup.builder().title("그룹1").owner("user1").build());
        addressGroupRepository.save(AddressGroup.builder().title("그룹2").owner("user1").build());
        addressGroupRepository.save(AddressGroup.builder().title("그룹3").owner("user1").build());
        addressGroupRepository.save(AddressGroup.builder().title("그룹4").owner("user1").build());
        
    }




    @Test
    public void 주소록_생성() throws Exception {

        // $.POST("/addresses").C("name", "Mr. Hong").C("phoneNumber", "01022223333").is2xx();
         Address address = new Address("Mr. Hong", "01022223333");
         addressRepository.save(address);
         Long id = address.getId();

        $.GET("/addresses/" + id).is2xx().andReturn("a1");

        log.info("{}", (String) $.variables().resolveValue("${a1.$}"));

    }
}
