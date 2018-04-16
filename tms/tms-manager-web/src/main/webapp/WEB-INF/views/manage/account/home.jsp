<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 角色管理</title>
    <%@include file="../../include/css.jsp"%>
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

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="manage_roles"/>
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
                    <h3 class="box-title">帐号列表</h3>
                    <div class="box-tools">
                        <a href="/manage/account/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增帐号</a>
                    </div>
                </div>
                <div class="box-body">

                    <table class="table">
                        <tr>
                            <th>帐号名称</th>
                            <th>手机号</th>
                            <th>角色</th>
                            <th>帐号状态</th>
                            <th>创建时间</th>
                            <th>#</th>
                        </tr>

                        <c:forEach items="${accountList}" var="account">
                            <tr>
                                <td>${account.accountName}</td>
                                <td>${account.accountMobile}</td>
                                <td>
                                    <c:forEach items="${account.rolesList}" var="role">
                                        ${role.rolesName}&nbsp
                                    </c:forEach>
                                </td>
                                <td>${account.accountStatus}</td>
                                <td><fmt:formatDate value="${account.createTime}" pattern="yyyy年MM月dd日"/> </td>
                                <td><span ><a title="编辑" href=""><i class="fa fa-edit" style="color: blueviolet"></i></a></span> &nbsp <span title="删除"><i class="fa fa-remove" style="color: red"></i></span></td>
                            </tr>

                        </c:forEach>


                    </table>


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

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/treeGrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treeGrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {






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