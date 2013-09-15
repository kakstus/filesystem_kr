/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

/**
 *
 * @author Alex
 */
public interface IAuthenticateBean {
    /**
     * Function to check password via username
     * @param login User login
     * @param password User password (unencrypted)
     * @return true on correct login & password, false in other case
     */
    public abstract boolean doLogin(String login, String password);
}
