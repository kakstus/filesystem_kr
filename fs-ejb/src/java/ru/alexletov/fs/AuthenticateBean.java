/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ru.alexletov.fs.entities.User;

/**
 *
 * @author Alex
 */
@Stateless
public class AuthenticateBean implements IAuthenticateBean {
    @PersistenceContext(unitName = "fs-ejbPU")
    EntityManager entityManager; 
    
    /**
     * Function to check password via username
     * @param login
     * @param password
     * @return true on correct login & password, false in other case
     */
    @Override
    public boolean doLogin(String login, String password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthenticateBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        byte[] pwdHashByte = md.digest(password.getBytes());
        String pwdHash = pwdHashByte.toString();
        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot);
        criteria.where(builder.equal(userRoot.get("login"), login));
        User user = entityManager.createQuery(criteria).getSingleResult();
        if(user == null) {
            return false;
        }
        if(user.getPassword().equals(pwdHash)) {
            return true;
        }        
        return false;
    }
}
