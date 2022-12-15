package com.bootcamp4.CRMLiveDemo.activity;

import com.bootcamp4.CRMLiveDemo.activity.Activity;
import com.bootcamp4.CRMLiveDemo.activity.ActivityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }


    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    public void addNewActivity(Activity activity) {
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId) {
        boolean exists = activityRepository.existsById(activityId);
        if(!exists){
            throw new IllegalStateException("Activity with given Id: "+activityId+" does not exists on the database");
        }
        activityRepository.deleteById(activityId);
    }

    @Transactional
    public void updateActivity(Activity activity) {
        boolean exists = activityRepository.existsById(activity.getId());
        if(!exists){
            throw new IllegalStateException("Activity with given Id: "+activity.getId()+" does not exists on the database");
        }
        Optional<Activity> activityOptional = activityRepository.findById(activity.getId());
    }


}
