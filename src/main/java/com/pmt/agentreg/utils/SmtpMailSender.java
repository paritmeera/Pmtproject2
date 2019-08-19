package com.pmt.agentreg.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	
	@Autowired
	JavaMailSender javamailsender;
	
	public void send(String to,String subject,String body) throws MessagingException
	{
		MimeMessage message = javamailsender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); //true
		
		helper.setTo(to);
		helper.setText(body, true);
		helper.setSubject(subject);
		
		javamailsender.send(message);
	}

}
