package com.apex.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apex.user.vo.PersonalInfo;

@Repository
public class PersonalInfoDAOImpl implements PersonalInfoDAO{
    
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
    }
