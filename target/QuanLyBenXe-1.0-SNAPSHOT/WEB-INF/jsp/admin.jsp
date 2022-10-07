<%-- 
    Document   : admin
    Created on : Sep 23, 2022, 3:58:42 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" media="all" href="css/admin.css"/>

<div class="wrapper">
    <div class="section">
        <div class="box-area">
            <div id="myBtnContainer">
                <button class="btn" onclick="filterSelection('tuyenxe')">Tuyến xe</button>
                <button class="btn" onclick="filterSelection('chuyenxe')">Chuyến xe</button>
                <button class="btn" onclick="filterSelection('nguoidung')">Người dùng</button>
                <button class="btn" onclick="filterSelection('vexe')">Vé xe</button>
            </div>

            <div class = "container">
                <div class="filterDiv tuyenxe">
                    <h6>Danh sách tuyến xe:</h6>
                    <table class="table">
                        <tr>
                            <th>Tên tuyến xe</th>
                            <th>Điểm xuất phát</th>
                            <th>Điểm đến</th>
                            <th>Ngày tạo</th>
                        </tr> 
                        <c:forEach items="${routes}" var = "b" > 
                            <tr>
                                <td id ="route${b.id}">${b.routename}</td>
                                <td id ="xp${b.id}">${b.startProvince}</td>
                                <td id ="den${b.id}">${b.destination}</td>
                                <td id ="ngt${b.id}">${b.createdatetime}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <br>
                <div class="filterDiv routebuses">
                    <h6>Danh sách tuyến xe của chuyến xe:</h6>
                </div>
                <br>
                <div class="filterDiv chuyenxe">
                    <h6>Danh sách chuyến xe:</h6>

                </div>
                <br>
                <div class="filterDiv nguoidung">
                    <h6>Danh sách người dùng</h6>
                </div>
                <br>
                <div class="filterDiv vexe">
                    <h6>Danh sách vé</h6>
                </div>
                <br>
            </div>
        </div>

    </div>
</div>
<script src="<c:url value="/js/admin.js" />"></script>


