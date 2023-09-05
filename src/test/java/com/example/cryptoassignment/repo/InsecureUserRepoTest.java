package com.example.cryptoassignment.repo;

import com.example.cryptoassignment.model.InsecureUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InsecureUserRepoTest {

    @Autowired
    InsecureUserRepo sut;

    @Test
    void should_add_plain_password_To_database(){
        //Create a java object user, with password def.
        InsecureUser insecureUser = new InsecureUser(22, "Sam","def");
        //Try to save the same Object in DB.
        sut.save(insecureUser);
        //Retrieve the same user from DB.
        List<InsecureUser> userFromDatabase1 = sut.findAll();
        //We can see the password that the user had added when we retrieve it from database.
        System.out.println(userFromDatabase1);
    }
}