<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <%@include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="search_ticket"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>

                <small>年票查询</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header">
                    <form method="post">
                        <input type="text" placeholder="请输入年票卡号" name="ticketNum" value="${param.ticketNum}"><button>搜索</button>
                    </form>

                </div>

               <c:if test="${not empty message}">
                   <div class="alert alert-danger">${message}</div>
               </c:if>

                <c:if test="${not empty ticket}">
                    <ul class="list-group">
                        <li class="list-group-item">
                            年票号码: ${ticket.ticketNum}
                        </li>

                        <li class="list-group-item">
                            年票状态: ${ticket.status}
                        </li>

                        <li class="list-group-item">
                            开卡时间: <fmt:formatDate value="${ticket.openCardTime}"/>
                        </li>
                        <li class="list-group-item">
                            截至时间: <fmt:formatDate value="${ticket.invalidateTime}"/>
                        </li>

                    </ul>
                </c:if>


            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
</body>
</html>