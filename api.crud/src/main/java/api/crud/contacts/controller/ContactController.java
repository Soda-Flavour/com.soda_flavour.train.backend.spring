package api.crud.contacts.controller;

import org.springframework.web.bind.annotation.RestController;

import api.crud.contacts.dto.ContactCreateReqDto;
import api.crud.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping(value="/contacts")
    public ResponseEntity<?> postMethodName(@RequestBody ContactCreateReqDto request) {       
        return ResponseEntity.ok(contactService.create(request).getContactId());
    }
    
}
