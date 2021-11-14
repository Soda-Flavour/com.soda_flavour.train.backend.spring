package api.crud.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private @Column(name = "id") UUID id;

    private String name;
    private String phoneNumber;

    @JsonIgnore
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<ContactSet> contactSets = new ArrayList<>();


    public void addContactGroups(List<ContactGroup> contactGroups) {
        for(ContactGroup contactGroup : contactGroups){
            ContactSet contactSet= new ContactSet();
            contactSet.setContact(this);
            contactSet.setContactGroup(contactGroup);
            // this.contactSets.add(contactSet);
        }

    }

}
