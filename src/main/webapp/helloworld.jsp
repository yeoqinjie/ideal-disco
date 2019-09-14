<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World!</title>
</head>

<body>
    <s:form action="register" method="post">
        <s:textfield name="firstName" label="First Name"/>
        <s:textfield name="lastName" label="Last Name"/>
        <s:textfield name="email" label="Email"/>
        <s:password name="password" label="Password"/>
        <s:submit value="submit"/>
    </s:form>
</body>

</html>