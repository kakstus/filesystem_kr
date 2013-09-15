/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.entities.dao;

/**
 *
 * @author Alex
 */
public abstract class DAOFactory {
    public static final int MYSQL = 0x1;
    
    public abstract UserDAO getUserDAO();
    public abstract FileDAO getFileDAO();
    
    public static DAOFactory getDAOFactory(int factory) {
        switch (factory) {
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
