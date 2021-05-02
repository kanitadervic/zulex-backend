package com.project.zulexbackend.repository;

import com.project.zulexbackend.http.request.CompanyRequest;
import com.project.zulexbackend.model.Canton;
import com.project.zulexbackend.model.City;
import com.project.zulexbackend.model.Company;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;

@Repository
@AllArgsConstructor
public class CompanyRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer createCompany(CompanyRequest companyRequest) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Company").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new java.util.HashMap<>(Map.of(
                "id", companyRequest.getCityId(),
                "name", companyRequest.getName(),
                "address", companyRequest.getAddress(),
                "phoneNumber", companyRequest.getPhoneNumber(),
                "faxNumber", companyRequest.getFaxNumber(),
                "webUrl", companyRequest.getWebUrl(),
                "mail", companyRequest.getMail(),
                "formOfOwnership", companyRequest.getFormOfOwnership(),
                "foundingDate", companyRequest.getFoundingDate(),
                "idb", companyRequest.getIdb()));

        parameters.put("vatNumber", companyRequest.getVatNumber());
        parameters.put("predominantActivity", companyRequest.getPredominantActivity());
        parameters.put("contactPerson", companyRequest.getContactPerson());
        parameters.put("contactPhone", companyRequest.getContactPhone());
        parameters.put("employeeId", companyRequest.getEmployeeId());
        parameters.put("editedBy", null);

        Integer companyId = jdbcInsert.executeAndReturnKey(parameters).intValue();

        return companyId;
    }

    public Company getCompany(Integer companyId) {
        return jdbcTemplate.queryForObject(String.format("SELECT * FROM Company WHERE id = %d", companyId),
                new BeanPropertyRowMapper<>(Company.class));
    }

    public int deleteCompany(Integer companyId) {
        return jdbcTemplate.update(String.format("DELETE FROM Company WHERE id = %d", companyId));
    }

    public Integer updateCompany(Integer companyId, CompanyRequest companyRequest) {
        deleteCompany(companyId);

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Company").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new java.util.HashMap<>(Map.of(
                "id", companyRequest.getCityId(),
                "name", companyRequest.getName(),
                "address", companyRequest.getAddress(),
                "phoneNumber", companyRequest.getPhoneNumber(),
                "faxNumber", companyRequest.getFaxNumber(),
                "webUrl", companyRequest.getWebUrl(),
                "mail", companyRequest.getMail(),
                "formOfOwnership", companyRequest.getFormOfOwnership(),
                "foundingDate", companyRequest.getFoundingDate(),
                "idb", companyRequest.getIdb()));

        parameters.put("vatNumber", companyRequest.getVatNumber());
        parameters.put("predominantActivity", companyRequest.getPredominantActivity());
        parameters.put("contactPerson", companyRequest.getContactPerson());
        parameters.put("contactPhone", companyRequest.getContactPhone());
        parameters.put("employeeId", companyRequest.getEmployeeId());
        //TODO odrediti ko je uredio zadnji preko principal
        parameters.put("editedBy", null);

        Integer newId = jdbcInsert.executeAndReturnKey(parameters).intValue();

        return newId;
    }
}
