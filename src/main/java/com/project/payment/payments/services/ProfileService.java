package com.project.payment.payments.services;

import com.project.payment.payments.exceptions.NotAllowedException;
import com.project.payment.payments.models.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    public User saveProfile(User user) throws Exception {
        validateProfile(user);
        return user;
    }
    private void validateProfile(User user) throws Exception {
        try{
            if(user.name() == null || user.email() == null ||
                    user.dob() == null || user.phoneNumber()== null){
                throw new NotAllowedException("Essential Info Not Provided");
            }
            if(user.name().isBlank()){
                throw new NotAllowedException(("Name cannot be blank"));
            }
            if(user.email().isBlank()){
                throw new NotAllowedException(("Email cannot be blank"));
            }
            if(user.phoneNumber().isBlank()){
                throw new NotAllowedException("Phone Number cannot be blank");
            }
            if(user.phoneNumber().length() != 10){
                throw new NotAllowedException("Phone Number should have 10 digits");
            }
            if(user.dob() < 0 || user.dob() > System.currentTimeMillis()){
                throw new NotAllowedException("Invalid date of birth");
            }
        }catch (Exception e){
            throw new NotAllowedException(e.getMessage());
        }
    }
}
