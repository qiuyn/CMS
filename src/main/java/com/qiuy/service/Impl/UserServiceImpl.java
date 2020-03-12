package com.qiuy.service.Impl;

import com.qiuy.dao.UserDao;
import com.qiuy.entity.User;
import com.qiuy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2019/12/9.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User findByUsername(String username) {
        System.out.println("UserServiceImpl.findByUsername()");
        return userDao.findByUsername(username);
    }
    @Override
    public boolean existsByusername(String username) {
        return userDao.existsByusername(username);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }
}
