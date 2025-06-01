package com.apex.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apex.user.vo.BankInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.PersonalInfo;

@Repository
public class UserInfoDAOImpl {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    public int savePersonalInfo(PersonalInfo personalInfo) {
        if (personalInfo == null) {
            throw new IllegalArgumentException("PersonalInfo cannot be null");
        }

        String sql = "INSERT INTO personal_info (firstName, lastName, gender) VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql,
                personalInfo.getFirstName(),
                personalInfo.getLastName(),
                personalInfo.getGender());
	}
    
    public int saveContactInfo(ContactInfo contactInfo) {
		
		if (contactInfo == null) {
            throw new IllegalArgumentException("ContactInfo cannot be null");
        }
		
		String sql = "INSERT INTO contact_info (address, city, state, country, phone) VALUES (?, ?, ?, ?, ?)";
		
		return jdbcTemplate.update(sql,
                contactInfo.getAddress(),
                contactInfo.getCity(),
                contactInfo.getState(),
                contactInfo.getCountry(),
                contactInfo.getPhone());
	}
    
    public int saveBankInfo(BankInfo bankInfo)  {
		if (bankInfo == null) {
            throw new IllegalArgumentException("BankInfo cannot be null");
        }

        String sql = "INSERT INTO bank_info (bankName, accountNo, ssn) VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql,
                bankInfo.getBankName(),
                bankInfo.getAccountNo(),
                bankInfo.getSsn());
        
    }
    
    
}
