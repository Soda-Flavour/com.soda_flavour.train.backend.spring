package api.crud.contacts;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import api.crud.core.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact,UUID>, JpaSpecificationExecutor<Contact> {
    
}
