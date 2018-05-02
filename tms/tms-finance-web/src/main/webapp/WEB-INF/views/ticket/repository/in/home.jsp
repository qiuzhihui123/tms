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
        <jsp:param name="menu" value="manage_account"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                帐号管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">帐号列表</h3> <c:if test="${not empty message}"><span class="alert alert-success" style="margin-left: 80px;color: red;text-align: center">${message} </span></c:if>
                    <div class="box-tools">
                        <shiro:hasPermission name="account:add">
                            <a href="/ticket/repository/in/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增入库</a>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body">

                    <table class="table">
                        <tr>
                            <th>入库时间</th>
                            <th>内容</th>
                            <th>起始票号</th>
                            <th>结束票号</th>
                            <th>入库数量</th>
                            <th>入库人员</th>
                            <th>#</th>
                        </tr>

                        <c:forEach items="${pageInfo.list}" var="ticketInRecord">
                            <tr>
                                <td><fmt:formatDate value="${ticketInRecord.createTime}" pattern="yyyy年MM月dd日"/> </td>

                                <td>${ticketInRecord.content}</td>
                                <td>${ticketInRecord.startTicketNum}</td>
                                <td>${ticketInRecord.endTicketNum}</td>
                                <td>${ticketInRecord.totalNum}</td>
                                <td>${ticketInRecord.accountName}</td>

                                <td>
                                    <span title="删除" rel="${ticketInRecord.id}" class="inRecordDel"><i class="fa fa-remove" style="color: red"></i></span>

                                    <shiro:hasPermission name="inRecord:del">
                                    </shiro:hasPermission>
                                </td>
                            </tr>

                        </c:forEach>


                    </table>

                    <c:if test="${pageInfo.pages > 1}">
                        <ul id="pagination-demo" class="pagination pull-right"></ul>
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
<%--<script src="/static/plugins/treeGrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treeGrid/js/jquery.treegrid.bootstrap3.js"></script>--%>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/plugins/jquery/jquery.twbsPagination.js"></script>
<script>
    $(function () {

        /*分页--------------------------------*/
        $('#pagination-demo').twbsPagination({
            totalPages:${pageInfo.pages},
            visiblePages: 3,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?&p={{number}}"
        });

        $(".inRecordDel").click(function () {
            var inRecordId = $(this).attr("rel");
            layer.confirm("确定要删除吗",function () {

                $.get("/ticket/repository/in/"+inRecordId+"/del").success(function (data) {
                    if(data.status == 'success'){
                        layer.msg("删除成功");
                        history.go(0);
                    }
                    if(data.status == 'error'){
                        layer.msg(data.message);
                    }

                }).error(function () {
                    layer.alert("服务器异常");
                }).complete();
            });
        });




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