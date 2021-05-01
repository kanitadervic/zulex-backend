package com.project.zulexbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Integer cityId;
    private String name;
    private String address;
    private String phoneNumber;
    private String faxNumber;
    private String webUrl;
    private String mail;
    private String formOfOwnership;
    private String foundingDate;
    private String idb;
    private String vatNumber;
    private String predominantActivity;
    private String contactPerson;
    private String contactPhone;
    private Integer employeeId;
    private Integer editedBy;
}
