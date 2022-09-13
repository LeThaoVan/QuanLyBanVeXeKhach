<%-- 
    Document   : login
    Created on : Aug 25, 2022, 12:49:38 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Trang đăng nhập</h1>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập
    </div>
</c:if>
<c:if test="${param.fromaddcomment != null}">
    <div class="alert alert-danger">
        Vui lòng đăng nhập để bình luận
    </div>
</c:if>


<c:if test="${param.error != null}">
    <div class="alert alert-danger">Da co loi xay ra</div>
</c:if>
<c:url value="/login" var ="action" />
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username:</label>
        <input class="form-control"  name="username" id="username" type="text" />
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input class="form-control"  name="password" id="password" type="password" />
    </div>
    <input  type="submit" class="btn btn-primary" value="Dang Nhap"/>
    
</form>