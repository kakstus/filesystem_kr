/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.entities.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ru.alexletov.fs.AuthenticateBean;
import ru.alexletov.fs.entities.User;

/**
 *
 * @author Alex
 */
public class MySQLUserDAO implements UserDAO {
    @PersistenceContext(unitName = "fs-ejbPU")
    EntityManager entityManager; 

    @Override
    public boolean checkPasswordByLogin(String login, String password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot);
        criteria.where(builder.equal(userRoot.get("login"), login));
        User user = entityManager.createQuery(criteria).getSingleResult();
        
        if(user == null) {
            return false;
        }
        if(user.getPassword().equals(encryptPassword(password))) {
            return true;
        }        
        return false;
    }

    @Override
    public boolean checkPasswordById(Long id, String password) {     
        User user = entityManager.find(User.class, id);
        
        if(user == null) {
            return false;
        }
        if(user.getPassword().equals(encryptPassword(password))) {
            return true;
        }        
        return false;
    }
    
    private String encryptPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        byte[] pwdHashByte = md.digest(password.getBytes());
        return pwdHashByte.toString();
    }
}
