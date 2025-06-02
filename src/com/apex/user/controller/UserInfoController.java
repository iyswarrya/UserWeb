package com.apex.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apex.user.bo.UserInfoService;
import com.apex.user.vo.BankInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.PersonalInfo;



@Controller
@SessionAttributes({"personalInfo", "contactInfo", "bankInfo"})
public class UserInfoController{
    
	@Autowired
    private UserInfoService userInfoService;
    
    
    
    
    @ModelAttribute("personalInfo")
    public PersonalInfo getPersonalInfo() {
        return new PersonalInfo();
    }
    
    @ModelAttribute("contactInfo")
    public ContactInfo getContactInfo() {
        return new ContactInfo();
    }
    
    @ModelAttribute("bankInfo")
    public BankInfo getBankInfo() {
        return new BankInfo();
    }

    @GetMapping("/home.do")
    public String homePage() {
        return "home";  // This will map to home.jsp
    }
    
    @RequestMapping("/processPersonalInfo.do")
    private String handlePersonalInfo(@ModelAttribute("personalInfo") PersonalInfo personalInfo) 
            {
        // Redirect to contact-info.jsp
        return "contact-info";
    }
    
    
    @RequestMapping("/processContactInfo.do")
    private String handleContactInfo(@ModelAttribute("contactInfo") ContactInfo contactInfo) 
            {
    	
    	return "bank-info";
    }
    
    @RequestMapping("/processBankInfo.do")
    private String handleBankInfo(@ModelAttribute("bankInfo") BankInfo bankInfo) 
             {
 
        return "redirect:/submit.do";
    }
    
    @RequestMapping("/submit.do")
    private String handleFinalSubmission(@SessionAttribute("personalInfo") PersonalInfo personalInfo,
    		@SessionAttribute("contactInfo") ContactInfo contactInfo,
    		@SessionAttribute("bankInfo") BankInfo bankInfo
            ) 
             {
        
        try {
        	System.out.println(personalInfo.getFirstName());
        	System.out.println(contactInfo.getAddress());
        	System.out.println(bankInfo.getBankName());
        	userInfoService.saveUserInfo(personalInfo, contactInfo, bankInfo);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
} 