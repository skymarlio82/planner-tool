
package com.nike.app.planner.boot.email.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("simpleEmailService")
public class SimpleEmailService {

//	@Autowired
//	private JavaMailSender javaMailSender = null;

	public void sendMail(String fromEmail, String toEmail, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom(fromEmail);
//		javaMailSender.send(mailMessage);
	}
}