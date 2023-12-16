package com.project.payment.payments.controllers;
import com.project.payment.payments.Constants;
import com.project.payment.payments.models.User;
import com.project.payment.payments.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    private final String basePath = Constants.PROFILE_BASE_PATH;
    private ProfileService profileService;

    @Autowired
    ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }
    @PostMapping(basePath+"/profiles")
    public ResponseEntity<User> saveProfile(
            @RequestBody User user,
            @RequestHeader("Authorization") String token
            ) throws Exception {
        //authenticate request
        User response = profileService.saveProfile(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
