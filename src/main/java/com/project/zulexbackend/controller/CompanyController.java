package com.project.zulexbackend.controller;

import com.project.zulexbackend.http.request.CompanyRequest;
import com.project.zulexbackend.http.response.ZulexResponse;
import com.project.zulexbackend.model.Company;
import com.project.zulexbackend.service.CompanyService;
import com.project.zulexbackend.service.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
public class CompanyController {

    private CompanyService companyService;

    @PostMapping("/company")
    public ZulexResponse createCompany(@RequestBody CompanyRequest companyRequest) {
        Integer companyId = companyService.createCompany(companyRequest);

        return new ZulexResponse<>(200, companyId, "OK");
    }

    @GetMapping("/company")
    public ZulexResponse getCompany(@RequestParam("companyId") Integer companyId) {
        Company company = companyService.getCompany(companyId);

        return new ZulexResponse<>(200, company, "OK");
    }

    @DeleteMapping("/company")
    public ResponseEntity<Integer> deleteCompany(@RequestParam("companyId") Integer companyId) {
        int isRemoved = companyService.deleteCompany(companyId);
        if (isRemoved != 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companyId, HttpStatus.OK);
    }

    @PutMapping("/company")
    public ResponseEntity updateCompany(@RequestParam("companyId") Integer companyId, @RequestBody CompanyRequest companyRequest, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        Integer affectedRows = companyService.updateCompany(companyId, companyRequest, userDetails.getId());

        if(affectedRows == 1) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
