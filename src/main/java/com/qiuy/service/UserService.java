package com.qiuy.service;

import com.qiuy.entity.User;

/**
 * Created by admin on 2019/12/9.
 */
public interface UserService {
    /**通过username查找用户信息;*/
    public User findByUsername(String username);
    public  boolean existsByusername(String username);
    public void saveUser(User user);
}
