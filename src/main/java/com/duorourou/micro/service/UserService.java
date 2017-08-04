package com.duorourou.micro.service;

import com.duorourou.micro.domain.User;
import com.duorourou.micro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }
}
