package com.soda_flavour.train.spring.relationship.addresses;

import com.soda_flavour.train.spring.relationship.RestMockMvcBuilder;
import com.soda_flavour.train.spring.relationship.RestMockMvcBuilder.RestMockMvc;
import com.soda_flavour.train.spring.relationship.core.Address;

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


    @BeforeEach
    public void setUp(WebApplicationContext context, RestDocumentationContextProvider restDocumentation) {
        this.$ = RestMockMvcBuilder.of(context).docs(restDocumentation).secure(false).build();

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
