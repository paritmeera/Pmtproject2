package com.pmt.agentreg.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMailService 
{
	
	private static final Logger logger=LoggerFactory.getLogger("RegistrationMailService");
	
	@Autowired
    private JavaMailSender sender;
	
	public String sendMail(String to,String subject,String body) 
    {	
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try 
        	{
            helper.setTo(to);
            helper.setText(body);
            helper.setSubject(subject);
            sender.send(message);
            logger.info("Mail Sent Successfully..!!");
        	} 
        catch (MessagingException e)
        {
            e.printStackTrace();
            logger.info("Oops...!!Error while sending mail...");  
        }
        return "Mail Sent Successfully..!";
    }
}
