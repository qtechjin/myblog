package com.xiaomi.example.dal.repository.impl;

import com.xiaomi.example.convert.UserConvert;
import com.xiaomi.example.dal.dao.UserDAO;
import com.xiaomi.example.dal.repository.UserRepository;
import com.xiaomi.example.pojo.User;

import javax.annotation.Resource;

/**
 * Created by mi on 2017/3/23.
 */
public class DefaultUserRepository implements UserRepository {
    @Resource
    private UserDAO userDAO;

    public User loadByUserName(String userName) {
        return UserConvert.convert( userDAO.selectByUserName(userName) );
    }

    public boolean insertUser(User user){
        if(userDAO.insert(UserConvert.convert(user)) != 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public User loadByUserId(int userId){
        return UserConvert.convert(userDAO.selectByPrimaryKey(userId));
    }

    public void updateByUserName(User user) {

    }
}
