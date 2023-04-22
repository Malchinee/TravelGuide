package edu.hit.lch.service.impl;

import edu.hit.lch.dao.UserDao;
import edu.hit.lch.dao.impl.UserDaoImpl;
import edu.hit.lch.domain.ResultInfo;
import edu.hit.lch.domain.User;
import edu.hit.lch.service.UserService;
import edu.hit.lch.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean register(User user) {
        // 1. 根据用户名查询用户
        User existUser = userDao.findByUsername(user.getUsername());
        // 1.1 发现用户存在，返回错误
        if(existUser != null) {
            return false;
        }
        // 2.保存用户信息
        user.setCode(UuidUtil.getUuid());
        user.setState("Y");
        userDao.save(user);

        return true;
    }

    @Override
    public User login(String username, String password) {
        return userDao.findUser(username, password);
    }
}
