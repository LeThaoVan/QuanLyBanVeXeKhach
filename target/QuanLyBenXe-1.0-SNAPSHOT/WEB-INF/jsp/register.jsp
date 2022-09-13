<%-- 
    Document   : register
    Created on : Aug 26, 2022, 10:57:38 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Day la trang dang ky</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var ="action" />
<form:form method="post" action="${action}"
               enctype="multipart/form-data"
               modelAttribute="user">
    <div class="form-group">
        <label  for="firstname">First name: </label>
        <form:input class="form-control" type="text" id="firstname" path="firstname"/>
    </div>
    
    <div class="form-group">
        <label  for="lastname">Last name: </label>
        <form:input class="form-control" type="text" id="lastname" path="lastname"/>
    </div>
    
    <div class="form-group">
        <label  for="username">User name: </label>
        <form:input class="form-control" type="text" id="username" path="username" />
        <form:errors path="username" cssClass="text-danger" />
    </div>
    
   <div class="form-group">
        <label  for="email">Email: </label>
        <form:input class="form-control" type="email" id="email" path="email"/>
        <form:errors path="email" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label  for="sdt">SĐT: </label>
        <form:input class="form-control" type="text" id="sdt" path="sdt"/>
        <form:errors path="sdt" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label  for="yearofbirth">Nam sinh: </label>
        <form:input class="form-control" type="string" id="yearofbirth" path="yearofbirth"
                    value="02/12/2001"
                    />
    </div>
    
    <div class="form-group">
        <label  for="pass">Mat khau: </label>
        <form:input class="form-control" type="password" id="pass" path="pass"/>
    </div>
    
    <div class="form-group">
        <label for="confirmPassword">Nhap lai mat khau: </label>
        <form:input class="form-control" type="password" id="confirmPassword" path="confirmPassword" />
    </div>
    
    <div class="form-group">
        <label  for="avatar">Avatar: </label>
        <form:input class="form-control" type="file" id="avatar" path="file"/>
    </div>
    
    <input  type="Submit" value="Submit"/>
    
 </form:form>