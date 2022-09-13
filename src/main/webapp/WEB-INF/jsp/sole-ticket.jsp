<%-- 
    Document   : sole-ticket
    Created on : Aug 19, 2022, 10:18:49 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Trang bán vé</h1>

<div class="container">
 <h1 class="route-detail-header text-center">${route.routename}</h1>   
    <div>
        <c:choose>
            <c:when test="${route.image != null}">
                <img  src="${route.image}" alt="anh chuyen xe" class="img-fluid card-img-top"/>
            </c:when>
            <c:when test="${route.image == null}">
                <img  src="<c:url value="/image/defaultXeKhach.jpg"/>" alt="anh chuyen xe" class="img-fluid card-img-top"/>
            </c:when>
        </c:choose>
    </div>
    
    
    <h5 class="card-title">Ngày đi:${routeBus.ngaydi} </h5>
    <p class="card-title">Giờ đi: ${routeBus.giodi}</p>
    <p class="card-title">Tên xe: ${routeBus.getBusesId().busesName}</p>
    <p class="card-title">Số ghế còn lại: ${routeBus.soghe}</p>
    <p class="card-title">Giá: ${routeBus.price} / 1 ghế</p>
    
    <c:url value="/route/addTicket/${routeBus.getBusesId().getBid()}/${routeBus.rbid}" var="action" />
    <form:form method="post" action="${action}" 
               enctype="multipart/form-data"
               modelAttribute="ticket">
        <div class="form-group">
            <label for="username">Tên khách hàng: </label>
            <form:input class="form-control" type="text" id="username" path="username" value="username" />
        </div>
        
        <div class="form-group">
            <label for="soGhe">Nhập số vé muốn mua: </label>
            <form:input class="form-control" type="number" min="1" name="soghe" path="amount"  id="soGhe" placeholder="Nhap so vé muon mua"  value = "1"/>
            
        </div>
        
        <div class="form-group">
            <label  for="pickupStation">Chọn điểm đón: </label>
            <form:select id="pickupStation" class="form-control"  path="pickupStationId" >
                <c:forEach items="${pickupStations}" var="pickupStation">
                    <option value="${pickupStation.id}">${pickupStation.getIdTram().getTenTram()}</option>
                </c:forEach>
            </form:select>
        </div>  
        <div class="form-group">    
            <label for="arriveStation">Chọn điểm trả: </label>
            <form:select id="arriveStation" class="form-control" path="arriveStationId">
                <c:forEach items="${arriveStations}" var="arriveStation">
                    <option value="${arriveStation.id}">${arriveStation.getIdTram().getTenTram()}</option>
                </c:forEach>
            </form:select>
                    <input  type="Submit" value="Submit" class="btn btn-danger"/>
        </div>
    </form:form>
   
    
    <!--phan binh luan-->
    
    <div class="form-group">
        <textarea class="form-control" id="commentId" placeholder="Nhap binh luan cua ban"></textarea>
    </div>
    
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <button onclick="addComment(${routeBus.rbid}, ${currentUser.userid})" class="btn btn-danger">Them binh luan</button>
    </c:if>
        
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a class="btn btn-danger" href="<c:url value="/login?fromaddcomment=1" />">Them binh luan</a>
    </c:if>
    
   
    
    <div class="row" id="areaComment">
        
        <c:forEach items="${comments}" var="comment">
                <c:if test="${comment.getUserid().avatar != null}">
                    <div class="col-md-2" style="padding:10px;">
                            <img alt="anh user comment" 
                                 class="img-fluid"
                                 style="border-radius: 50%;"
                                 src="${comment.getUserid().avatar}" />
                    </div>
                </c:if>

                <c:if test="${comment.getUserid().avatar == null}">
                    <div class="col-md-2" style="padding:10px;">
                            <img alt="anh user comment" 
                                 class="img-fluid"
                                 style="border-radius: 50%;"
                                 src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/OOjs_UI_icon_userAvatar-constructive.svg/2048px-OOjs_UI_icon_userAvatar-constructive.svg.png" />
                    </div>
                </c:if>
            <div class="col-md-10" >
                <div>
                    <strong>${comment.getUserid().username}</strong> - <span class="timecomment">${comment.creatdatetime}</span>
                </div>
                <p>${comment.context}</p>
            </div>
        </c:forEach>  
    </div>
        
        
    <ul class="pagination">
       <c:forEach begin="1" end="${Math.ceil(countComment/page_comment)}" var="i">
       <li><a href="<c:url value="/route/${route.rid}/${routeBus.rbid}" />?page=${i}" class="btn">${i}</a></li>
       </c:forEach>
    </ul>
</div>
    <c:url value="/js/comment.js" var="url" />
    <script src="${url}"></script>
    <script>
        window.onload = function(){
            let date = document.querySelectorAll(".timecomment");
            for(let i = 0; i < date.length ; i++)
            {
                let d = date[i];
                d.innerText = moment(d.innerText).locale("vi").fromNow();
            }
        }
    </script> 