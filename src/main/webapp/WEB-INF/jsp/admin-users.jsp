<%-- 
    Document   : admin-users
    Created on : Sep 23, 2022, 5:18:05 PM
    Author     : pc
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="wrapper">
    <div class="section">
        <div class="box-area">
            <h1 class="text-center text-primary">Sửa vai trò người dùng</h1>
            <c:url value="/admin/users" var="action" />

            <form action="${action}">
                <form:errors path="*" element="div" cssClass="alert alert-danger" />

                <div class="form-floating mb-3 mt-3">
                    <select class="form-select" name="idU" id="idU">
                        <option value="0"></option>
                        <c:forEach items="${nguoidung}" var="c">
                            <option value="${c.id}">${c.userName}</option>
                        </c:forEach>
                    </select>
                    <label for="name">Chọn người dùng muốn đổi vai trò</label>
                </div>

                <div class="mb-3 mt-3">
                    <select class="form-control" id="newrode" name="newrode">
                        <option value="ROLE_ADMIN">ADMIN</option>
                        <option value="ROLE_DRIVER">Tài xế</option>
                        <option value="ROLE_STAFF_NO1">Nhân viên bến xe</option>
                        <option value="ROLE_STAFF_NO2">Nhân viên nhà xe</option>
                        <option value="ROLE_USER">Khách hàng</option>
                    </select>
                </div>

                <div>
                    <br>
                    <input type="submit" value="Sửa chuyến xe" class="btn btn-danger"/>
                </div>
            </form>

            <div class="spinner-border text-success" id="mySpinner"></div>
            <table class="table" id = "myTable">
                <tr>
                    <th>id</th>
                    <th></th>
                    <th>Tên đăng nhập</th>
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>SDT</th>
                    <th>Vai trò</th>
                    <th></th>
                </tr> 
                <tbody id="myUsers">

                </tbody>
            </table>
        </div>

    </div>
</div>
<script src="<c:url value="/js/users.js" />"></script>
<script>
    <c:url value="/api/users" var="u" />

    window.onload = function () {
        getUsers('${u}');
    }

</script>