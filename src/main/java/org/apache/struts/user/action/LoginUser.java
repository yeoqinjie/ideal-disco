package org.apache.struts.user.action;

import org.apache.struts.user.dao.UserManager;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

public class LoginUser extends ActionSupport{
    private static final long serialVersionUID = 1;
    private String email;
    private String password;
    private String errorMessage;

    public String execute() throws SQLException {
        if (!UserManager.emailExists(email)) {
            setErrorMessage("User not registered yet");
            return "failure";
        }
        boolean login = UserManager.login(email, password);
        if (login) {
            return SUCCESS;
        } 
        setErrorMessage("Password incorrect");
        return "failure";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}