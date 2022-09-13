<%-- 
    Document   : route-details
    Created on : Aug 15, 2022, 12:46:24 PM
    Author     : HP
--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <h1 class="route-detail-header text-center">${route.routename}</h1>   
    <!--    <div>
    <c:choose>
        <c:when test="${route.image != null}">
            <img  src="${route.image}" alt="anh chuyen xe" class="img-fluid card-img-top"/>
        </c:when>
        <c:when test="${route.image == null}">
            <img  src="<c:url value="/image/defaultXeKhach.jpg"/>" alt="anh chuyen xe" class="img-fluid card-img-top"/>
        </c:when>
    </c:choose>
</div>-->

    <div class="row">
        <h4>Nhập ngày muốn xuất phát: </h4>
        <c:url value="/route/${route.rid}" var="action" />
        <form  method="get" action="${action}" class="d-flex">
            <input type="date" name="ngaymuondi" min="2022-02-02" onfocus="this.min = new Date().toISOString().split('T')[0]"/>

            <button type="submit" class="btn btn-primary" type="button">Tìm</button>
        </form>
    </div>
    <c:if test="${routeBuses.size() == 0}">
        <p>
            <em>Không có chuyến xe nào!!!</em>
        </p>
    </c:if>
    <div class ="row">
        <c:forEach items="${routeBuses}" var = "routeBus">   
            <div class="col-md-3 col-xs-12" style = "padding: 4px;">
                <div class="card">
                    <img class="card-img-top" class = "img-fluid" src="${route.image}" alt="Card image">
                    <div class="card-body">
                        <h5 class="card-title">Tên xe: ${routeBus.busesId.busesName} </h5>
                        <p class="card-title">Ngày đi: <input id = "ngaydibuses" value="${routeBus.ngaydi}" readonly /> </p>
                        <p class="card-title">Giờ đi: ${routeBus.giodi} </p>
                        <p class="card-title">Số ghế còn lại: ${routeBus.soghe}</p>
                        <a id="datve" style ="display: block " href="<c:url value="/route/${route.rid}/${routeBus.rbid}"/>" class="btn btn-primary">Đặt vé</a>
                        <button id="kothe" style ="display: none ">Quá ngày</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<ul class="pagination">

    <c:forEach begin="1" end="${Math.ceil(routebCounter/page_size)}" var="i">
        <li><a href="<c:url value="/route/${route.rid}" />?page=${i}" class="btn">${i}</a></li>
        </c:forEach>
</ul>
<script>
    var pk = document.getElementById("ngaydibuses").value;
    let nowd = new Date().toISOString().split('T')[0];
    if (nowd > pk)
    {
        document.getElementById("datve").style.display = "none";
        document.getElementById("khothe").style.display = "block";
    }

</script>