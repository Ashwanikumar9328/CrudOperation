package com.crudoperation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String to, String sub, String msg) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("your_email-Id");
		mailMessage.setTo(to);
		mailMessage.setSubject(sub);
		mailMessage.setText(msg);
		mailSender.send(mailMessage);
	}
}

