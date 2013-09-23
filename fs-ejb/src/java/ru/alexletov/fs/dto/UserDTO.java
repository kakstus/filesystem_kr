/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.dto;

import java.io.Serializable;
import ru.alexletov.fs.entities.User;

/**
 *
 * @author Alex
 */
public class UserDTO implements Serializable {
    private Integer id;
    private String login;
    private String firstName;
    private String lastname;
    private String email;
    private Integer employee;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.employee = user.getEmployee();
        this.firstName = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }
    
}
