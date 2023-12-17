package com.project.payment.payments.services;

import com.project.payment.payments.exceptions.NotAllowedException;
import com.project.payment.payments.models.User;
import com.project.payment.payments.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;
    @Autowired
    ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }
    public User saveProfile(User user) throws Exception {
        validateProfile(user);
        profileRepository.save(user);
        return user;
    }
    private void validateProfile(User user) throws Exception {
        try{
            if(user.getName() == null || user.getEmail() == null ||
                    user.getDob() == null || user.getPhoneNumber()== null){
                throw new NotAllowedException("Essential Info Not Provided");
            }
            if(user.getName().isBlank()){
                throw new NotAllowedException(("Name cannot be blank"));
            }
            if(user.getEmail().isBlank()){
                throw new NotAllowedException(("Email cannot be blank"));
            }
            if(user.getPhoneNumber().isBlank()){
                throw new NotAllowedException("Phone Number cannot be blank");
            }
            if(user.getPhoneNumber().length() != 10){
                throw new NotAllowedException("Phone Number should have 10 digits");
            }
            if(user.getDob() < 0 || user.getDob() > System.currentTimeMillis()){
                throw new NotAllowedException("Invalid date of birth");
            }
        }catch (Exception e){
            throw new NotAllowedException(e.getMessage());
        }
    }
}
