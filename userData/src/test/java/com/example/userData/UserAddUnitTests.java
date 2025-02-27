package com.example.userData;

import com.example.userData.model.User;
import com.example.userData.repository.UserRepository;
import com.example.userData.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.print.PrintException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAddUnitTests {
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void getAllUserTest() {

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
        List<User> expectedUsers= Collections.singletonList(testUser);
        when(userRepository.findAll()).thenReturn(expectedUsers);
        List<User> actualUsers=userService.getAllUsers();
        assertEquals(expectedUsers,actualUsers);
    }

    private void setUsers(){
        User user1 = new User();
        user1.setName("Bill");
        User user2 = new User();
        user2.setName("John");
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(user1);
        expectedUsers.add(user2);
        when(userRepository.findAll()).thenReturn(expectedUsers);
    }

    @Test
    public void addUserTest(){
        setUsers();
        assertEquals(userService.getAllUsers().size(),2);
    }


}
