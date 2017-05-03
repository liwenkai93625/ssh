package shiyanlou.ssh.dao;

import shiyanlou.ssh.model.User;

import java.util.List;

/**
 * Created by lianjia on 2017-5-2.
 */
public interface UserDao {

    //用以登录时检查数据库中是否存在高用户
    public boolean checkUser(User user);

    //添加用户
    public boolean addUser(User user);

    //删除用户
    public boolean deleteUser(int id);

    //修改用户
    public boolean updateUser(User user);

    //查询用户
    public List<User> queryUser(User user);

    //根据Id查询
    public User queryById(int id);

    //查询所有用户
    public List<User> queryAll();
}
