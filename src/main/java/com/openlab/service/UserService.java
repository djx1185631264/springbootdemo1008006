package com.openlab.service;

import com.openlab.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    public List<User>getUserList();
    public void createUser(User user);
    public User getUser(Long id);
    public void updateUser(Long id,User user);
    public void deleteUser(Long id);
}
