package com.soda_flavour.train.spring.cruds.addresses.controller.request;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class AddressCreateRequest {
    private String name;
    private String phoneNumber;
    private List<Long> groupIds;
}
