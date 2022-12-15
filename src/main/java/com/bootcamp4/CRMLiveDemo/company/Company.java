package com.bootcamp4.CRMLiveDemo.company;

import jakarta.persistence.*;

@Entity
@Table
public class Company {

    @Id
    @SequenceGenerator(name = "company_sequence",sequenceName = "company_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    private Long id;

    private String name;
    private String webpage;
    private String address;
    private String sector;

    public Company() {
    }

    public Company(Long id, String name, String webpage, String address, String sector) {
        this.id = id;
        this.name = name;
        this.webpage = webpage;
        this.address = address;
        this.sector = sector;
    }

    public Company(String name, String webpage, String address, String sector) {
        this.name = name;
        this.webpage = webpage;
        this.address = address;
        this.sector = sector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", webpage='" + webpage + '\'' +
                ", address='" + address + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
