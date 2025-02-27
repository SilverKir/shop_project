package com.example.userData.services;

import com.example.userData.model.User;
import com.example.userData.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        User deletedUser = getUserById(id);
        userRepository.deleteById(id);
        userRoleService.deleteUser(id);
        return deletedUser;
    }

    public void deleteAllById(List<Long> usersIdList){
        userRepository.deleteAllById(usersIdList);
        userRoleService.deleteAllByUserId(usersIdList);
    }
}
