package com.example.userData;

import com.example.userData.model.User;
import com.example.userData.repository.UserRepository;
import com.example.userData.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UserAddIntegrationTest {
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
 @Autowired
    UserRepository userRepository;

 @Autowired
    UserService userService;

 @Test
public void getAllUsersIntegrationTest(){
     int countBefore = userRepository.findAll().size();
     User testUser = new User();
     testUser.setName("TestUser");
     testUser.setContent("TestContent");
     testUser.setEmail("tryrty@ghjg.ru");
     try {
         Date date=formater.parse("2018-11-28");
         testUser.setBirthday(date);
     } catch (ParseException e) {
         e.printStackTrace();
     }

      userRepository.save(testUser);
     Long testUserId = testUser.getId();
     List<User> users = userService.getAllUsers();
     assertEquals(users.size(), countBefore + 1);
     userService.deleteUser(testUserId);
     List<User> userList = userService.getAllUsers();
     assertEquals(userList.size(),countBefore);
 }

}
