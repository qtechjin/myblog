package com.xiaomi.example.service;

import com.xiaomi.example.pojo.User;

/**
 * Created by mi on 2017/3/21.
 */
public interface UserService {
    boolean login(String userName, String password);

    public boolean register(User user);

    public boolean modifyInfo(User user);
}
