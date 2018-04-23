<%@ page import="com.kaishengit.tms.entity.manage.Roles" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kaishengit.tms.entity.manage.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 编辑帐号</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treeGrid/css/jquery.treegrid.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
    <style>
        .icheckbox_square-aero, .iradio_square-aero {
            margin: 0;
            padding: 0;
            width: 18px;
            height: 18px;
            border: none;
            cursor: pointer;
        }

    </style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="manage_account"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                角色管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">新增帐号</h3>
                    <div class="box-tools">
                        <a href="/manage/account" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>帐号名称</label>
                            <input type="text" name="accountName" value="${account.accountName}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>帐号电话</label>
                            <input type="text" name="accountMobile" value="${account.accountMobile}" class="form-control">
                        </div>
                        <%--<div class="form-group">
                            <label>帐号密码</label>
                            <input type="password" name="accountPassword" class="form-control">
                        </div>--%>

                        <div class="form-group">
                            <label >角色</label><br>
                            <c:forEach items="${rolesList}" var="role">
                                <div class="checkbox-inline">
                                    <input id="${role.id}" type="checkbox" name="roleIds" value="${role.id}">${role.rolesName}
                                </div>
                            </c:forEach>

                        </div>


                        <%--<table class="table tree">
                            <thead>
                            <tr>
                                <th></th>
                                <th>角色名称</th>
                                <th>角色代号</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${rolesList}" var="role">
                                        <tr class="treegrid-${role.id} treegrid-expanded">
                                            <th>
                                                <input type="checkbox" class="icheckbox_square-aero" name="rolesId" value="${role.id}">
                                            </th>
                                            <td>${role.rolesName}</td>
                                            <td>${role.rolesCode}</td>

                            </c:forEach>
                            </tbody>
                        </table>--%>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn pull-right btn-primary" id="saveBtn">保存</button>
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
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {


        <%
            Account account = (Account) request.getAttribute("account");
            List<Roles> rolesList = account.getRolesList();
            for(Roles role : rolesList){
        %>

            var id = <%=role.getId() %>
            $("#"+id).attr("checked","true");
        <%
            }
        %>



        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });

        $('input[type=checkbox]').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    })
</script>
</body>
</html>