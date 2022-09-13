<%-- 
    Document   : listbuses
    Created on : Aug 8, 2022, 10:53:25 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1>Admin quản lý</h1>





<div id="myBtnContainer">
    <button class="btn active" onclick="filterSelection('all')"> Show all</button>
    <button class="btn" onclick="filterSelection('tuyenxe')">Tuyến xe</button>
    <button class="btn" onclick="filterSelection('chuyenxe')">Chuyến xe</button>
    <button class="btn" onclick="filterSelection('tram')">Trạm</button>
    <button class="btn" onclick="filterSelection('routebuses')">Tuyến xe của Chuyến xe</button>

    <button class="btn"><a href="<c:url value="/admin/users"/>">Người dùng</a></button> 

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
                <td></td>
            </tr> 
            <c:forEach items="${routes}" var = "b" > 
                <tr>
                    <td id ="route${b.rid}">${b.routename}</td>
                    <td id ="xp${b.rid}">${b.startingpoint.name}</td>
                    <td id ="den${b.rid}">${b.destination.name}</td>
                    <td id ="ngt${b.rid}">${b.createdatetime}</td>
                    <td>
                        <button type="submit" class="btn btn-primary" type="button">Sửa</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <div class="filterDiv routebuses">
        <h6>Danh sách tuyến xe của chuyến xe:</h6>
        <table class="table">
            <tr>
                <th>Tên chuyến xe</th>
                <th>Ngày đi</th>
                <th>Ngày đi</th>
                <th>Giá vé</th>                
                <th>Tuyến đường</th>
                <th></th>
            </tr> 
            <c:forEach items="${routebuses}" var = "b" > 
                <tr>
                    <td id ="buses${b.rbid}">${b.busesId.busesName}</td>
                    <td id ="ngaydi${b.rbid}">${b.ngaydi}</td>
                    <td id ="giodi${b.rbid}">${b.giodi}</td>
                    <td id ="gia${b.rbid}">${b.price}</td>
                    <td id ="route${b.rbid}">${b.routeId.routename}</td>
                    <td>
                        <button type="submit" class="btn btn-primary" type="button">Sửa</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>  
            <a href="<c:url value="/admin/routebuses" />"class="btn">
                <h7>Thêm và xóa tuyến xe cho chuyến xe &#62&#62</h7>
            </a>
        </div>
    </div>
    <br>
    <div class="filterDiv chuyenxe">
        <h6>Danh sách chuyến xe:</h6>
        <table class="table">
            <tr>
                <th>Tên chuyến xe</th>
                <th>Loại xe</th>
                <th>Mã tài xế</th>
                <th></th>
            </tr> 
            <c:forEach items="${chuyenxe}" var = "b" > 
                <tr>
                    <td id ="buses${b.bid}">${b.busesName}</td>
                    <td id ="ngaydi${b.bid}">${b.loaixeID.loaiXe}</td>
                    <td id ="taixe${b.bid}">${b.driverID}</td>
                    <td>
                        <button type="submit" class="btn btn-primary" type="button">Sửa</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>  
            <a href="<c:url value="/admin/buses" />"class="btn">
                <h7>Thêm và xóa tuyến xe cho chuyến xe &#62&#62</h7>
            </a>
        </div>
    </div>
    <br>


    <br>
    <div class="filterDiv tram">
        <h6>Danh sách trạm:</h6>
        <table class="table">
            <tr>
                <th>Mã</th>
                <th>Tên trạm</th>
                <th>Địa chỉ</th>
                <th></th>
            </tr> 
            <c:forEach items="${tramxe}" var = "c" > 
                <tr>
                    <td id ="matram${c.idtram}">${c.idtram}</td>
                    <td id ="ten${c.idtram}">${c.tenTram}</td>

                    <td id ="taixe${c.idtram}">${c.wardId}</td>
                    <td>
                        <button type="submit" class="btn btn-primary" type="button">Sửa</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>  
            <a href="<c:url value="/admin/tram" />"class="btn">
                <h7>Thêm và xóa trạm &#62&#62</h7>
            </a>
        </div>
    </div>


</div>

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

    filterSelection("all")
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
