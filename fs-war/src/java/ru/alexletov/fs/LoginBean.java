/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

/**
 *
 * @author Alex
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    @EJB(lookup="java:global/fs/fs-ejb/AuthenticateBean")
    private AuthenticateBean authBean;
    private boolean logged = false;
    private String login;
    private String password;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public boolean isLogged() {
        return logged;
    }
    public void doLogin() {
        logged = false; //authBean.doLogin(login, password);
    }
    
    public void validateName(FacesContext context, UIComponent component,
            Object value){
        String l = (String) value;
        if (l == null || l.length() < 3){
            context.addMessage(null, new FacesMessage("Login is too small"));
            throw new ValidationException();
        }
    }
    public void validatePassword(FacesContext context, UIComponent component,
                                 Object value){
        String p = (String)value;
        if (p == null || p.length() < 3){
            context.addMessage(null, new FacesMessage("Password is too small"));
            throw new ValidationException();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
