package api.crud.contactSets;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import api.crud.core.ContactSet;

public interface ContactSetRepository extends PagingAndSortingRepository<ContactSet, UUID>, JpaSpecificationExecutor<ContactSet>  {
    
}
