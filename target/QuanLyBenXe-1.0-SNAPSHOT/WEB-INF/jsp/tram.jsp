<%-- 
    Document   : tram
    Created on : Aug 27, 2022, 3:29:30 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<h1 class="text-center text-primary">Thêm Trạm</h1>


<c:url value="/admin/tram" var="action" />
<form:form method="post" action="${action}" modelAttribute="tram">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="tenTram" class="form-control" id="name" placeholder="name" name="name" />
        <label for="name">Tên Trạm</label>
    </div>
    <div class="form-floating">
        <h6 for="diachi" class="form-label">Chọn địa điểm:</h6>
        <form:input  id="ward" list="listward" name="listward" path="wardId" placeholder="Tìm địa chỉ" />
        <datalist id="listward">
            <c:forEach items="${ward}" var="c">
                <option id ="w${c.id}" value="${c.id}">${c.prefix}: ${c.name}, ${c.districtId.prefix}: ${c.districtId.name}, ${c.districtId.provinceId.name}</option>
            </c:forEach>
        </datalist>
    </div><br>
     

    <div>
        <br>
        <input type="submit" value="Thêm trạm" class="btn btn-danger"/>
    </div>
</form:form>

    
    
<div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="myInput" onkeyup="mySearchTram()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>Mã</th>
        <th>Tên Trạm</th>
        <th>Mã địa chỉ</th>
    </tr>
    <tbody id="tableTram">

    </tbody>
</table>

    
    
<div>  
    <a href="<c:url value="/admin/routestation"/>"class="btn"  style="padding-left: 75%">
        <h7>Thêm trạm cho tuyến đường &#62&#62</h7>
    </a>
</div>

   <script src="<c:url value="/js/tram.js" />"></script>
<script>
    <c:url value="/api/tram" var="u" />

        window.onload = function () {
            getTram('${u}');
        }

</script>
