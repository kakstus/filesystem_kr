/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.alexletov.fs.entities.dao.DAOFactory;
import ru.alexletov.fs.entities.dao.UserDAO;

/**
 *
 * @author Alex
 */
@Stateless
public class AuthenticateBean {
    @PersistenceContext
    EntityManager em;
    public boolean doLogin(String login, String password) {
        DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.MYSQL, em);
        UserDAO ud = df.getUserDAO();
        return ud.checkPasswordByLogin(login, password);
    }
}
