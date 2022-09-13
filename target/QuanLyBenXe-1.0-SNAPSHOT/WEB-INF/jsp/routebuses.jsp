<%-- 
    Document   : routebuses
    Created on : Aug 18, 2022, 9:49:00 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<h1 class="text-center text-primary">Thêm tuyến xe cho chuyến xe</h1>


<c:url value="/admin/routebuses" var="action" />

<form:form method="post" action="${action}" modelAttribute="routebuses">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="date"  name="date" min="2022-02-02" onfocus="this.min=new Date().toISOString().split('T')[0]" path="ngaydi" class="form-control" id="date" placeholder="date" />
        <label for="date">Ngày đi</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="time" value = "8:00" path="giodi" class="form-control"  id="time" placeholder="time" name="time" />

        <label for="time">Giờ đi</label>
        <span class="validity"></span>
    </div>


    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="price" class="form-control" id="price" placeholder="price" name="name" />
        <label for="name">Giá</label>
    </div>

    <div class="form-floating">
        <form:select path="routeId" class="form-select" id="route" name="route">
            <c:forEach items="${routes}" var="c">
                <option value="${c.rid}">${c.routename}</option>
            </c:forEach>
        </form:select>
        <label for="route" class="form-label">Chọn tuyến đường</label>
    </div><br>

    <div class="form-floating">
        <form:select path="busesId" class="form-select" id="chuyen" name="chuyen">
            <c:forEach items="${chuyenxe}" var="u">
                 <c:if test="${u.bstatus == '1'}">
                <option value="${u.bid}">${u.busesName}</option>
                </c:if>
            </c:forEach>
        </form:select>
        <label for="chuyen" class="form-label">Chọn chuyến xe</label>
    </div><br>

    <div>
        <br>
        <input type="submit" value="Thêm tuyến xe cho chuyến xe" class="btn btn-danger"/>
    </div><br>
    <div><a href="<c:url value="/admin/buses" />"class="btn" >&#60&#60 Thêm chuyến xe</a></div>
</form:form>

<div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="myInput2" onkeyup="mySearchRBuses()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id ="myTable2">
    <tr>
        <th>Mã</th>
        <th>Ngày đi</th>
        <th>Giờ đi</th>
        <th>Giá tiền</th>
        <th></th>
    </tr>
    <tbody id="myRouteBuses">
        
    </tbody>
</table>


<script src="<c:url value="/js/buses.js" />"></script>
<script>
    <c:url value="/api/routebuses" var="u" />

    window.onload = function () {
        getRBuses('${u}');
    }

</script>

