/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Alex
 */
@Stateless
@LocalBean
public class UserManagementBean implements IUserManagementBean {

    @Override
    public Integer addUser(String login, String password, String name, String lastname, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAdmin(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean revokeAdmin(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
