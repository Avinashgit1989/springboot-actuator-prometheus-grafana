package com.learnwithak.userservice.service;

import com.learnwithak.userservice.model.UserRestModel;

import java.util.List;

public interface UserService {


    UserRestModel createUser(UserRestModel user);

    List<UserRestModel> getUser();

    UserRestModel getUserById(Integer userId);

    UserRestModel updateUserById(UserRestModel user, Integer userId);

    String deleteUserById(Integer userId);
}
