package com.apex.user.bo;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apex.user.dao.BankInfoDAO;
import com.apex.user.dao.ContactInfoDAO;
import com.apex.user.dao.PersonalInfoDAO;
import com.apex.user.vo.BankInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.PersonalInfo;


@Service
public class UserInfoServiceImpl {
	
	@Autowired
    private PersonalInfoDAO personalInfoDAO;
    
    @Autowired
    private ContactInfoDAO contactInfoDAO;
    
    @Autowired
    private BankInfoDAO bankInfoDAO;
    
    @Transactional(rollbackFor = Exception.class)
    public void saveUserInfo(PersonalInfo personalInfo, ContactInfo contactInfo, BankInfo bankInfo) throws SQLException {
    	int pResult = personalInfoDAO.savePersonalInfo(personalInfo);
        int cResult = contactInfoDAO.saveContactInfo(contactInfo);
        int bResult = bankInfoDAO.saveBankInfo(bankInfo);

        if (pResult <= 0 || cResult <= 0 || bResult <= 0) {
            throw new RuntimeException("Failed to save all user information");
        }
    }
    
} 