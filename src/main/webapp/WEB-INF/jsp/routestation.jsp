<%-- 
    Document   : routestation
    Created on : Aug 28, 2022, 6:31:13 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<h1 class="text-center text-primary">Thêm trạm cho tuyến đường</h1>


<c:url value="/admin/routestation" var="action" />
<form:form method="post" action="${action}" modelAttribute="routestation">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating">
        <form:select path="routeId" class="form-select" id="loai" name="loai">
            <c:forEach items="${routes}" var="c">
                <option value="${c.rid}">${c.routename}</option>
            </c:forEach>
        </form:select>
        <label for="loai" class="form-label">Tuyến đường</label>
    </div><br>
    <div class="form-floating">
        <form:select path="idTram" class="form-select" id="tram" name="tram">
            <c:forEach items="${tramxe}" var="c">
                <option value="${c.idtram}">${c.tenTram}</option>
            </c:forEach>
        </form:select>
        <label for="loai" class="form-label">Tên trạm</label>
    </div><br>
    <div class="form-floating">
        <form:select path="state" class="form-select" id="state" name="state">
                <option value="1">Điểm đón</option>  
                <option value="2">Điểm trả</option>
        </form:select>
        <label for="state" class="form-label">Tình trạng</label>
    </div><br>
    
    <div>
        <br>
        <input type="submit" value="Thêm trạm cho tuyến" class="btn btn-danger"/>
    </div>-->
</form:form>
<div><a href="<c:url value="/admin/tram" />"class="btn" >&#60&#60 Thêm trạm</a></div>