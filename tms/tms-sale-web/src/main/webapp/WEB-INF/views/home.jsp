<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>销售统计 </title>
    <%@include file="include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="include/sider.jsp">
        <jsp:param name="menu" value="home"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>

                <small>欢迎您，<shiro:principal property="officeName"/>销售点</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">

                <div class="box-header">
                    <h4 class="box-title">年票统计</h4>
                </div>


                <div class="box-body">
                    <div class="row">

                        <div class="col-md-2">
                            <div class="description-block border-right">
                                <h5 class="description-header">${saleMap.total_num}</h5>
                                <span class="description-text">总领取数量</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="description-block border-right">
                                <h5 class="description-header">${saleMap.out_num}</h5>
                                <span class="description-text">余量</span>
                            </div>
                        </div>


                        <div class="col-md-2">
                            <div class="description-block border-right">
                                <h5 class="description-header">${saleMap.saled_num}</h5>
                                <span class="description-text">已销售</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="description-block border-right">
                                <h5 class="description-header">${saleMap.lost_num}</h5>
                                <span class="description-text">已挂失</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="description-block border-right">
                                <h5 class="description-header">${saleMap.past_num}</h5>
                                <span class="description-text">已过期</span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="include/js.jsp"%>
</body>
</html>