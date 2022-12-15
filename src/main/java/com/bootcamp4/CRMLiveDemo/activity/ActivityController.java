package com.bootcamp4.CRMLiveDemo.activity;

import com.bootcamp4.CRMLiveDemo.activity.Activity;
import com.bootcamp4.CRMLiveDemo.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping()
    public List<Activity> getActivitys(){
        return activityService.getActivities();
    }

    @PostMapping()
    public void registerNewActivity(@RequestBody Activity activity){
        activityService.addNewActivity(activity);
    }
    @DeleteMapping(path = "{activityId}")
    public void deleteActivity(@PathVariable("activityId") Long activityId){
        activityService.deleteActivity(activityId);
    }

    @PutMapping()
    public void updateActivity(@RequestBody Activity activity){
        activityService.updateActivity(activity);
    }
}
