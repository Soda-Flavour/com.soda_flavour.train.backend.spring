package oauth2.server.users.controller.request;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class AddressCreateRequest {
    private String name;
    private String phoneNumber;
}
