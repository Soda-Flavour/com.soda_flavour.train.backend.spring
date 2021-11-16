package api.crud.contactGroups.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.crud.core.ContactGroup;

public interface ContactGroupRepository extends JpaRepository<ContactGroup, Long> {

}
