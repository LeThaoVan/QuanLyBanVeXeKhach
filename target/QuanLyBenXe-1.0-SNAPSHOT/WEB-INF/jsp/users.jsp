<%-- 
    Document   : users
    Created on : Aug 30, 2022, 10:28:31 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h1 class="text-center text-primary">Sửa vai trò người dùng</h1>


<c:url value="/admin/users" var="action" />
<form action="${action}">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <select class="form-select" name="idU" id="idU">
            <c:forEach items="${users}" var="c">
                <option value="${c.userid}">${c.username}</option>
            </c:forEach>
        </select>
        <label for="name">Chọn người dùng muốn đổi vai trò</label>
    </div>

    <div class="mb-3 mt-3">
        <select class="form-control" id="newrode" name="newrode">
            <option value="ROLE_ADMIN">ADMIN</option>
            <option value="Driver">DRIVER</option>
            <option value="ROLE_STAFF">STAFF</option>
            <option value="ROLE_USER">USER</option>
        </select>
    </div>

    <div>
        <br>
        <input type="submit" value="Sửa chuyến xe" class="btn btn-danger"/>
    </div>
</form>

<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>id</th>
        <th>avata</th>
        <th>Tên đăng nhập</th>
        <th>Họ</th>
        <th>Tên</th>
        <th>Email</th>
        <th>SDT</th>
        <th>Vai trò</th>
        <th></th>
    </tr> 
    <tbody id="myUsers">

    </tbody>
</table>


<script src="<c:url value="/js/users.js" />"></script>
<script>
    <c:url value="/api/users" var="u" />

    window.onload = function () {
        getUsers('${u}');
    }

</script>