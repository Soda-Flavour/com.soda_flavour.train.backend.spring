package api.crud.contacts.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ContactCreateReqDto {
    private String name;
    private String digit;
    private String email;
    private List<Long> groupIds;
}
