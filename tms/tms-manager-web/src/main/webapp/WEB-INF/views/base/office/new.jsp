<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 新增角色</title>
    <%@include file="../../include/css.jsp"%>

    <link rel="stylesheet" href="/static/plugins/uploaderbak/webuploader.css">

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
                售票点管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">新增售票点</h3>
                    <div class="box-tools">
                        <a href="/base/office" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">

                        <input type="hidden" name="legalPersonCardUp"  id="identityUp">
                        <input type="hidden" name="legalPersonCardDown"  id="identityDown">
                        <input type="hidden" name="ticketOfficeLicense"  id="license">

                        <div class="form-group">
                            <label>售票点名称</label>
                            <input type="text" name="officeName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>售票点地址</label>
                            <input type="text" name="officeAddress" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>法人名称</label>
                            <input type="text" name="legalPersonName" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>法人电话</label>
                            <input type="text" name="legalPersonMobile" class="form-control">
                        </div>

                        <label style="padding-left: 135px ">身份证正面照片</label> <span style="padding: 200px"></span>   <label>身份证反面照片</label>
                        <%-- ---------------身份证边框---------------- --%>
                        <div class="container-fluid" style="margin:0px;padding:0px;">
                            <div class="raw-md-6">

                                <div class="col-md-6 ">
                                    <div id ="identify-up" class="col-md-4" style="height: 250px;width: 375px;border-style: dashed;border-width: 1px">
                                    </div>
                                </div>

                                <div class="col-md-6 ">
                                    <div id ="identify-down" class="col-md-4" style="height: 250px;width: 375px;border-style: dashed;border-width: 1px">
                                    </div>
                                </div>

                            </div>
                        </div>
                        <%-- ------------身份证上传按钮------------------ --%>

                        <%--左边--%>
                        <div class="col-md-6">
                            <div id="uploader-left" class="wu-example">
                                <!--用来存放文件信息-->
                                <div id="thelist-left" class="uploader-list"></div>
                                <div class="btns pull-right" style="padding-right: 70px; padding-top: 10px">
                                    <div id="picker-left">选择文件</div>
                                </div>
                            </div>
                        </div>

                        <%--右边--%>
                        <div class="col-md-6">
                            <div id="uploader-right" class="wu-example">
                                <!--用来存放文件信息-->
                                <div id="thelist-right" class="uploader-list"></div>
                                <div class="btns pull-right" style="padding-right: 70px; padding-top: 10px">
                                    <div id="picker-right">选择文件</div>
                                </div>
                            </div>
                        </div>

                        <label style="padding-left: 135px;padding-top: 50px;">营业执照照片</label>


                        <div class="container">
                            <%--营业执照边框--%>
                            <div class="col-md-4" id="license-border"style="height: 250px;width: 375px;border-style: dashed;border-width: 1px">
                            </div>
                            <div class="col-md-2">

                                <div id="uploader-buttom" class="wu-example">
                                    <!--用来存放文件信息-->
                                    <div id="thelist-buttom" class="uploader-list"></div>
                                    <div class="btns pull-right" style="padding-right: 70px; padding-top: 160px">
                                        <div id="picker-buttom">选择文件</div>
                                    </div>
                                </div>
                            </div>

                        </div>

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

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/uploaderbak/webuploader.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>


<script>

    $(function () {
        /*提交表单按钮*/
        $("#saveBtn").click(function () {

            $("#saveForm").submit();
        });
    })

    $(function () {


        /* 身份证上 */
        var uploadLeft = WebUploader.create({
            auto:true,
            swf:'/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: 'http://upload-z2.qiniup.com',
            fileVal:'file',
            formData:{
                "token":"${token}"
            },
            // 选择文件的按钮。可选。
            pick: '#picker-left',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false
        });

        var index = -1;
        uploadLeft.on( 'uploadStart', function( file ) {
           index = layer.load(1);
        });

        uploadLeft.on( 'uploadSuccess', function( file,data ) {
            $("#identify-up").html("");
            var fileName = data.key;

            var $img = $("<img>").attr("src","http://p7hdkn0j6.bkt.clouddn.com/"+fileName +"-pre");
            $("#identify-up").append($img);

            $("#identityUp").val(fileName);

        });

        uploadLeft.on( 'uploadError', function( file ) {
            lay.msg("系统异常");
        });

        uploadLeft.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });

        /!*--------------------身份证下----------------------*!/
        var uploadRight = WebUploader.create({

            auto:true,
            // 文件接收服务端。
            server: 'http://upload-z2.qiniup.com',
            fileVal:'file',
            formData:{
                "token":"${token}"
            },
            // 选择文件的按钮。可选。
            pick: '#picker-right',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false
        });

        uploadRight.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });

        uploadRight.on( 'uploadSuccess', function( file,data ) {
            $("#identify-down").html("");
            var fileName = data.key;

            var $img = $("<img>").attr("src","http://p7hdkn0j6.bkt.clouddn.com/"+fileName +"-pre");
            $("#identify-down").append($img);

            $("#identityDown").val(fileName);

        });

        uploadRight.on( 'uploadError', function( file ) {
            lay.msg("系统异常");
        });

        uploadRight.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });



    /!*-------------------营业执照-----------------*!/
        var uploaderButtom = WebUploader.create({

            auto:true,
            // 文件接收服务端。
            server: 'http://upload-z2.qiniup.com',
            fileVal:'file',
            formData:{
              "token":"${token}"
            },
            // 选择文件的按钮。可选。
            pick: '#picker-buttom',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false
        });


        uploaderButtom.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });

        uploaderButtom.on( 'uploadSuccess', function( file,data ) {
            $("#license-border").html("");
            var fileName = data.key;

            var $img = $("<img>").attr("src","http://p7hdkn0j6.bkt.clouddn.com/"+fileName +"-pre");
            $("#license-border").append($img);

            $("#license").val(fileName);

        });

        uploaderButtom.on( 'uploadError', function( file ) {
            lay.msg("系统异常");
        });

        uploaderButtom.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });
    })


</script>

</body>
</html>