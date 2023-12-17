package com.project.payment.payments.repositories;

import com.project.payment.payments.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<User, Integer> {
}
