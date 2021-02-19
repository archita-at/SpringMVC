package net.codejava.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import net.codejava.springmvc.model.Contact;

/**
 * Defines DAO operations for the contact model
 *
 */
@Service
public interface ContactDAO {
	
	public void saveOrUpdate(Contact contact);
	
	public void delete(int contactId);
	
	public Contact get(int contactId);
	
	public List<Contact> list();

}
