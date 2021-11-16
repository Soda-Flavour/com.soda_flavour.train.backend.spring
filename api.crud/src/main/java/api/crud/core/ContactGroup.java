package api.crud.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class ContactGroup {
    
    @Id @GeneratedValue
    private Long contactGroupId;

    private String title;
    private String description;

    @OneToMany(mappedBy = "contactGroup")
    @JsonIgnore
    private List<ContactSet> contactSets = new ArrayList<>();

    public static ContactGroup createContactGroup(String title, String description) {
        return ContactGroup.builder().title(title).description(description).build();
    }
}
