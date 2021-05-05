package com.project.zulexbackend.service;

import com.project.zulexbackend.http.request.CompanyRequest;
import com.project.zulexbackend.model.Company;
import com.project.zulexbackend.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;

    public Integer createCompany(CompanyRequest companyRequest) {
        return companyRepository.createCompany(companyRequest);
    }

    public Company getCompany(Integer companyId) {
        return companyRepository.getCompany(companyId);
    }

    public int deleteCompany(Integer companyId) {
        return companyRepository.deleteCompany(companyId);
    }

    public Integer updateCompany(Integer companyId, CompanyRequest companyRequest, Long id) {
        return companyRepository.updateCompany(companyId, companyRequest, id);
    }
}
