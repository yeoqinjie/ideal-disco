package org.apache.struts.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
    private static final long serialVersionUID = 1;

    public String execute() {
        return SUCCESS;
    }

}