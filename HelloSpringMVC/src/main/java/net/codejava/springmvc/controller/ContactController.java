package net.codejava.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.springmvc.dao.ContactDAO;
import net.codejava.springmvc.model.Contact;

@Controller
public class ContactController {
	
	@Autowired
	private ContactDAO contactDAO;
	
	//handler method for displaying all contacts
	@RequestMapping(value="/contacts")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("contacts");
		return model;
	}
	
	//handler method for displaying new contact form
	@RequestMapping(value="/newContact", method= RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact",newContact);
		model.setViewName("ContactForm");
		return model;
	}
	
	//handler method for inserting/updating a contact
	@RequestMapping(value="/saveContact", method=RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDAO.saveOrUpdate(contact);
		return new ModelAndView("redirect:/contacts");
	}
	
	//Handler method for deleting contact
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/contacts");
	}
	
	//handler method for retrieving details of a particular contact for editing
	@RequestMapping(value="/editContact", method=RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		return model;
	}

}
