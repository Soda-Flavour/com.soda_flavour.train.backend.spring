package api.crud.contacts;


import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import api.crud.contactGroups.repository.ContactGroupRepository;
import api.crud.contactSets.repository.ContactSetRepository;
import api.crud.contacts.dto.ContactCreateReqDto;
import api.crud.contacts.service.ContactService;
import api.crud.core.Contact;
import api.crud.core.ContactGroup;
import api.crud.core.ContactSet;

@SpringBootTest
@Transactional
public class ContactTest {
    
    private @Autowired ContactGroupRepository contactGroupRepository;
    private @Autowired ContactSetRepository contactSetRepository;
    private @Autowired ContactService contactService;

    @Test
    public void createContactWithGroup() {

        //given
        ContactGroup g1 = contactGroupRepository.save(ContactGroup.createContactGroup("그룹1", ""));
        ContactGroup g2 = contactGroupRepository.save(ContactGroup.createContactGroup("그룹2", ""));
        ContactGroup g3 = contactGroupRepository.save(ContactGroup.createContactGroup("그룹3", ""));
        ContactGroup g4 = contactGroupRepository.save(ContactGroup.createContactGroup("그룹4", ""));


        //when
        
        List<Long> groupIds = new ArrayList<>();
                    groupIds.add(g1.getContactGroupId());
                    groupIds.add(g2.getContactGroupId());
                    groupIds.add(g3.getContactGroupId());
                    groupIds.add(g4.getContactGroupId());

        ContactCreateReqDto contactDto = ContactCreateReqDto.builder().digit("digit").name("홍길동").groupIds(groupIds).build();
        contactService.create(contactDto);
        

        //then
        List<ContactSet> contactSets = contactSetRepository.findAll();

        Assertions.assertThat(contactSets.size()).isEqualTo(4);

        Assertions.assertThat(contactSets).extracting("contactGroup.contactGroupId").containsExactly(g1.getContactGroupId(),g2.getContactGroupId(),g3.getContactGroupId(),g4.getContactGroupId());

    }
}
