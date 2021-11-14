package api.crud.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "contact_sets")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ContactSet {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_group_id")
    private ContactGroup contactGroup;


    // private void setContact(Contact contact) {
    //     this.contact = contact;
    //     contact.getContactSets().add(this);
    // }

    // private void setContactGroup(ContactGroup contactGroup) {
    //     this.contactGroup = contactGroup;
    //     contactGroup.getContactSets().add(this);     
    // }


    // public static List<ContactSet> createContactSets(Contact contact, List<ContactGroup> contactGroups) {
    //     List<ContactSet> contactSets = new ArrayList<>();
    //     for(ContactGroup contactGroup : contactGroups){
    //         ContactSet contactSet = new ContactSet();
    //         contactSet.setContact(contact);
    //         contactSet.setContactGroup(contactGroup);
    //         contactSets.add(contactSet);
    //     } 
    //     return contactSets;
    // }

    ////////////////////////////////////////////////////////////
    // 연관관계 메서드
    ////////////////////////////////////////////////////////////
    // public void setContact(Contact contact) {
    //     log.info("디스 : {}", this);
    //     contact.getContactSets().add(this);
    //     this.contact = contact;
    // }

    // public void setContactGroup(ContactGroup contactGroup) {
    //     contactGroup.getContactSets().add(this);
    //     this.contactGroup = contactGroup;
    // }


    ////////////////////////////////////////////////////////////
    // 생성 메서드
    ////////////////////////////////////////////////////////////
    public static List<ContactSet> createContactSets(Contact contact, List<ContactGroup>  contactGroups) {        

        List<ContactSet> contactSetList = new ArrayList<ContactSet>();
        for(ContactGroup contactGroup : contactGroups){
            ContactSet contactSet = new ContactSet();  
            contactSet.setContact(contact);
            contactSet.setContactGroup(contactGroup);
            contactSetList.add(contactSet);
        }

        return contactSetList;

    }


}
