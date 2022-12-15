package com.bootcamp4.CRMLiveDemo.deal;

import com.bootcamp4.CRMLiveDemo.activity.Activity;
import com.bootcamp4.CRMLiveDemo.activity.ActivityRepository;
import com.bootcamp4.CRMLiveDemo.activity.ActivityService;
import com.bootcamp4.CRMLiveDemo.company.Company;
import com.bootcamp4.CRMLiveDemo.contact.Contact;
import com.bootcamp4.CRMLiveDemo.deal.Deal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealService {

    private final DealRepository dealRepository;

    @Autowired
    public DealService(DealRepository dealRepository){
        this.dealRepository = dealRepository;
    }


    public List<Deal> getDeals(){
        return dealRepository.findAll();
    }

    public void addNewDeal(Deal deal) {
        dealRepository.save(deal);
    }

    public void deleteDeal(Long dealId) {
        boolean exists = dealRepository.existsById(dealId);
        if(!exists){
            throw new IllegalStateException("Deal with given Id: "+dealId+" does not exists on the database");
        }
        dealRepository.deleteById(dealId);
    }

    @Transactional
    public void updateDeal(Deal deal) {
        boolean exists = dealRepository.existsById(deal.getId());
        if(!exists){
            throw new IllegalStateException("Deal with given Id: "+deal.getId()+" does not exists on the database");
        }
        Optional<Deal> dealOptional = dealRepository.findById(deal.getId());
        dealOptional.get().setName(deal.getName());
    }

    public void addNewActivity(Activity activity, Long dealId) {
        boolean exists = dealRepository.existsById(dealId);
        if(!exists){
            throw new IllegalStateException("Deal with given Id: "+dealId+" does not exists on the database");
        }
        Optional<Deal> dealOptional = dealRepository.findById(dealId);
        Deal deal = dealOptional.get();
        deal.getActivities().add(activity);
        deal.setLastUpdate(activity.getDate());
        dealRepository.save(deal);
    }

    public void addNewContact(Contact contact, Long dealId) {
        boolean exists = dealRepository.existsById(dealId);
        if(!exists){
            throw new IllegalStateException("Deal with given Id: "+dealId+" does not exists on the database");
        }
        Optional<Deal> dealOptional = dealRepository.findById(dealId);
        Deal deal = dealOptional.get();
        deal.setContact(contact);
        dealRepository.save(deal);
    }

    public void addNewCompany(Company company, Long dealId) {
        boolean exists = dealRepository.existsById(dealId);
        if(!exists){
            throw new IllegalStateException("Deal with given Id: "+dealId+" does not exists on the database");
        }
        Optional<Deal> dealOptional = dealRepository.findById(dealId);
        Deal deal = dealOptional.get();
        deal.setCompany(company);
        dealRepository.save(deal);
    }
}
