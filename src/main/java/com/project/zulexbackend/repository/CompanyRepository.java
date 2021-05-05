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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Repository
@AllArgsConstructor
public class CompanyRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer createCompany(CompanyRequest companyRequest) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Company").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new java.util.HashMap<>(Map.of(
                "cityId", companyRequest.getCityId(),
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
        parameters.put("responsiblePerson", companyRequest.getResponsiblePerson());

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

    public Integer updateCompany(Integer companyId, CompanyRequest companyRequest, Long userId) {

        Integer affectedRows = jdbcTemplate.update("UPDATE Company SET " +
                "cityId = ?," +
                " name = ?," +
                " address = ?," +
                " phoneNumber = ?," +
                " faxNumber = ?," +
                " webUrl = ?," +
                " mail = ?," +
                " formOfOwnership = ?," +
                " foundingDate = ?," +
                " idb = ?," +
                " vatNumber = ?," +
                " predominantActivity = ?," +
                " contactPerson = ?," +
                " contactPhone = ?," +
                " employeeId = ?," +
                " editedBy = ?," +
                " responsiblePerson = ? WHERE id = ?", companyRequest.getCityId(), companyRequest.getName(), companyRequest.getAddress(), companyRequest.getPhoneNumber(), companyRequest.getFaxNumber(), companyRequest.getWebUrl(), companyRequest.getMail(), companyRequest.getFormOfOwnership(), companyRequest.getFoundingDate(), companyRequest.getIdb(), companyRequest.getVatNumber(), companyRequest.getPredominantActivity(), companyRequest.getContactPerson(), companyRequest.getContactPhone(), companyRequest.getEmployeeId(), userId, companyRequest.getResponsiblePerson(), companyId);

        return affectedRows;
    }
}
