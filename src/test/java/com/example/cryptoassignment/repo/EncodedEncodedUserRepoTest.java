package com.example.cryptoassignment.repo;

import com.example.cryptoassignment.model.EncodedUser;
import com.example.cryptoassignment.model.InsecureUser;
import com.example.cryptoassignment.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EncodedEncodedUserRepoTest {

    @Autowired
    EncodedUserRepo sut;
    @Autowired
    UserService userService;


    @Test
    void should_add_encoded_password_To_database() {
        //Create a java object user, with password abc.
        EncodedUser encodedUser = new EncodedUser(10, "bah","abc");
        //Try to save the same Object in DB.
        sut.save(encodedUser);
        //Retrieve the same user from DB.
        List<EncodedUser> encodedUserFromDatabase = sut.findAllByName("bah");
        //We can't see the password that the user had added when we retrieve it from database.
        System.out.println(encodedUserFromDatabase);

        //However, we can verify, for example, whether the user enters the correct password upon login or not.
        boolean actual = userService.isCorrectPassword("abc", encodedUserFromDatabase.get(0).getPassword());
        assertTrue(actual);
    }
}