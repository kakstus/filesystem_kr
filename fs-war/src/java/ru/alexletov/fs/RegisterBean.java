/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Alex
 */
@ManagedBean
@RequestScoped
public class RegisterBean {
    private String login;
    private String password;
    private String name;
    private String lastname;
    private String email;
    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }
    
    
    
    public void validateName(FacesContext context, UIComponent component,
            Object value) {
        String n = (String) value;
        if (n == null || n.length() < 3) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Name is too small", "Name is too small"));
        }
    }
    
    public void validateLastName(FacesContext context, UIComponent component,
            Object value) {
        String l = (String) value;
        if (l == null || l.length() < 3) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Last name is too small", "Last name is too small"));
        }
    }
    
    public void validateLogin(FacesContext context, UIComponent component,
            Object value) {
        String l = (String) value;
        if (l == null || l.length() < 5) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login is too small", "Login is too small"));
        }
    }
    
    public void validatePassword(FacesContext context, UIComponent component,
            Object value) {
        String p = (String) value;
        // TODO: Implement
    }
    
    public void validateEmail(FacesContext context, UIComponent component,
            Object value) {
        String e = (String) value;
        // TODO: Implement
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
