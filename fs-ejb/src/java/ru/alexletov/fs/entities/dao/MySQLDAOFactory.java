/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.entities.dao;


/**
 *
 * @author Alex
 */
public class MySQLDAOFactory extends DAOFactory {
    
    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public FileDAO getFileDAO() {
        return new MySQLFileDAO();
    }
    
}
