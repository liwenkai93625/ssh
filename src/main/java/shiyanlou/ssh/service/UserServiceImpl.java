package shiyanlou.ssh.service;

import shiyanlou.ssh.dao.UserDao;
import shiyanlou.ssh.model.User;

import java.util.List;

/**
 * Created by lianjia on 2017-5-2.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> queryUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public User queryById(int id) {
        return userDao.queryById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
