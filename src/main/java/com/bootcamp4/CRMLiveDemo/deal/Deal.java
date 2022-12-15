package com.bootcamp4.CRMLiveDemo.deal;

import com.bootcamp4.CRMLiveDemo.activity.Activity;
import com.bootcamp4.CRMLiveDemo.company.Company;
import com.bootcamp4.CRMLiveDemo.contact.Contact;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Deal {

    public enum DealStatus{
        LEAD,
        NEGOTIATION,
        CLOSED,
        LOST
    }

    @Id
    @SequenceGenerator(name = "deal_sequence",sequenceName = "deal_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deal_sequence")
    private long id;
    private String name;
    private LocalDate date;
    @Transient
    private LocalDate lastUpdate;
    private Double value;
    private DealStatus dealStatus;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Contact contact;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Company company;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Activity> activities;

    public Deal() {
    }

    public Deal(long id, String name, LocalDate date, Double value, DealStatus dealStatus, Contact contact, Company company) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.value = value;
        this.dealStatus = dealStatus;
        this.contact = contact;
        this.company = company;
    }

    public Deal(String name, LocalDate date, Double value, DealStatus dealStatus, Contact contact, Company company) {
        this.name = name;
        this.date = date;
        this.value = value;
        this.dealStatus = dealStatus;
        this.contact = contact;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public DealStatus getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(DealStatus dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", lastUpdate=" + lastUpdate +
                ", value=" + value +
                '}';
    }
}
