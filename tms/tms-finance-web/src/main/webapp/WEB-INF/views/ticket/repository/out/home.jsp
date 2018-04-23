<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 角色管理</title>
    <%@include file="../../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treeGrid/css/jquery.treegrid.css">
    <style>
        .fa{
            cursor:pointer
        }

    </style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../../include/sider.jsp">
        <jsp:param name="menu" value="ticket_out"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票下发
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">下发记录</h3> <c:if test="${not empty message}"><span class="label label-success" style="margin-left: 80px;color: red;text-align: center">${message} </span></c:if>

                    <div class="box-tools">
                        <shiro:hasPermission name="account:add">
                            <a href="/ticket/repository/out/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增下发</a>
                        </shiro:hasPermission>
                    </div>
                    <c:if test="${not empty errorMessage}"><span class="label label-danger" style="margin-left: 80px;color: red;text-align: center">${errorMessage}</c:if>
                </div>
                <div class="box-body">

                    <table class="table">
                        <tr>
                            <th>下发时间</th>
                            <th>内容(起始票号)</th>
                            <th>数量</th>
                            <th>下发人员</th>
                            <th>单价</th>
                            <th>总价</th>
                            <th>网点名称</th>
                            <th>状态</th>
                            <th>收款人员</th>
                            <th>支付类型</th>
                        </tr>

                        <c:forEach items="${pageInfo.list}" var="ticketOutRecord">
                            <tr>
                                <td><fmt:formatDate value="${ticketOutRecord.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/> </td>

                                <td>${ticketOutRecord.content}</td>
                                <td>${ticketOutRecord.totalNum}</td>
                                <td>${ticketOutRecord.outAccountName}</td>
                                <td>${ticketOutRecord.price}</td>
                                <td>${ticketOutRecord.totalPrice}</td>
                                <td>
                                    <span class=" label ${ticketOutRecord.status == '未支付' ? 'label-danger':'label-success'}">
                                            ${ticketOutRecord.status}
                                    </span>
                                </td>
                                <td>${ticketOutRecord.officeName}</td>
                                <td>${ticketOutRecord.financeAccountName}</td>
                                <td>${ticketOutRecord.payType}</td>


                                <td>
                                  <%--  <shiro:hasPermission name="account:edit">
                                        <span ><a title="编辑" href="/manage/account/${account.id}/edit"><i class="fa fa-edit" style="color: blueviolet"></i></a></span> &nbsp
                                    </shiro:hasPermission>--%>

                                    <shiro:hasPermission name="account:del">
                                        <c:if test="${ticketOutRecord.status == '未支付'}">
                                            <span title="删除" rel="${ticketOutRecord.id}" class="outRecordDel"><i class="fa fa-remove" style="color: red"></i></span>
                                        </c:if>
                                    </shiro:hasPermission>
                                </td>
                            </tr>

                        </c:forEach>


                    </table>
                    <c:if test="${pageInfo.pages > 1}">
                        <ul id="pagination" class="pagination pull-right"></ul>
                    </c:if>
                    <%--<table class="table tree">
                        <tbody>
                        <c:forEach items="${accountList}" var="account">
                            <tr class="bg-blue">
                                <td>
                                    帐号名称：<strong>${account.accountName}</strong> &nbsp&nbsp&nbsp&nbsp
                                    帐号电话：<strong>${account.accountMobile}</strong>
                                    <span class="pull-right">
                                        <a style="color: #fff;" href="/manage/account/${account.id}/edit"><i class="fa fa-pencil"></i></a>
                                        <a style="color: #fff;" class="delLink" rel="${account.id}" href="javascript:;"><i class="fa fa-trash"></i></a>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <c:forEach items="${account.rolesList}" var="role">
                                        <i class="fa fa-circle"></i> ${role.rolesName}
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>--%>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../../include/js.jsp"%>
<script src="/static/plugins/jquery/jquery.twbsPagination.min.js"></script>
<%--<script src="/static/plugins/treeGrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treeGrid/js/jquery.treegrid.bootstrap3.js"></script>--%>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {

        $('#pagination').twbsPagination({
            totalPages:${pageInfo.pages},
            visiblePages: 5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?p={{number}}"
        });

        $(".outRecordDel").click(function () {
            var outRecordId = $(this).attr("rel");
            layer.confirm("确定要删除吗",function () {
                $.get("/ticket/repository/out/"+outRecordId+"/del").success(function (data) {
                    if(data.status == 'success'){
                        layer.msg("删除成功");
                    }
                }).error(function () {
                    layer.alert("服务器异常");
                }).complete(function () {

                });
            });

        });

       /* $("#accountDel").click(function () {
            var accountId = $(this).attr("rel");
            layer.confirm("确定要删除吗",function () {

                $.get("/manage/account/"+accountId+"/del").success(function (data) {
                    if(data.status == 'success'){
                        history.go(0);
                    }else {
                        layer.alert("服务器异常");
                    }

                }).error(function () {
                    layer.alert("服务器异常");
                }).complete();
            });
        });*/




        /*$('.tree').treegrid();
        //删除
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要删除该帐号？",function (index) {
                layer.close(index);
                $.get("/manage/account/"+id+"/del").done(function (result) {
                    if(result.status == 'success') {
                        window.history.go(0);
                    } else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                });
            })
        });*/
    });
</script>
</body>
</html>