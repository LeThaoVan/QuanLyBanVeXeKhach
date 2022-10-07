<%-- 
    Document   : admin-confirm
    Created on : Oct 5, 2022, 2:03:22 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>Xác nhận đăng kí</h1>

<h3>Xác nhận nhà xe:</h3>


<form action="${action}">
    <div class="form-floating mb-3 mt-3">
        <select class="form-select" name="idGara" id="idGara">
            <option value="0"></option>
            <c:forEach items="${nhaxe}" var="c">
                <option value="${c.id}">${c.id}. ${c.name}</option>
            </c:forEach>
        </select>
        <label for="idGara" class="form-label">Chọn nhà xe</label>
    </div>
    <div class="form-floating">
        <select class="form-control" id="newstatus" name="newstatus">
            <option value="0">Không thông qua</option>
            <option value="1">Thông qua</option>
        </select>
        <label for="newstatus" class="form-label">Tình trạng nhà xe</label>
    </div>
    <div>
        <br>
        <input type="submit" value="Xác nhận tình trạng" class="btn btn-danger"/>
    </div><br>
</form>
<div>
    <div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="my-input" onkeyup="mySearchGarageStatus()" placeholder="Search for names..">
    
</div>
    <table class="table" id="my-garage">
        <tr>
            <th>Mã</th>
            <th>Tên nhà xe</th>
            <th>Nhân viên</th>
            <th>Tình trạng xác nhận</th>
            <th>Ngày tạo</th>
        </tr> 
        <c:forEach items="${nhaxe}" var = "b" > 
            <c:if test="${b.status==null || b.status=='0'}">
                <tr>
                    <td id ="m${b.id}">${b.id}</td>
                    <td id ="r${b.id}">${b.name}</td>
                    <td id ="nv${b.id}"> ${b.idUser.userName}</td>
                    <td id ="t${b.id}">
                        <c:if test="${b.status=='0'}">Không thông qua</c:if>
                        <c:if test="${b.status==null}">Chưa kiểm duyệt</c:if>
                        </td>
                        <td id ="ngt${b.id}">${b.createTime}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>


<h3>Xác nhận chuyến xe:</h3>

<form action="${action}">
    <div class="form-floating mb-3 mt-3">
        <select class="form-select" name="idBuses2" id="idBuses2">
            <option value="0"></option>
            <c:forEach items="${chuyenxe}" var="c">
                <option value="${c.id}">${c.id}. ${c.name}</option>
            </c:forEach>
        </select>
        <label for="idBuses" class="form-label">Chọn chuyến xe</label>
    </div>
    <div class="form-floating">
        <select class="form-control" id="newactive" name="newactive">
            <option value="0">Ngưng hoạt động</option>
            <option value="1">Hoạt động</option>
        </select>
        <label for="loai" class="form-label">Trạng trạng xe</label>
    </div>
    <div>
        <br>
        <input type="submit" value="Xác nhận tình trạng" class="btn btn-danger"/>
    </div><br>
</form>
<div>
    <div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="my-input-2" onkeyup="mySearchBusesStatus()" placeholder="Search for names..">
    
</div>
<table class="table" id="my-buses">
    <div>
        <tr>
            <th>Mã</th>
            <th>Tên nhà xe</th>
            <th>Loại xe</th>
            <th>Nhân viên</th>
            <th>Tình trạng xác nhận</th>
            <th>Ngày tạo</th>
        </tr> 
        <c:forEach items="${chuyenxe}" var = "b" > 
            <c:if test="${b.active==null || b.active=='0'}">
                <tr>
                    <td id ="bus${b.id}">${b.id}</td>
                    <td id ="nameb${b.id}">${b.name}</td>
                    <td id ="typebus${b.id}">${b.typeOfBusId.context}</td>
                    <td id ="ubus${b.id}"> ${b.driverId.userName}</td>
                    <td id ="acbus${b.id}">
                        <c:if test="${b.active=='0'}">Ngưng hoạt động</c:if>
                        <c:if test="${b.active==null}">Chưa kiểm duyệt</c:if>
                        </td>
                        <td id ="ntbus${b.id}">${b.createAt}</td>
                </tr>
            </c:if>
        </c:forEach>
</table>
</div>
<script src="<c:url value="/js/buses.js" />"></script>