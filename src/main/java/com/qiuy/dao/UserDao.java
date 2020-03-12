package com.qiuy.dao;

import com.qiuy.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2019/12/9.
 */
@Repository
public interface UserDao extends CrudRepository<User,String> {
    /**通过username查找用户信息;*/
    public User findByUsername(String username);
    public  boolean existsByusername(String username);
}
