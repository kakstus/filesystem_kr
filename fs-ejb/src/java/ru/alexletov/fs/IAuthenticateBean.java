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
    public abstract boolean doLogin(String login, String password);
}
