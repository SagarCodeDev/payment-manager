package com.project.payment.payments.services;

import com.project.payment.payments.exceptions.NotAllowedException;
import com.project.payment.payments.models.Profile;
import com.project.payment.payments.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;
    @Autowired
    ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }
    public Profile saveProfile(@NotNull Profile profile) throws Exception {
        validateProfile(profile);
        ensureProfile(profile);
        profileRepository.save(profile);
        return profile;
    }
    private void ensureProfile(@NotNull Profile profile){
        profile.setCreatedAt(System.currentTimeMillis());
    }
    private void validateProfile(Profile profile) throws Exception {
        try{
            if(profile.getName() == null || profile.getEmail() == null ||
                    profile.getDob() == null || profile.getPhoneNumber()== null){
                throw new NotAllowedException("Essential Info Not Provided");
            }
            if(profile.getName().isBlank()){
                throw new NotAllowedException(("Name cannot be blank"));
            }
            if(profile.getEmail().isBlank()){
                throw new NotAllowedException(("Email cannot be blank"));
            }
            if(profile.getPhoneNumber().isBlank()){
                throw new NotAllowedException("Phone Number cannot be blank");
            }
            if(profile.getPhoneNumber().length() != 10){
                throw new NotAllowedException("Phone Number should have 10 digits");
            }
            if(profile.getDob() < 0 || profile.getDob() > System.currentTimeMillis()){
                throw new NotAllowedException("Invalid date of birth");
            }
        }catch (Exception e){
            throw new NotAllowedException(e.getMessage());
        }
    }

    public ArrayList<Profile> getProfiles(
            Integer limit,
            Integer offset,
            String search,
            String projections,
            String filters
    ){
        return (ArrayList<Profile>) profileRepository.findAll();
    }

    public Profile getProfileById(
            Integer id
    ){
        Optional<Profile> result =  profileRepository.findById(id);
        return result.orElse(null);
    }

    public Profile updateProfile(Integer id, Profile profile) throws Exception {
        //TODO - After implementing custom repo layer
        validateProfile(profile);
        return profile;
    }

    public Boolean deleteProfile(Integer id) {
        try {
            profileRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
