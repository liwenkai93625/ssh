package shiyanlou.ssh.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shiyanlou.ssh.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lianjia on 2017-5-2.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean checkUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User u where u.id:=id and u.name:=name");
        query.setParameter("id", user.getId());
        query.setParameter("name", user.getName());

        User u = (User)query.uniqueResult();

        session.getTransaction().commit();
        session.close();
        if (null != u)
            return true;
        return false;
    }

    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = queryById(id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<User> queryUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        StringBuffer hql = new StringBuffer("from User u where 1=1");
        ArrayList<String> params = new ArrayList<String>();

        if (user.getName() != null && !"".equals(user.getName())){
            hql.append("and u.name = ?");
            params.add(user.getName());
        }
        if (user.getCompany() != null && !"".equals(user.getCompany())){
            hql.append("and u.company = ?");
            params.add(user.getCompany());
        }
        String hq = hql.toString();
        Query query = session.createQuery(hq);
        for (int i = 0; i < params.size(); i++){
            query.setParameter(i, params.get(i));
        }
        List<User> users = query.list();
        session.getTransaction().commit();;
        session.close();
        return users;
    }

    @Override
    public User queryById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Query query = session.createQuery("from User u where u.id:=id");
        User user = (User)session.load(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> queryAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User u");
        List<User> users = query.list();
        session.getTransaction().commit();
        session.close();
        return users;
    }
}
