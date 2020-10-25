package com.cx.service;

import com.cx.bean.User;
import com.cx.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cx
 * @create 2020-10-26 2:35
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAll(){
        List<User> users = userMapper.selectByExample(null);
        return users;
    }
}
