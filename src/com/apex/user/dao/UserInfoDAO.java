package com.apex.user.dao;
import com.apex.user.vo.PersonalInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.BankInfo;

public interface UserInfoDAO {

	public int savePersonalInfo(PersonalInfo personalInfo);
	
	public int saveContactInfo(ContactInfo contactInfo);
	
	public int saveBankInfo(BankInfo bankInfo);
	
}
