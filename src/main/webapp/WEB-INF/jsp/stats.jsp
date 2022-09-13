<%-- 
    Document   : stats
    Created on : Aug 26, 2022, 6:08:34 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">Thống kê báo cáo</h1><br>



<h5 style ="color: blue">1) Thống kê số lượng tuyến xe của chuyến xe</h5> <br>
<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Tên chuyến xe</th>
                <th>Số lượng tuyến xe</th>
            </tr>
            <c:forEach items="${routebusesStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <canvas id="myChart"></canvas>
    </div>
</div>


<h5 style ="color: blue">2) Thống kê doanh thu từng chuyến xe</h5> <br>
<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Tên chuyến xe</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${ticketStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}đ</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <c:url value="/admin/stats" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3">
                <select class="form-control" name="qm" id = "monthorquarter" onclick = "monthandquarter()" >
                    <option  value="MONTH">MONTH</option>
                    <option  value="QUARTER">QUARTER</option>
                </select>
            </div>
            <div class="mb-3 mt-3">
                <input id = "qm"type="number" max="12" min="1" class="form-control" placeholder="Nhập tháng/quý" name="mth">
            </div>
            <div class="mb-3">
                <input type="number" class="form-control" placeholder="Nhập năm" name="year" id="year">
            </div>
            <button type="submit" class="btn btn-primary">Lọc dữ liệu</button>
        </form>
        <canvas id="myChart2"></canvas>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
                    window.onload = function () {
                        let data = [];
                        let labels = [];
                        let data2 = [];
                        let labels2 = [];

    <c:forEach items="${routebusesStats}" var="c">
                        data.push(${c[2]});
                        labels.push('$${c[1]}');
    </c:forEach>
    <c:forEach items="${ticketStats}" var="c">
                        data2.push(${c[2]});
                        labels2.push('$${c[1]}');
    </c:forEach>

                        ticketStats(labels2, data2);
                        busesStats(labels, data);

                    }

                    function monthandquarter() {
                        var qm = document.getElementById("monthorquarter").value;
                        if (qm == "MONTH") {
                            document.getElementById("qm").max = 12;
                        } else {
                            document.getElementById("qm").max = 4;
                        }

                    }

</script>


