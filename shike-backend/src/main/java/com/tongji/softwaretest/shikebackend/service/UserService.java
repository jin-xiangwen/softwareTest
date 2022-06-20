package com.tongji.softwaretest.shikebackend.service;

import com.tongji.softwaretest.shikebackend.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserById(int userId);

    boolean addUser(User user);

    boolean modifyUser(User user);

    boolean deleteUser(int userId);
}
