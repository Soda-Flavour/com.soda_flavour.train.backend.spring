package api.crud.contacts.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.crud.contactGroups.repository.ContactGroupRepository;
import api.crud.contactSets.repository.ContactSetRepository;
import api.crud.contacts.dto.ContactCreateReqDto;
import api.crud.contacts.repository.ContactRepository;
import api.crud.core.Contact;
import api.crud.core.ContactGroup;
import api.crud.core.ContactSet;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactService {
    
    private final ContactRepository contactRepository;
    private final ContactSetRepository contactSetRepository;
    private final ContactGroupRepository contactGroupRepository;

    public Contact create(ContactCreateReqDto request) {
        //주소록 생성
        Contact contact = contactRepository.save(Contact.createContact(
                                                        request.getDigit(), 
                                                        request.getName(), 
                                                        request.getEmail()
                                                    ));
        //그룹 리스트 조회
        List<ContactGroup> contactGroups = contactGroupRepository.findAllById(request.getGroupIds());
                                                    
        //주소록 set 생성
        contactSetRepository.saveAll(ContactSet.createContactSets(contact, contactGroups));

        return contact;

    }
}
