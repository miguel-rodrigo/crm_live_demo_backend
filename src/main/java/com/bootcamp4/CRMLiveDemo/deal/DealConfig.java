package com.bootcamp4.CRMLiveDemo.deal;

import com.bootcamp4.CRMLiveDemo.activity.Activity;
import com.bootcamp4.CRMLiveDemo.company.Company;
import com.bootcamp4.CRMLiveDemo.contact.Contact;
import com.bootcamp4.CRMLiveDemo.contact.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DealConfig {
    @Bean
    CommandLineRunner commandLineRunnerDeal(DealRepository repository){
        return args -> {
            Contact miguel = new Contact("Miguel","Rodrigo","645069493","miguel.rodrigo@email.com");
            Contact david = new Contact("David","De la torre","648245642","david.delatorre@email.com");

            Company cima = new Company("Cima Horizons", "https://bootcamp4.com", "Avenida República Argentina", "Metaverso");
            Company ggmnasium = new Company("GGmnasium", "https://ggmnasium.com", "Avenida De la Borbolla", "LOL");

            Deal metaverse_app = new Deal("App in the Metaverse", LocalDate.now(), 1500.00, Deal.DealStatus.LEAD, david, cima);
            Deal lol_app = new Deal("LOL Analytics", LocalDate.now(), 500.00, Deal.DealStatus.NEGOTIATION, miguel, ggmnasium);

            Activity mail_activity = new Activity(LocalDate.now(), "This is a mail Activity", Activity.ActivityType.MAIL);
            Activity phone_activity = new Activity(LocalDate.now(), "This is a mail Activity", Activity.ActivityType.CALL);

            metaverse_app.setActivities(List.of(mail_activity,phone_activity));

            repository.saveAll(List.of(metaverse_app,lol_app));
        };
    }
}
