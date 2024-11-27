package com.learnwithak.userservice.service.impl;

import com.learnwithak.userservice.controller.UserController;
import com.learnwithak.userservice.entity.UserEntity;
import com.learnwithak.userservice.model.UserRestModel;
import com.learnwithak.userservice.repository.UserRepository;
import com.learnwithak.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRestModel createUser(UserRestModel userRestModel) {
        log.info("Create user Service Impl called....");
       UserEntity userEntity =  new UserEntity();
       UserRestModel userRestModel1 = new UserRestModel();
        //convert UserModel to UserEntity
        BeanUtils.copyProperties(userRestModel, userEntity);
        UserEntity userResponse = userRepository.save(userEntity);
        //convert UserEntity to UserModel
        BeanUtils.copyProperties(userResponse, userRestModel1);
        return userRestModel1;
    }

    @Override
    public List<UserRestModel> getUser() {
        log.info("Get user Service Impl called....");

        List<UserEntity> userResponse = userRepository.findAll();
        //convert UserEntity to UserModel
        List<UserRestModel> userRestModel = userResponse.stream()
                .map(userEntity -> UserRestModel.builder()
                        .userId(userEntity.getUserId())
                        .firstName(userEntity.getFirstName())
                        .lastName(userEntity.getLastName())
                        .email(userEntity.getEmail())
                        .contact(userEntity.getContact()).build()).collect(Collectors.toList());
        return userRestModel;
    }

    @Override
    public UserRestModel getUserById(Integer userId) {
        log.info("Get user by Id Service Impl called....");
        UserRestModel userRestModel = new UserRestModel();
        UserEntity userResponse = userRepository.findById(userId).get();
        //convert UserEntity to UserModel
        BeanUtils.copyProperties(userResponse, userRestModel);
        return userRestModel;
    }

    @Override
    public UserRestModel updateUserById(UserRestModel userRestModel, Integer userId) {
        log.info("Update user by Id Service Impl called....");
        UserEntity userEntity =  new UserEntity();
        UserRestModel userRestModel1 = new UserRestModel();
        //convert UserModel to UserEntity
        BeanUtils.copyProperties(userRestModel, userEntity);
        userEntity.setUserId(userId);
        UserEntity userResponse = userRepository.save(userEntity);
        //convert UserEntity to UserModel
        BeanUtils.copyProperties(userResponse, userRestModel1);
        return userRestModel1;
    }

    @Override
    public String deleteUserById(Integer userId) {
        log.info("Delete user by Id Service Impl called....");
        userRepository.deleteById(userId);
        return "User deleted by UserId : "+ userId;
    }
}
