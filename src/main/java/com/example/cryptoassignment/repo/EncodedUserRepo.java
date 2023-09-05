package com.example.cryptoassignment.repo;

import com.example.cryptoassignment.model.EncodedUser;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EncodedUserRepo extends CrudRepository<EncodedUser, Long> {

    List<EncodedUser> findAllByName(String name);

}
