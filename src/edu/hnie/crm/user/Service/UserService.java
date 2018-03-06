package edu.hnie.crm.user.Service;

import edu.hnie.crm.user.domain.User;

import java.util.List;

public interface UserService {
    public User checkLogin(String username,String password);

    public List<User> findAllUser();
}
