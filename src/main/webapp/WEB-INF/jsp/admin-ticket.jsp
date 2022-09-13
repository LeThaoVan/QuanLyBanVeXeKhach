<%-- 
    Document   : ticket
    Created on : Sep 2, 2022, 3:18:11 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<h1 class="text-center text-primary">Quản lý vé xe</h1>


<c:url value="/admin/admin-ticket" var="action" />

<div class="table-search-ticket" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="myInput" onkeyup="mySearchTicket()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>Mã</th>
        <th>Tên khách hàng</th>
        <th>Số lượng</th>
        <th>Tổng tiền</th>
        <th>Mã trạm xuất phát</th>
        <th>Mã trạm đến</th>
        <th>Tình trạng nhanh toán</th>
        <th></th>
    </tr>
    <tbody id="myTicket">

    </tbody>
</table>


<script src="<c:url value="/js/ticket.js" />"></script>
<script>
    <c:url value="/api/ticket" var="u" />

        window.onload = function () {
            getTicket('${u}');
        }

</script>
