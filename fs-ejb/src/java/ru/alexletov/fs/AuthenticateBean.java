/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import javax.ejb.Stateless;
import ru.alexletov.fs.entities.dao.DAOFactory;
import ru.alexletov.fs.entities.dao.UserDAO;

/**
 *
 * @author Alex
 */
@Stateless
public class AuthenticateBean {

    public boolean doLogin(String login, String password) {
        DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        UserDAO ud = df.getUserDAO();
        return ud.checkPasswordByLogin(login, password);
    }
}
