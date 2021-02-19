package net.codejava.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin("*")
@Controller
public class SendEmailController {
	Logger logger = Logger.getLogger(SendEmailController.class);
	@Autowired JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public String showEmailForm() {
		return "EmailForm";
	}
	
	@RequestMapping(value = "/sendEmail.do", method = RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request) {
		//takes input from e-mail form
		String recipientAddress = request.getParameter("recipient");
		String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
        //prints debug info
        logger.info("To : "+ recipientAddress);
        logger.info("Subject : "+ subject);
        logger.info("Message : "+ message);
        
        //creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
        
        //sends the e-mail
        mailSender.send(email);
        
        //forwards to the view named "Result"
        return "Result";
	}

}
