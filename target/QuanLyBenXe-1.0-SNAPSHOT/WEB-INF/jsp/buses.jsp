<%-- 
    Document   : buses
    Created on : Aug 6, 2022, 8:29:06 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<h1 class="text-center text-primary">Thêm chuyến xe</h1>


<c:url value="/admin/buses" var="action" />


<div id="myBtnContainer">
    <button class="btn" onclick="filterSelection('themchuyenxe')">Thêm chuyến xe</button>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <button class="btn" onclick="filterSelection('suachuyenxe')">Sửa chuyến xe</button>
    </sec:authorize>
</div>

<div class="filterDiv themchuyenxe">
    <form:form method="post" action="${action}" modelAttribute="buses">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" path="busesName" class="form-control" id="name" placeholder="name" name="name" />
            <label for="name">Tên chuyến xe</label>
        </div>

        <div class="form-floating">
            <form:select path="driverID" class="form-select" id="driver" name="driver">
                <c:forEach items="${users}" var="c">
                    <c:if test="${c.rode == 'Driver'}">
                        <option value="${c.userid}">${c.username}</option>
                    </c:if>
                </c:forEach>
            </form:select>
            <label for="driver" class="form-label">Danh sách tài xế</label>
        </div><br>

        <div class="form-floating">
            <form:select path="loaixeID" class="form-select" id="loai" name="loai">
                <c:forEach items="${loaixe}" var="c">
                    <option value="${c.lid}">${c.loaiXe}</option>
                </c:forEach>
            </form:select>
            <label for="loai" class="form-label">Loại xe</label>
        </div><br>

        <div>
            <br>
            <input type="submit" value="Thêm chuyến xe" class="btn btn-danger"/>
        </div>
    </form:form>
</div>


<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div class="filterDiv suachuyenxe">

        <form action="${action}">
            <label for="name">Chọn chuyến xe muốn sửa</label>
            <div class="form-floating mb-3 mt-3">
                <select class="form-select" name="idBuses" id="idBuses">
                    <c:forEach items="${chuyenxe}" var="c">
                        <option value="${c.bid}">${c.busesName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating mb-3 mt-3">
                <input type="text" class="form-control" id="tenchuyenxe" placeholder="tên mới" name="tenchuyenxe" />
            </div>
            <div class="form-floating">
                <select class="form-control" id="status" name="status">
                    <option value="0">Xe ngưng hoạt động</option>
                    <option value="1">Xe còn hoạt động</option>
                </select>
                <label for="loai" class="form-label">Trạng trạng xe</label>
            </div>
            <div>
                <br>
                <input type="submit" value="Sửa chuyến xe" class="btn btn-danger"/>
            </div>
        </form>
    </div>
</sec:authorize>

<div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="myInput" onkeyup="mySearchBuses()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>Mã</th>
        <th></th>
        <th>Tên chuyến xe</th>      
        <th>Tình trạng hoạt động</th>

    </tr>
    <tbody id="myBuses">

    </tbody>
</table>

<div>  
    <a href="<c:url value="/admin/routebuses" />"class="btn"  style="padding-left: 75%">
        <h7>Thêm tuyến xe cho chuyến xe &#62&#62</h7>
    </a>
</div>

<script src="<c:url value="/js/buses.js" />"></script>
<script>
    <c:url value="/api/buses" var="u" />

        window.onload = function () {
            getBuses('${u}');
        }

</script>


<style>

    .filterDiv {
        display: none;
    }

    .show {
        display: block;
    }

    .container {
        margin-top: 20px;
        overflow: hidden;
    }

    /* Style the buttons */
    .btn {
        border: none;
        outline: none;
        padding: 12px 16px;
        background-color: #f1f1f1;
        cursor: pointer;
    }

    .btn:hover {
        background-color: #ddd;
    }

    .btn.active {
        background-color: #666;
        color: white;
    }
    h6 {
        text-align: center;
        color: red;
    }
</style>
<script>

    // filterSelection("all")
    function filterSelection(c) {
        var x, i;
        x = document.getElementsByClassName("filterDiv");
        if (c == "all")
            c = "";
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
            if (x[i].className.indexOf(c) > -1)
                w3AddClass(x[i], "show");
        }
    }

    function w3AddClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            if (arr1.indexOf(arr2[i]) == -1) {
                element.className += " " + arr2[i];
            }
        }
    }

    function w3RemoveClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            while (arr1.indexOf(arr2[i]) > -1) {
                arr1.splice(arr1.indexOf(arr2[i]), 1);
            }
        }
        element.className = arr1.join(" ");
    }

// Add active class to the current button (highlight it)
    var btnContainer = document.getElementById("myBtnContainer");
    var btns = btnContainer.getElementsByClassName("btn");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function () {
            var current = document.getElementsByClassName("active");
            current[0].className = current[0].className.replace(" active", "");
            this.className += " active";
        });
    }
</script>
