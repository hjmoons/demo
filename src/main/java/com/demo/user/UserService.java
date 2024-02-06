package com.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserVo addUser(UserVo user) {
        return userRepository.save(user);
    }

    public Optional<UserVo> getUser(Long userNo) {
        return userRepository.findById(userNo);
    }

    public List<UserVo> getUserList() {
        return userRepository.findAll();
    }

    public UserVo searchUser(UserVo user) {
        return userRepository.findByEmail(user.getEmail());
    }
}
