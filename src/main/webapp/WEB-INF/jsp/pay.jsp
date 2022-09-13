<%-- 
    Document   : pay
    Created on : Sep 1, 2022, 8:14:12 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Day la trang thanh toan</h1>
<div class="container">
    <c:if test="${statusPay == null}">
    <p class="tile">Mã vé: ${ticket.tid} </p>
    <p class="tile">Hành khách: ${ticket.userId.username} </p>
    <p class="tile">Email: ${ticket.userId.email} </p>
    <p class="tile">Số điện thoại: ${ticket.userId.sdt} </p>
    <p class="tile">Điểm đón: ${ticket.pickupStationId} </p>
    <p class="tile">Điểm trả: ${ticket.arriveStationId} </p>
    <p class="tile">Tổng tiền: ${ticket.total} </p>
    </c:if>    
    <c:if test="${statusPay != null}">
        <div class="btn btn-primary"> Vé đã thanh toán</div>
    </c:if>
       <form id="elements" onchange="showValue()">
        <input type="radio" id="r1" name="element" value="1">  Tiền mặt
        <input type="radio" id="r2" name="element" value="2"> ZaloPay
        <input type="radio" id="r3" name="element" value="3" checked="checked"> Momo
      </form>
        <div id="results"></div>

        
        
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="alert alert-danger">Vui lòng đến quầy vé gần nhất để thanh toán</div>
        </c:if>   
         <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="alert alert-danger">Vui lòng đến quầy vé gần nhất để thanh toán</div>
            <sec:authorize access="hasRole('ROLE_USER')">
                <div class="alert alert-danger">Vui lòng đến quầy vé gần nhất để thanh toán</div>
            </sec:authorize>
            <sec:authorize access="hasRole('STAFF','ROLE_ADMIN')">
                <a type="submit"  href="<c:url value="/pay/${ticket.tid}"/>"class="btn btn-danger" >Thanh toán </a>
            </sec:authorize>   
        </c:if>      
        
         
    
        
</div>

<script>
    window.onload()= function(){
        const ele = document.forms.elements.elements["element"];
        showValue();
        function showValue(){      
            document.getElementById('results').innerHTML =  `Giá Trị ${ele.value}`;
        }
    }

</script>

