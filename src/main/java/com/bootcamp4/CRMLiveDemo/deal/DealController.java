package com.bootcamp4.CRMLiveDemo.deal;

import com.bootcamp4.CRMLiveDemo.activity.Activity;
import com.bootcamp4.CRMLiveDemo.company.Company;
import com.bootcamp4.CRMLiveDemo.contact.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/deal")
public class DealController {

    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping()
    public List<Deal> getDeals(){
        return dealService.getDeals();
    }

    @PostMapping()
    public void registerNewDeal(@RequestBody Deal deal){
        dealService.addNewDeal(deal);
    }

    @DeleteMapping(path = "{dealId}")
    public void deleteDeal(@PathVariable("dealId") Long dealId){
        dealService.deleteDeal(dealId);
    }

    @PutMapping()
    public void updateDeal(@RequestBody Deal deal){
        dealService.updateDeal(deal);
    }

    @PostMapping("/addActivity")
    public void addNewActivity(@RequestBody Activity activity, @RequestParam Long dealId){
        dealService.addNewActivity(activity, dealId);
    }

    @PostMapping("/addContact")
    public void addNewContact(@RequestBody Contact contact, @RequestParam Long dealId){
        dealService.addNewContact(contact, dealId);
    }

    @PostMapping("/addCompany")
    public void addNewCompany(@RequestBody Company company, @RequestParam Long dealId){
        dealService.addNewCompany(company, dealId);
    }


}
