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
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class Contact {
    
    @Id @GeneratedValue
    private Long contactId;

    private String digit;
    private String name;
    private String email;

    @OneToMany(mappedBy = "contact")
    @JsonIgnore
    private List<ContactSet> contactSets = new ArrayList<>();

    public static Contact createContact(String digit, String name, String email) {
        return Contact.builder()
                        .digit(digit)
                        .name(name)
                        .email(email)
                    .build();
    }
}
