package com.bootcamp4.CRMLiveDemo.contact;

import com.bootcamp4.CRMLiveDemo.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query("Select c from Contact c where c.email = ?1")
    public List<Contact> findContactByEmail(String name);
}
