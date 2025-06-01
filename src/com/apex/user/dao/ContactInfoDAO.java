package com.apex.user.dao;

import java.sql.Connection;

import com.apex.user.vo.ContactInfo;

public interface ContactInfoDAO {
	public int saveContactInfo(ContactInfo contactInfo);
}
