<%-- 
    Document   : admin-bus
    Created on : Sep 23, 2022, 5:17:29 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="myBtnContainer">
    <button class="btn" onclick="filterSelection('themchuyenxe')">Thêm chuyến xe</button>
    <button class="btn" onclick="filterSelection('suachuyenxe')">Sửa chuyến xe</button>
</div>

<div class="filterDiv themchuyenxe">
    <h1 class="text-center text-primary">Thêm chuyến xe</h1>
    <form:form method="post" action="${action}" modelAttribute="buses">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
            <label for="name">Tên chuyến xe</label>
        </div>

        <div class="form-floating">
            <form:select path="driverId" class="form-select" id="driver" name="driver">
                <c:forEach items="${nguoidung}" var="c">
                    <c:if test="${c.role == 'ROLE_DRIVER'}">
                        <option value="${c.id}">${c.userName}</option>
                    </c:if>
                </c:forEach>
            </form:select>
            <label for="driver" class="form-label">Danh sách tài xế</label>
        </div><br>

        <div class="form-floating">
            <form:select path="typeOfBusId" class="form-select" id="loai" name="loai">
                <c:forEach items="${loaixe}" var="c">
                    <option value="${c.id}">${c.context} số chỗ ${c.chair}</option>
                </c:forEach>
            </form:select>
            <label for="loai" class="form-label">Loại xe</label>
        </div><br>
        <div class="form-group">
            <label  for="avatar">Avatar: </label>
            <form:input class="form-control" type="file" id="avatar" path="image"/>
        </div><br>
        <div>
            <br>
            <input type="submit" value="Thêm chuyến xe" class="btn btn-danger"/>
        </div>
    </form:form>
</div>


<div class="filterDiv suachuyenxe">
    <h1 class="text-center text-primary">Sửa chuyến xe</h1>

    <form action="${action}">
        <div class="form-floating mb-3 mt-3">
            <select class="form-select" name="idBuses" id="idBuses">
                <option value="0"></option>
                <c:forEach items="${chuyenxe}" var="c">
                    <option value="${c.id}">${c.id}. ${c.name}</option>

                </c:forEach>
            </select>
            <div class="form-floating mb-3 mt-3">
                <input type="text" class="form-control" id="tenchuyen" value="${c.name}" name="tenchuyen" />
                <label for="tenchuyen">Nhập tên chuyến xe nếu muốn sửa</label>
            </div>
            <label for="idBuses" class="form-label">Chọn xe muốn sửa</label>
        </div>

        <div class="form-floating">
            <select class="form-select" id="newdriver" name="newdriver">
                <option value="0"></option>
                <c:forEach items="${nguoidung}" var="c">
                    <c:if test="${c.role == 'ROLE_DRIVER'}">
                        <option value="${c.id}">${c.userName}</option>
                    </c:if>
                </c:forEach>
            </select>
            <label for="driver" class="form-label">Chọn tài xế muốn thay đổi</label>
        </div><br>
        <div>
            <br>
            <input type="submit" value="Sửa tên xe" class="btn btn-danger"/>
        </div><br>
    </form>
   
    <br>


</div>



<div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="myInput" onkeyup="mySearchBuses()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>Mã</th>
        <th>Ảnh</th>
        <th>Tên chuyến xe</th> 
        <th>Tình trạng hoạt động</th>   
        <th></th>

    </tr>
    <tbody id="myBuses">

    </tbody>
</table>

<script src="<c:url value="/js/buses.js" />"></script>
<script>
    <c:url value="/api/buses" var="u" />

        window.onload = function () {
            getBus('${u}');
        }


</script>