<%-- 
    Document   : admin-garage
    Created on : Sep 23, 2022, 5:17:43 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary">Quản lý nhà xe</h1>

<form:form method="post" action="${action}" modelAttribute="garage">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
        <label for="name">Tên nhà xe</label>
    </div>

    <div class="form-floating">
        <form:select path="idUser" class="form-select" id="staff-garage" name="staff-garage">
            <option value="0"></option>
            <c:forEach items="${nguoidung}" var="c">
                <c:if test="${c.role == 'ROLE_STAFF_GARAGE'}">
                    <option value="${c.id}">${c.userName}</option>
                </c:if>
            </c:forEach>
        </form:select>
        <label for="driver" class="form-label">Danh sách nhân viên</label>
    </div><br>
    <div>
        <br>
        <input type="submit" value="Thêm chuyến xe" class="btn btn-danger"/>
    </div>
</form:form>


<h1 class="text-center text-primary">Sửa nhà xe</h1>

<form action="${action}">
    <div class="form-floating mb-3 mt-3">
        <select class="form-select" name="idGara" id="idGara">
            <option value="0"></option>
            <c:forEach items="${nhaxe}" var="c">
                <option value="${c.id}">${c.id}. ${c.name}</option>

            </c:forEach>
        </select>
        <div class="form-floating mb-3 mt-3">
            <input type="text" class="form-control" id="garagename" value="" name="garagename" />
            <label for="tenchuyen">Nhập tên chuyến xe nếu muốn sửa</label>
        </div>
        <label for="idBuses" class="form-label">Chọn xe muốn sửa</label>
    </div>
    <div>
        <br>
        <input type="submit" value="Thêm chuyến xe" class="btn btn-danger"/>
    </div>
</form>



<div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="my-input" onkeyup="mySearchBuses()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>Mã</th>
        <th></th>
        <th>Tên chuyến xe</th> 
        <th>Tình trạng hoạt động</th>   
        <th></th>

    </tr>
    <tbody id="myGara">

    </tbody>
</table>

<script src="<c:url value="/js/buses.js" />"></script>
<script>
    <c:url value="/api/garage" var="u" />

        window.onload = function () {
            getGara('${u}');
        }


</script>