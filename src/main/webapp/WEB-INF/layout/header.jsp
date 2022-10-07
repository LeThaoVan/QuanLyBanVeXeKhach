<%-- 
    Document   : header
    Created on : Aug 6, 2022, 8:18:20 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" media="all" href="css/admin.css"/>

<!--<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Quản lý bán vé xe khách</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">&#128653; Trang chủ</a>
                </li>
                
                <li>
                    <a class="nav-link" href="<c:url value="/register"/>">Đăng kí</a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li>
                    <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                </li>
                </c:if>
                
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <div class="user__img" style="display:flex;">
                        <c:if test="${currentUser.avatar != null}">
                                <img style="width:30px; border-radius: 50%;"src="${currentUser.avatar}" class="img" />
                        </c:if>

                        <c:if test="${currentUser.avatar == null}">
                            <i classs="fa-solid fa-user-clock"></i>
                        </c:if>   
                        <a class="nav-link" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
                    </div>

                </li>
                </c:if>
                <li>
                    <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                </li>

            </ul>
            <c:url value="/" var="action" />
            <form method="get" action="${action}" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Nhập tuyến xe muốn tìm">
                <button type="submit" class="btn btn-primary" type="button">Tìm</button>
            </form>
        </div>
    </div>

</nav>-->
<nav>
    <ul>
<!--        <li class="logo"><img src="https://i.imgur.com/E26Pj54.png"></li>-->
        <li><a href="#"><i class="fa fa-home"></i>&nbsp; Home</a></li>
        <li><a href="<c:url value="/admin/users"/>"><i class="fa fa-book"></i>&nbsp;  Quản lý người dùng</a></li>
        <li><a href="#"><i class="fa fa-map-location"></i>&nbsp;  Quản lý tuyến xe</a></li>
        <li><a href="#"><i class="fa fa-bus"></i>&nbsp;  Quản lý chuyến xe</a></li>
        <li><a href="#"><i class="fa fa-ticket"></i>&nbsp;  Quản lý vé xe</a></li>
        <li><a href="#"><i class="fa fa-chart-simple"></i>&nbsp;  Thống kê</a></li>
        <li><a href="#"><i class="fa fa-phone"></i>&nbsp; Contact</a></li>
    </ul>
</nav>

