package com.project.payment.payments.repositories;

import com.project.payment.payments.models.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    public default List<Profile> findByFilters(
            String filters,
            String search,
            String projections,
            Integer limit,
            Integer offset
    ){
        return new ArrayList<>();
    }
}
