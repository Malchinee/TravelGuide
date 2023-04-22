package edu.hit.lch.dao;

import edu.hit.lch.domain.User;

public interface UserDao {
    /**
     * 根据用户名获得用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名查询用户是否注册
     * @param username
     * @return
     */

    User findUser(String username, String password);
}
