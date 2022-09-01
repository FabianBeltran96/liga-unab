package com.unab.services;

import com.unab.models.User;
import com.unab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(Long id) {
        User userFind = userRepository.findUserById(id);
        System.out.println(userFind);
        return userFind;
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public static void main(String[] args) {

    }

}
