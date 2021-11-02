package com.soda_flavour.train.spring.howtotest.addresses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.soda_flavour.train.spring.howtotest.RestMockMvcBuilder;
import com.soda_flavour.train.spring.howtotest.RestMockMvcBuilder.RestMockMvc;
import com.soda_flavour.train.spring.howtotest.addresses.AddressRepository;
import com.soda_flavour.train.spring.howtotest.core.Address;

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

        List<Address> addList = new ArrayList<>();
        addList.add(new Address("Mr. Hong1", "01022223333"));
        addList.add(new Address("Mr. Hong2", "01022223333"));
        addList.add(new Address("Mr. Hong3", "01022223333"));
        addList.add(new Address("Mr. Hong4", "01022223333"));
        addList.add(new Address("Mr. Hong5", "01022223333"));
        addList.add(new Address("Mr. Hong6", "01022223333"));


        addressRepository.saveAll(addList);
         Long id = 4L;

        $.GET("/addresses/" + id).is2xx().andReturn("a1");

        log.info("{}", (Object) $.variables().resolveValue("{a1}"));

        $.GET("{a1}").is2xx().andReturn("m2");

        log.info("tete {}", (Object) $.variables().resolveValue("{m2.$}"));

        // log.info("{}", (Integer) $.variables().resolveValue("{a1.id}"));
        // log.info("{}", (String) $.variables().resolveValue("{a1.name}"));

        assertEquals((long) (int) $.variables().resolveValue("{m2.$.id}"),  id);

    }
}
