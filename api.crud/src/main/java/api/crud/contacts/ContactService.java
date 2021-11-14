package api.crud.contacts;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.crud.contactGroups.ContactGroupRepository;
import api.crud.contactSets.ContactSetRepository;
import api.crud.core.Contact;
import api.crud.core.ContactGroup;
import api.crud.core.ContactSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ContactService {
    
    private final ContactRepository contactRepository;
    private final ContactSetRepository contactSetRepository;
    private final ContactGroupRepository contactGroupRepository;
    private final EntityManager em;


    @Transactional
    public UUID contact(Contact contact, List<UUID> contactGroupIds) {
        
        List<ContactGroup> contactGroups = contactGroupRepository.findAllByIds(contactGroupIds);

        contact.addContactGroups(contactGroups);
        
        contactRepository.save(contact);
        

        return contact.getId();

    }
}
