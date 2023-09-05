package com.example.cryptoassignment.repo;

import com.example.cryptoassignment.model.InsecureUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsecureUserRepo extends CrudRepository<InsecureUser, Long> {
    List<InsecureUser> findAll();
}
