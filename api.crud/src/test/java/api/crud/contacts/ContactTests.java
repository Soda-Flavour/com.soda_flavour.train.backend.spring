package api.crud.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import api.crud.contactGroups.ContactGroupRepository;
import api.crud.core.Contact;
import api.crud.core.ContactGroup;

@SpringBootTest
@Transactional
@Rollback(false)
public class ContactTests {

    private @Autowired ContactService contactService;
    private @Autowired ContactGroupRepository contactGroupRepository;

    private @Autowired EntityManager em;


    @Test
    public void createContact() {
        UUID id1 = contactGroupRepository.save(ContactGroup.builder().title("그룹1").build()).getId();
        UUID id2 = contactGroupRepository.save(ContactGroup.builder().title("그룹2").build()).getId();

      em.flush();
      em.clear();

        List<UUID> groupIds = new ArrayList<>();
        groupIds.add(id1);
        groupIds.add(id2);

        Contact contact = Contact.builder().name("홍길동").phoneNumber("01022223333").build();

        contactService.contact(contact, groupIds);
        
    }
}
