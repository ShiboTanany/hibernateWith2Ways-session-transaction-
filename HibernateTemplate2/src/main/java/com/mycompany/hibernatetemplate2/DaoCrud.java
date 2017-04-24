/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatetemplate2;

import com.mycompany.hibernatetemplate2.entities.ContactsInfo;
import com.mycompany.hibernatetemplate2.entities.User;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;

import org.springframework.orm.hibernate4.HibernateTemplate;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 *
 * @author shibo
 */
public class DaoCrud extends HibernateJpaDialect implements DaoInt {

    HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

//    HibernateTemplate hiber;
//
//    public HibernateTemplate getHiber() {
//        return hiber;
//    }
//
//    public void setHiber(SessionFactory hiber) {
//        this.hiber = new HibernateTemplate(hiber);
//    }
//  
    @Override
    @Transactional(readOnly = false)
    public boolean addUser(final User user) {
        TransactionSynchronizationManager.setActualTransactionActive(true);

//        TransactionSynchronizationManager.setCurrentTransactionName(FlushMode.COMMIT.toString());
//        template.getSessionFactory().openSession().setFlushMode(FlushMode.COMMIT);
//        System.out.println("" + template.getSessionFactory().openSession().getFlushMode());
//        System.out.println(" tdskdlsk    " + TransactionSynchronizationManager.isCurrentTransactionReadOnly());
//        template.save(user);
//        template.flush();

        template.execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session sn) throws HibernateException {
                sn.save(user);
                return user;
            }
        });

//        Session s = sessionFactory.openSession();
//        s.beginTransaction();
//        s.save(user);
//        s.getTransaction().commit();
        return true;
    }

    @Override
    public User loginUser(User user) {

        User loginedUser = null;
        loginedUser = template.load(User.class, user.getUserId());

//        String sql = "from User p where p.userEmail=:email and p.userpass=:pass";
//        Query query =sessionFactory.openSession().createQuery(sql);
//        query.setParameter("email", user.getUserEmail());
//        query.setParameter("pass", user.getUserpass());
//        List<User> list = query.list();
//        if (query.list().size() > 0) {
//
//            loginedUser = list.get(0);
//            return loginedUser;
//        } else {
//            return loginedUser;
//        }
        return loginedUser;
    }

    @Override
    public boolean updateUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeactiveUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addContact(User user, ContactsInfo contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editContact(User user, ContactsInfo contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteContact(User user, ContactsInfo contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContactsInfo> showContacts(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContactsInfo> searchContacts(User user, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
