package com.tongji.softwaretest.shikebackend.servicelmpl;

import com.tongji.softwaretest.shikebackend.entity.User;
import com.tongji.softwaretest.shikebackend.mapper.UserMapper;
import com.tongji.softwaretest.shikebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean addUser(User user) {
        int effectedNum = userMapper.insert(user);
        if (effectedNum > 0){
            return true;
        } else {
            throw new RuntimeException("失败！");
        }
    }

    @Override
    public boolean modifyUser(User user) {
        int effectedNum = userMapper.updateByPrimaryKey(user);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        int effectedNum = userMapper.deleteByPrimaryKey(userId);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }
}
