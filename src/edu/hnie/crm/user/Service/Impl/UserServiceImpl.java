package edu.hnie.crm.user.Service.Impl;

import edu.hnie.crm.user.Service.UserService;
import edu.hnie.crm.user.dao.UserDao;
import edu.hnie.crm.user.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User checkLogin(String username, String password) {
        String hql = "from User where username=? and password=?";
        List<User> list = userDao.find(hql, username, password);
        if (list != null && list.size() != 0) {
            User user = list.get(0);
            return user;
        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        String hql = "from User";
        List<User> userList = userDao.findAll(hql);
        return userList;
    }
}
