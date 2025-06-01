package com.apex.user.bo;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.apex.user.dao.UserInfoDAOImpl;
import com.apex.user.vo.BankInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.PersonalInfo;


@Service
public class UserInfoServiceImpl {
    
    @Autowired
    private UserInfoDAOImpl userInfoDAO;
    
    @Transactional(rollbackFor = Exception.class)
    public void saveUserInfo(PersonalInfo personalInfo, ContactInfo contactInfo, BankInfo bankInfo) throws SQLException {
    	int pResult = userInfoDAO.savePersonalInfo(personalInfo);
        int cResult = userInfoDAO.saveContactInfo(contactInfo);
        int bResult = userInfoDAO.saveBankInfo(bankInfo);

        if (pResult <= 0 || cResult <= 0 || bResult <= 0) {
            throw new RuntimeException("Failed to save all user information");
        }
    }
    
} 