package com.bootcamp4.CRMLiveDemo.contact;

import com.bootcamp4.CRMLiveDemo.contact.Contact;
import com.bootcamp4.CRMLiveDemo.contact.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }


    public List<Contact> getContactsByEmail(String email){
        return contactRepository.findContactByEmail(email);
    }

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public void addNewContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Long contactId) {
        boolean exists = contactRepository.existsById(contactId);
        if(!exists){
            throw new IllegalStateException("Contact with given Id: "+contactId+" does not exists on the database");
        }
        contactRepository.deleteById(contactId);
    }

    @Transactional
    public void updateContact(Contact contact) {
        boolean exists = contactRepository.existsById(contact.getId());
        if(!exists){
            throw new IllegalStateException("Contact with given Id: "+contact.getId()+" does not exists on the database");
        }
        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());
        contactOptional.get().setName(contact.getName());
    }
}
