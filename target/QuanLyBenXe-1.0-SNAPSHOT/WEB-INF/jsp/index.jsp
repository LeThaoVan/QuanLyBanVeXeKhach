<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')">
<div class="row">
    <a class="btn btn-danger" href="<c:url value="/admin/listbuses"/>">Quản lý bến xe khách</a>
</div>
</sec:authorize>

<div class="row">
    <h4>Nhập tuyến xe muốn tìm:</h4>
    <c:url value="/" var="action" />
    <form  method="get" action="${action}" class="d-flex">
        <label for="fname">&#128681</label>
        <select name="st">
            <option value="0"></option>
            <c:forEach items="${provinces}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </select>
        <label for="fname"> &#128256</label>
        <select name="st2">
            
            <option value="0"></option>
            <c:forEach items="${provinces}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </select>
         <button type="submit" class="btn btn-primary" type="button">Tìm</button>
    </form>
</div>
<h4>Tuyến đường phổ biến:</h4>
<c:if test="${routes.size() == 0}">
    <p>
        <em>Không có tuyến xe nào!!!</em>
    </p>
</c:if>
<div class ="row">
    <c:forEach items="${routes}" var = "b">   
        <div class="col-md-3 col-xs-12" style = "padding: 4px;">
            <div class="card">
                <img class="card-img-top" class = "img-fluid" src="${b.image}" alt="Card image">
                <div class="card-body">
                    <h5 class="card-title">${b.routename}</h5>
                    <p class="card-title">Điểm xuất phát: ${b.startingpoint.name}</p>
                    <p class="card-title">Điểm đến: ${b.destination.name}</p>

                    <a href="<c:url value="/route/${b.rid}"/>" class="btn btn-primary">Xem thêm</a>
                </div>
            </div>
        </div>

    </c:forEach>
</div>

 <ul class="pagination">
     
            <c:forEach begin="1" end="${Math.ceil(routeCounter/page_size)}" var="i">
            <li><a href="<c:url value="/" />?page=${i}" class="btn">${i}</a></li>
            </c:forEach>
</ul>


