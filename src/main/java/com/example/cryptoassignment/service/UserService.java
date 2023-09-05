package com.example.cryptoassignment.service;

import com.example.cryptoassignment.model.EncodedUser;
import com.example.cryptoassignment.repo.EncodedUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    EncodedUserRepo encodedUserRepo;

    @Autowired
    public UserService(EncodedUserRepo encodedUserRepo) {
        this.encodedUserRepo = encodedUserRepo;
    }

    public List<EncodedUser> getAll() {
        return encodedUserRepo.findAllByName("name");
    }

/*    public List<User2> getAll() {
        return userRepo.findAllByName2("name");
    }*/
    public boolean isCorrectPassword(String rawPassword, String encodedPass) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPass);
    }

    public String isNotCryptPassword(String plainPassword){
        System.out.println(plainPassword);
        return plainPassword;
    }
}
