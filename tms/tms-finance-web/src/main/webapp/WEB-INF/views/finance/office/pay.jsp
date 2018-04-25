<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点单缴费</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="finance_office"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点缴费
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">售票点缴费</h3>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>总价</label>
                            <input type="text" class="form-control" disabled value="${ticketOutRecord.totalPrice}">
                        </div>

                        <div class="form-group">
                            <label>支付类型: &nbsp&nbsp</label>
                            <input type="checkbox" checked
                                   value="现金" name="payType" id="cash">现金 &nbsp&nbsp&nbsp

                            <input type="checkbox" value="刷卡" name="payType" id="card">刷卡
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn btn-primary pull-right" id="saveBtn">支付</button>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {

        $("#saveBtn").click(function () {
          layer.confirm("确定要支付吗",function () {
              $("#saveForm").submit();
          });
        });


         $("#cash").click(function () {

           $(this).prop("checked","true");

           if($("#card").is(":checked")){
               $("#card").removeAttr("checked");
           }
        });

        $("#card").click(function () {
            $(this).prop("checked","true");
            if($("#cash").is(":checked")){
                $("#cash").removeAttr("checked");
            }
        });


    });
</script>
</body>
</html>