/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatetemplate3;

import com.mycompany.hibernatetemplate3.entities.ContactsInfo;
import com.mycompany.hibernatetemplate3.entities.User;
import java.util.List;

/**
 *
 * @author shibo
 */
public interface DaoInt {
     public boolean addUser(User user);

    public User loginUser(User user);
    
    public boolean updateUser(User u);
    
    public boolean DeactiveUser(User u);
    
    

    public boolean addContact(User user, ContactsInfo contact);

    public boolean editContact(User user, ContactsInfo contact);

    public boolean deleteContact(User user, ContactsInfo contact);

    public List<ContactsInfo> showContacts(User user);

    public List<ContactsInfo> searchContacts(User user, String name);
}
