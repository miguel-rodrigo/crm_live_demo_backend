package com.bootcamp4.CRMLiveDemo.contact;

import com.bootcamp4.CRMLiveDemo.contact.Contact;
import com.bootcamp4.CRMLiveDemo.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public List<Contact> getContacts(){
        return contactService.getContacts();
    }

    @PostMapping()
    public void registerNewContact(@RequestBody Contact contact){
        contactService.addNewContact(contact);
    }
    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId){
        contactService.deleteContact(contactId);
    }

    @PutMapping()
    public void updateContact(@RequestBody Contact contact){
        contactService.updateContact(contact);
    }
}
