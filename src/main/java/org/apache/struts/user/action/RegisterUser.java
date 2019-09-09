package org.apache.struts.user.action;

import org.apache.struts.user.model.User;
import org.apache.struts.user.dao.UserManager;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

public class RegisterUser extends ActionSupport{
    private static final long serialVersionUID = 1;
    private User user;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int type; 

    public String execute() throws SQLException {
        if (UserManager.emailExists(email)) {
            return "failure";
        }
        UserManager.createUser(firstName, lastName, email, password, type);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}