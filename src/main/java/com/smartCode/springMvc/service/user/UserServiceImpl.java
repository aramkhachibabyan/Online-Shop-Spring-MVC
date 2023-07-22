package com.smartCode.springMvc.service.user;

import com.smartCode.springMvc.exceptions.UserNotFoundException;
import com.smartCode.springMvc.exceptions.ValidationException;
import com.smartCode.springMvc.model.User;
import com.smartCode.springMvc.repository.user.UserRepository;
import com.smartCode.springMvc.util.constants.Message;
import com.smartCode.springMvc.util.encoder.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void register( String name,
                          String lastname,
                           String email,
                          String password,
                          int age) {
        if (userRepository.getByEmail(email) != null) {
            throw new ValidationException(Message.EMAIL_IS_NOT_AVAILABLE);
        }
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(MD5Encoder.encode(password));
        user.setAge(age);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void login( String email,
                      String password) {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new UserNotFoundException(Message.USER_NOT_FOUND);
        }
        if (!Objects.equals(user.getPassword(), MD5Encoder.encode(password))) {
            throw new ValidationException(Message.INVALID_PASSWORD);
        }
    }

    @Override
    @Transactional
    public void deleteUser(String email,
                           String password) {
        if (!userRepository.getByEmail(email).getPassword().equals(MD5Encoder.encode(password))) {
            throw new ValidationException(Message.INVALID_PASSWORD);
        }
        userRepository.delete(userRepository.getByEmail(email));
    }

    @Override
    @Transactional
    public void updateUser( String email,
                            String newPassword,
                            String repeatPassword) {
        if (!Objects.equals(newPassword, repeatPassword)) {
            throw new RuntimeException("Passwords does not match");
        }
        User user = userRepository.getByEmail(email);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

}

