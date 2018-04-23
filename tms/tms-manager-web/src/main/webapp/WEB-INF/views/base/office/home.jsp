<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 基本信息管理 - 售票点管理</title>
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
        <jsp:param name="menu" value="base_office"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">售票点列表</h3> <c:if test="${not empty message}"><span class="alert alert-dangerous" style="padding-left: 80px;color: red">${message} </span></c:if>
                    <div class="box-tools">
                        <shiro:hasPermission name="office:add">
                            <a href="/base/office/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增售票点</a>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body">

                    <table class="table">
                        <tr>
                            <th>售票点名称</th>
                            <th>法人姓名</th>
                            <th>手机号</th>
                            <th>售票点状态</th>
                            <th>创建时间</th>
                            <th>#</th>
                        </tr>

                        <c:forEach items="${officeList}" var="office">
                            <tr>
                                <td><a href="/base/office/${office.id}/detail">${office.officeName}</a></td>
                                <td>${office.legalPersonName}</td>
                                <td>${office.legalPersonMobile}</td>
                                <td>${office.ticketOfficeStatus}</td>
                                <td><fmt:formatDate value="${office.createTime}" pattern="yyyy年MM月dd日"/> </td>
                                <td>
                                    <%--<shiro:hasPermission name="office:edit">
                                        <span ><a title="编辑" href="/base/office/${office.id}/edit"><i class="fa fa-edit" style="color: blueviolet"></i></a></span> &nbsp
                                    </shiro:hasPermission>

                                    <shiro:hasPermission name="office:del">
                                        <span title="删除"><i class="fa fa-remove" style="color: red"></i></span>
                                    </shiro:hasPermission>--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

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