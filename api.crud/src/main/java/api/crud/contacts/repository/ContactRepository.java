package api.crud.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.crud.core.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
