package edu.hit.lch.service;

import edu.hit.lch.domain.User;

public interface UserService {
    boolean register(User user);

    User login(String username, String password);
}
