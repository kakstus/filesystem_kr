/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import ru.alexletov.fs.dto.UserDTO;

/**
 *
 * @author Alex
 */
@ManagedBean
@RequestScoped
public class RegisterBean {
    @EJB
    UserBean ub;
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
        Integer len = n.length();
        if (n == null || len < 3) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Name is too small (must be more than 2 chars)",
                        "Name is too small (must be more than 2 chars)"));
        }
        if (len > 64) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Name is too big (must be less than 65 chars)",
                        "Name is too big (must be less than 65 chars)"));
        }
    }
    
    public void validateLastName(FacesContext context, UIComponent component,
            Object value) {
        String l = (String) value;
        Integer len = l.length();
        if (l == null || len < 3) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Last name is too small (must be more than 2 chars)",
                        "Last name is too small (must be more than 2 chars)"));
        }
        if (len > 64) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Last name is too big (must be less than 65 chars)",
                        "Last name is too big (must be less than 65 chars)"));
        }
    }
    
    public void validateLogin(FacesContext context, UIComponent component,
            Object value) {
        String l = (String) value;
        Integer len = l.length();
        if ((l == null) || (len < 5)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login is too small (must be more than 4 chars",
                        "Login is too small (must be more than 4 chars"));
        }
        if (len > 64) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login is too big (must be less than 65 chars)",
                        "Login is too big (must be less than 65 chars)"));
        }
        
        if (ub.exists(l)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "User with this login already exists.",
                        "User with this login already exists."));
        }
    }
    
    public void validatePassword(FacesContext context, UIComponent component,
            Object value) {
        String p = (String) value;
        Integer len = p.length();
        if ((p == null) || (len < 5)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Password must be more than 4 chars length",
                        "Password must be more than 4 chars length"));
        }
        if (len > 64) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Password must be less than 65 chars length",
                        "Password must be less than 65 chars length"));
        }
    }
        
    public void validateEmail(FacesContext context, UIComponent component,
            Object value) {
        String e = (String) value;
        Pattern p = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$");
        Matcher m = p.matcher(e);
        if (!m.matches()) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Enter valid email", "Enter valid email"));
        }
        if (e.length() > 64) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Email must be less than 65 chars",
                        "Email must be less than 65 chars"));
        }
    }
    
    public String register() {
        UserDTO user = new UserDTO();
        user.setAdmin(0);
        user.setEmail(email);
        user.setLastname(lastname);
        user.setName(name);
        user.setLogin(login);
        if (ub.addUser(user, password) != null) {
            return "success";
        }
        else {
            return "error";
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
