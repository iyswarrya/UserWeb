package com.apex.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apex.user.vo.ContactInfo;

@Repository
public class ContactInfoDAOImpl implements ContactInfoDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
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
	}

