/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

/**
 *
 * @author Alex
 */
public interface IUserManagementBean {
    /**
     * Add user to database
     * @param login Login
     * @param password Password (unencrypted)
     * @param name Name
     * @param lastname Last name
     * @param email E-mail
     * @return Id of created user or -1 if creation fails
     */
    public abstract Integer addUser(String login, String password, String name, String lastname,
            String email);
    
    /**
     * Add admin to User by Id
     * @param id
     * @return true on success, false on fail
     */
    public abstract boolean addAdmin(Integer id);
    
    /**
     * Revoke admin from User by Id
     * @param id
     * @return true on success, false on fail
     */
    public abstract boolean revokeAdmin(Integer id);
}
