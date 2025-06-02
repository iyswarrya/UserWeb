package com.apex.user.bo;

import com.apex.user.vo.BankInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.PersonalInfo;

public interface UserInfoService {
	public void saveUserInfo(PersonalInfo personalInfo, ContactInfo contactInfo, BankInfo bankInfo) throws Exception; 
}
