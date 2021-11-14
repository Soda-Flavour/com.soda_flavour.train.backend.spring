package com.soda_flavour.train.spring.cruds.users;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;

import com.soda_flavour.train.spring.cruds.RestMockMvcBuilder;
import com.soda_flavour.train.spring.cruds.RestMockMvcBuilder.RestMockMvc;


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
public class UserTest {
    
    protected RestMockMvc $;


    private @Autowired EntityManager em;


    @BeforeEach
    public void setUp(WebApplicationContext context, RestDocumentationContextProvider restDocumentation) {
        this.$ = RestMockMvcBuilder.of(context).docs(restDocumentation).secure(false).build();


        // addressGroupRepository.save(AddressGroup.builder().title("그룹1").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹2").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹3").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹4").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹5").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹6").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹7").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹8").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹9").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹10").owner("user1").build());
        // addressGroupRepository.save(AddressGroup.builder().title("그룹11").owner("user1").build());
        em.flush();
        em.clear();
    }




    @Test
    @Transactional
    public void 주소록_생성() throws Exception {

        // $.POST("/addresses").C("name", "Mr. Hong").C("phoneNumber", "01022223333").C("groupIds", new ArrayList<Long>(Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L))).is2xx();
        //  Address address = new Address("Mr. Hong", "01022223333");
        //  addressRepository.save(address);
        //  Long id = address.getId();

        // $.GET("/addresses/" + id).is2xx().andReturn("a1");

        // log.info("{}", (String) $.variables().resolveValue("${a1.$}"));

    }
}
