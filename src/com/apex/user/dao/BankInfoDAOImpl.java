package com.apex.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apex.user.vo.BankInfo;

@Repository
public class BankInfoDAOImpl implements BankInfoDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
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
