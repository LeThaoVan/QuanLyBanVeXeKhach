<%-- 
    Document   : footer
    Created on : Aug 6, 2022, 8:18:11 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="mt-4 p-5 bg-primary text-white rounded" style="display: flex; width: 100%">
    <div style="width: 100%">
        <h4>Hỗ trợ khách hàng</h4>
        <p>Email: Admin12312@gmail.com</p>
        <p>SĐT: 0986756123</p>
    </div>
    <div style="width: 100%">
        <h4>Hướng dẫn</h4>
        <a href="<c:url value="/huongdanpay" />" class="btn"><p>Phương thức thanh toán</p></a>
    </div>
</div>
    <div><p style="text-align: center">Copyright &#64 UAV</p></div>
