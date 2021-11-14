package api.crud.contactGroups;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import api.crud.core.ContactGroup;

public interface ContactGroupRepository extends PagingAndSortingRepository<ContactGroup, UUID>, JpaSpecificationExecutor<ContactGroup> {
    @Query(value = "select cg from ContactGroup cg where cg.id in :orderIds")
    List<ContactGroup> findAllByIds(@Param("orderIds") List<UUID> orderIds);
}
