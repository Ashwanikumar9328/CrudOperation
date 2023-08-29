package com.crudoperation.controllers;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudoperation.entities.Lead;
import com.crudoperation.services.LeadService;
import com.crudoperation.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	@Autowired
	private LeadService leadService;
   
	
	// http:localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadForm() {	
		return "create_lead";
	}
	
	// http:localhost:8080/saveLead
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead")Lead lead, Model model) {
		leadService.saveOneLead(lead);
		model.addAttribute("msg","Record is saved");
		emailService.sendEmail(lead.getEmail(), "Welcome", "Test");
		return "create_lead";
	}
		
	
	//second way to read data without using entity class object.
	//@RequestMapping("/saveLead")
	//public String saveLead(@RequestParam("firstName")String firstName,@RequestParam("email") String email,@RequestParam("lastName") String lastName,@RequestParam("mobile") long mobile) {
		
		//Lead lead = new Lead();
		//lead.setEmail(email);
		//lead.setFirstName(firstName);
		//lead.setLastName(lastName);
		//lead.setMobile(mobile);
		//leadService.saveOneLead(lead);
		//System.out.println(firstName);
		//return "create_lead";
	//}
	
	// Data Transfer method DTO 
	//@RequestMapping("/saveLead")
//	public String saveLead(Leaddata leadData) {
//		
//		System.out.println(leadData.getFirstName());
//		System.out.println(leadData.getLastName());
//        System.out.println(leadData.getMobile());
//        System.out.println(leadData.getEmail());
//		
//		return "create_lead";
//		
//	}
//	    @RequestMapping("/saveLead")
//        public String saveLead(Leaddata leadData) {
//		Lead lead = new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setMobile(leadData.getMobile());
//		lead.setEmail(leadData.getEmail());
//		leadService.saveOneLead(lead);
//		return "create_lead";
//		
//	}
	
	 // http:localhost:8080/listall
	 @RequestMapping("/listall")
	 public String listLeads(Model model) {
		 List<Lead> leads = leadService.getAllleads();
		 model.addAttribute("leads",leads);
		 return "list_leads";
	 }
	 
	// http:localhost:8080/delete?id={id}
	 @RequestMapping("/delete")
	 public String deleteOneLead(@RequestParam("id")long id,Model model) {
		 leadService.deleteLead(id);
		 List<Lead> leads = leadService.getAllleads();
		 model.addAttribute("leads",leads);
		 return "list_leads";
		 
	 }
	 
	// http:localhost:8080/update?id={id}
	 @RequestMapping("/update")
	 public String updateOneLead(@RequestParam("id")long id,Model model) {
		 Lead lead = leadService.updateLead(id);
		 model.addAttribute("lead",lead);
		 return "update_lead";
		 
	 }
	
	 
	 @RequestMapping("/updateLead")
		public String updateLead(@ModelAttribute("lead")Lead lead,ModelMap model) {
			leadService.saveOneLead(lead);
			 List<Lead> leads = leadService.getAllleads();
			 model.addAttribute("leads",leads);
			 return "list_leads";
	}
	
}

// @ModelAtrribute help us to take form data and put into entity class object.
// Hibernate take only entity class object data and put it into database.


