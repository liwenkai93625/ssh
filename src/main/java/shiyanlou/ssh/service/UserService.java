package shiyanlou.ssh.service;

import shiyanlou.ssh.model.User;

import java.util.List;

/**
 * Created by lianjia on 2017-5-2.
 */
public interface UserService {
    public boolean checkUser(User user);
    public boolean addUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
    public List<User> queryUser(User user);
    public User queryById(int id);
    public List<User> queryAll();
}
