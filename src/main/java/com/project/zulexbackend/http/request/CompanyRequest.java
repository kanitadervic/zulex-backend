package com.project.zulexbackend.http.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyRequest {
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
    private String responsiblePerson;
}
