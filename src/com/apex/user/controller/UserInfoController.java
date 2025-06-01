package com.apex.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.apex.user.vo.BankInfo;
import com.apex.user.vo.ContactInfo;
import com.apex.user.vo.PersonalInfo;
import com.apex.user.bo.UserInfoServiceImpl;



@Controller
@SessionAttributes({"personalInfo", "contactInfo", "bankInfo"})
public class UserInfoController{
    
	@Autowired
    private final UserInfoServiceImpl userInfoService;
    
    public UserInfoController(UserInfoServiceImpl userInfoService) {
    	this.userInfoService = userInfoService;
    }
    
    
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
        return "home";  // This will also map to home.jsp
    }
    
    @RequestMapping("/processPersonalInfo.do")
    private String handlePersonalInfo(@ModelAttribute PersonalInfo personalInfo, Model model) 
            {
    	model.addAttribute("personalInfo", personalInfo);
        // Redirect to contact-info.jsp
        return "contact-info";
    }
    
    
    @RequestMapping("/processContactInfo.do")
    private String handleContactInfo(@ModelAttribute ContactInfo contactInfo, Model model) 
            {
    	model.addAttribute("contactInfo", contactInfo);
    	return "bank-info";
    }
    
    @RequestMapping("/processBankInfo.do")
    private String handleBankInfo(@ModelAttribute BankInfo bankInfo, Model model) 
             {
    	model.addAttribute("bankInfo", bankInfo);
        return "redirect:/submit.do";
    }
    
    @RequestMapping("/submit.do")
    private String handleFinalSubmission(@ModelAttribute("personalInfo") PersonalInfo personalInfo,
    	    @ModelAttribute("contactInfo") ContactInfo contactInfo,
    	    @ModelAttribute("bankInfo") BankInfo bankInfo,
    	    Model model
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