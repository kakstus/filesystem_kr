/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.entities.dao;

/**
 *
 * @author Alex
 */
public interface UserDAO {
    public boolean checkPasswordByLogin(String login, String password);
    public boolean checkPasswordById(Long id, String password);
}
