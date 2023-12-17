package com.project.payment.payments.controllers;
import com.project.payment.payments.models.Profile;
import com.project.payment.payments.services.ProfileService;
import com.project.payment.payments.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.payment.payments.Constants.PAYMENT_APP_BASE_PATH;

@RestController
@RequestMapping(PAYMENT_APP_BASE_PATH + "/profiles")
public class ProfileController {
    private ProfileService profileService;

    @Autowired
    ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }
    @PostMapping("/profile")
    public ResponseEntity<Object> saveProfile(
            @RequestBody Profile profile,
            @RequestHeader("Authorization") String token
            ) throws Exception {
        //authenticate request
        Profile response = profileService.saveProfile(profile);
        return ResponseHandler.create(response);
    }

    @GetMapping()
    public ResponseEntity<Object> getProfiles(
            @RequestHeader("Authorization") String token,
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "offset", required = false) Integer offset,
            @RequestParam(name = "projections", required = false) String projections,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "filters", required = false) String filters
    ) throws Exception{
        //authenticate token
        List<Profile> response;
        response = profileService.getProfiles(
                limit, offset, search, projections, filters
        );
        return ResponseHandler.ok(response);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Object> getProfileById(
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Integer id
    ) throws Exception{
        //authenticate token
        Profile response = profileService.getProfileById(id);
        return ResponseHandler.create(response);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Object> updateProfile(
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Integer id,
            @RequestBody Profile profile
    ) throws Exception{
        //authenticate token
        Profile response = profileService.updateProfile(
                id,
                profile
        );
        return ResponseHandler.ok(response);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<Object> deleteProfile(
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Integer id
    ){
        //authenticate token
        Boolean response = profileService.deleteProfile(id);
        return ResponseHandler.ok(response);
    }
}
