package api.crud.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class ContactSet {
    
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_group_id")
    private ContactGroup contactGroup;

    public static List<ContactSet> createContactSets(Contact contact, List<ContactGroup> contactGroups) {
        List<ContactSet> contactSets = new ArrayList<>();

        contactGroups.stream().forEach((contactGroup)->{
            contactSets.add(ContactSet.builder()
                                        .contact(contact)
                                        .contactGroup(contactGroup)
                                    .build());
        });

        return contactSets;
    }
}
