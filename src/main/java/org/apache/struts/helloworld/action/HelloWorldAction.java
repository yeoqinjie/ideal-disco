package org.apache.struts.helloworld.action;

import org.apache.struts.helloworld.model.MessageStore;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
    private static final long serialVersionUID = 1;
    private MessageStore messageStore;
    private String passWord;

    public String execute() {
        messageStore = new MessageStore();
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        passWord = password;
    }
}