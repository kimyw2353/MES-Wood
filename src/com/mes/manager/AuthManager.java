package com.mes.manager;

import com.mes.cryptographic.MD5;
import com.mes.dao.UsersDao;
import com.mes.model.Users;

public class AuthManager {

    UsersDao userDao = new UsersDao();
    MD5 md5 = new MD5();

    public Users getUser(String userId) {
        return userDao.findByUserId(userId);
    }

    public boolean matchPassword(Users users, String password) {
        String encryptionPassword = md5.encoding(password);
        return users.getPassword().equals(encryptionPassword);
    }

    public boolean createUser(String userId, String password, String name) {
        Users users = new Users(userId, password, name);
        return userDao.createUsers(users);
    }
}
