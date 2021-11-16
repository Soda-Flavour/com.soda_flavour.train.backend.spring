package api.crud.contactSets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.crud.core.ContactSet;

public interface ContactSetRepository extends JpaRepository<ContactSet, Long> {
    
}
