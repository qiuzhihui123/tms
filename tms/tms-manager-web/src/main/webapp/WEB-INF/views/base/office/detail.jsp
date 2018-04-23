<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点详情</title>
    <%@include file="../../include/css.jsp"%>
    <style>
        .photo {
            width: 100%;
            height: 320px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 320px;
        }
    </style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="ticket_store"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点详情
            </h1>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title" style="display: inline-block">售票点信息
                        <c:if test="${ message == '更新成功'}">
                        <span style="width: 200px;text-align: center;margin-left: 200px " class="alert alert-success pull-right">
                                ${message}
                        </span>
                        </c:if>

                        <c:if test="${ message == '更新失败'}">
                        <span style="width: 200px;text-align: center " class="alert alert-danger pull-right">
                                ${message}
                        </span>
                        </c:if>
                    </h3>

                    <div class="box-tools">
                        <a href="/base/office/${office.id}/edit" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i> 编辑</a>
                        <a href="javascript:;" rel="${office.id}" id="officeDel" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> 删除</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td class="text-muted">售票点名称</td>
                            <td>${office.officeName}</td>
                            <td class="text-muted">联系人</td>
                            <td>${office.legalPersonName}</td>
                            <td class="text-muted">联系电话</td>
                            <td>${office.legalPersonMobile}</td>
                        </tr>
                        <tr>
                            <td class="text-muted">地址</td>
                            <td colspan="3">${office.officeAddress}</td>
                            <td class="text-muted">创建时间</td>
                            <td><fmt:formatDate value="${office.account.createTime}" pattern="yyyy年MM月dd日"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">关联账号</h3>
                    <div class="box-tools">

                        <a href="javascript:;" rel="${office.id}" id="acocuntForbidden"class="btn btn-${office.account.status == '禁用' ? 'success':'danger'} btn-sm">

                            <c:if test="${office.account.status == '正常'}">
                                <i class="fa fa-ban"></i>
                            </c:if>

                            ${office.account.status == '禁用' ? '启用账号':'禁用帐号'}</a>

                    <%--<c:choose>
                            <c:when test="${office.account.status == '禁用'}">
                                <a href="javascript:;" rel="${office.id}" id="acocuntForbidden"class="btn btn-danger btn-sm"><i class="fa fa-ban"></i> 禁用账号</a>
                            </c:when>
                            <c:when test="${office.account.status == '正常'}">
                                <a href="javascript:;" rel="${office.id}" id="acocuntForbidden"class="btn btn-success btn-sm"><i class="fa fa-ban"></i> 启用账号</a>
                            </c:when>
                        </c:choose>--%>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tr>
                            <td class="text-muted">账号</td>
                            <td>${office.account.ticketOfficeAccountName}</td>
                            <td class="text-muted">状态</td>
                            <td>${office.account.status}</td>
                            <td class="text-muted">创建时间</td>
                            <td><fmt:formatDate value="${office.account.createTime}" pattern="yyyy年MM月dd日"/></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">关联资质</h3>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="photo">
                                <img src="http://p7hdkn0j6.bkt.clouddn.com/${office.legalPersonCardUp}-pre" title="身份证">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="photo">
                                <img src="http://p7hdkn0j6.bkt.clouddn.com/${office.ticketOfficeLicense}-pre" title="营业执照">
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

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        /*删除office按钮*/
        $("#officeDel").click(function(){
            var officeId = $(this).attr("rel");
            var index = -1;

           index = layer.confirm("确定要删除吗",function(){
               layer.close(index);
              $.get("/base/office/"+officeId+"/del").success(function (data) {
                if(data.status == 'success'){
                    index = layer.msg("删除成功");
                    location.href="/base/office"
                }else {
                    layer.ms("服务器忙");
                }
              }).error(function () {
                  layer.msg("服务器忙");
              }).complete(function () {
                layer.close(index);
              })
           });

        });

        /*禁用帐号*/
        $("#acocuntForbidden").click(function(){
            var officeId = $(this).attr("rel");
            var status = "${office.account.status}";
            var index = -1;
            if(status == '正常'){
                index = layer.confirm("确定要禁用该帐号吗",function(){

                    $.get("/base/office/"+officeId+"/forbidden").success(function(data){
                        if(data.status == 'success'){
                            history.go(0);
                        }
                    }).error(function () {
                        layer.msg("服务器忙");
                    }).complete(function () {
                        layer.close(index);
                    });
                })
            }else {
                $.get("/base/office/"+officeId+"/forbidden").success(function(data){
                    if(data.status == 'success'){
                        history.go(0);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                }).complete(function () {
                    layer.close(index);
                });
            }

        });

    });
</script>
</body>
</html>
