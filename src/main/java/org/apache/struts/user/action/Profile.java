package org.apache.struts.user.action;

import org.apache.struts.user.dao.UserManager;
import org.apache.struts.user.model.User;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

public class Profile extends ActionSupport{
    private static final long serialVersionUID = 1;

    private String errorMessage;
    private User user;

    public String execute() throws SQLException {
        user = UserManager.read(1, false);
        if (user == null) {
            setErrorMessage("No such user");
            return "failure";
        }
        return SUCCESS;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}