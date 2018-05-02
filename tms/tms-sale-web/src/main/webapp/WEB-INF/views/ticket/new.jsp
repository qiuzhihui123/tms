<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年票办理</title>

    <%@include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">

    <style>
        .form-control{
            width:250px;
        }
        .photo{
            height: 200px;
            border: dashed;
            color: #c0c0c0;
            vertical-align: middle;
            text-align: center;
        }

    </style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="ticket_new"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
         <%--   <h1>

                <small>年票办理</small>
            </h1>--%>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box">

                <div class="box-header">
                    <h2 class="box-title">
                        年票办理
                    </h2>
                    <c:if test="${not empty message }">
                        <span class="label ${message == '保存成功' ? 'label-success' : 'label-danger'}">${message}</span>
                    </c:if>
                </div>

                <div class="box-body">
                    <%--提交表单--%>
                    <form id ="saveForm" method="post" enctype="multipart/form-data">

                        <input type="text" name="identityUp" id="identityUp">
                        <input type="text" name="identityDown" id="identityDown">
                        <input type="text" name="customerPhoto" id="customerPhoto">

                        <div class="form-group">
                            <label>年票号码</label>
                            <input type="text" name="ticketNum" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>价格</label>
                            <input type="text" name="ticketPrice" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" name="customerName" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>身份证号码</label>
                            <input type="text" name="identityNum" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>住址</label>
                            <input type="text" name="customerAddress" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>联系电话</label>
                            <input type="text" name="customerMobile" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>性别</label>&nbsp&nbsp&nbsp
                            <input type="checkbox" name="customerSex" value="男"  checked id="male">男&nbsp&nbsp&nbsp
                            <input type="checkbox" name="customerSex" value="女" id="famle">女
                        </div>



                        <div class="row">
                            <div class="col-md-4">
                                <h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp身份证正面</h3>
                            </div>
                            <div class="col-md-4">
                                <h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp身份证反面</h3>
                            </div>
                            <div class="col-md-4">
                                 <h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2寸照片</h3>
                             </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div id="photo1"class="photo">

                                </div>

                                <div class="col-md-2">



                                </div>
                            </div>

                            <div class="col-md-4">
                                <div id="photo2" class="photo">

                                </div>

                            </div>

                            <div class="col-md-4">
                                <div id="photo3" class="photo">

                                </div>

                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div id="uploader1" class="wu-example">
                                    <!--用来存放文件信息-->
                                    <div id="thelist1" class="uploader-list pull-right"></div>
                                    <div class="btns pull-right" style="padding-right: 70px; padding-top: 10px">
                                        <div id="picker1"class="pull-right">选择文件</div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div id="uploader2" class="wu-example">
                                    <!--用来存放文件信息-->
                                    <div id="thelist2" class="uploader-list pull-right"></div>
                                    <div class="btns pull-right" style="padding-right: 70px; padding-top: 10px">
                                        <div id="picker2"class="pull-right">选择文件</div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div id="uploader3" class="wu-example">
                                    <!--用来存放文件信息-->
                                    <div id="thelist3" class="uploader-list pull-right"></div>
                                    <div class="btns pull-right" style="padding-right: 70px; padding-top: 10px">
                                        <div id="picker3"class="pull-right">选择文件</div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </form>

                </div>

                <div class="box-footer">
                    <button class="btn btn-primary pull-right" id="saveBtn">保存</button>
                </div>



            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/uploader/webuploader.js"></script>
<script src="/static/plugins/layer/layer.js"></script>

<script>
    $(function () {

        var upload1 = WebUploader.create({
            auto:true,

            // 文件接收服务端。
            server: '/sale/ticket/upload',
            fileVal:'file',

            // 选择文件的按钮。可选。
            pick: '#picker1',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false,
            thumb:{
                width: 250,
                height: 175,

                // 图片质量，只有type为`image/jpeg`的时候才有效。
                quality: 100,

                // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
                allowMagnify: true,

                // 是否允许裁剪。
                crop: true,

                // 为空的话则保留原有图片格式。
                // 否则强制转换成指定的类型。
                type: 'image/jpeg'
            }


        });

        upload1.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });

        upload1.on( 'uploadSuccess', function( file,data ) {
            if (data.status == 'success') {
                var $li = $("#photo1");
                $li.html("");
                $("#identityUp").val(data.data);


                upload1.makeThumb(file, function (error, ret) {
                    if (error) {
                        $li.text('预览错误');
                    } else {
                        var $img = $("<img>").attr("src", ret).attr("style","margin-top:10px");
                        $li.append($img);
                    }
                });
            }
        });

        upload1.on( 'uploadError', function( file ) {
            layer.msg("系统异常");
        });

        upload1.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });

        /*----------------2-------------------------------*/
        var upload2 = WebUploader.create({
            auto:true,

            // 文件接收服务端。
            server: '/sale/ticket/upload',
            fileVal:'file',

            // 选择文件的按钮。可选。
            pick: '#picker2',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false,
            thumb:{
                width: 250,
                height: 175,

                // 图片质量，只有type为`image/jpeg`的时候才有效。
                quality: 100,

                // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
                allowMagnify: true,

                // 是否允许裁剪。
                crop: true,

                // 为空的话则保留原有图片格式。
                // 否则强制转换成指定的类型。
                type: 'image/jpeg'
            }


        });

        upload2.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });

        upload2.on( 'uploadSuccess', function( file,data ) {
            if (data.status == 'success') {

                var $li = $("#photo2");

                $("#identityDown").val(data.data);

                upload2.makeThumb(file, function (error, ret) {

                    if (error) {
                        $li.text('预览错误');
                    } else {
                        $li.html("");
                        var $img = $("<img>").attr("src", ret).attr("style","margin-top:10px");
                        $li.append($img);
                    }
                });
            }
        });

        upload2.on( 'uploadError', function( file ) {
            layer.msg("系统异常");
        });

        upload2.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });
            /*--------------------------3--------------------------------*/
        var upload3 = WebUploader.create({
            auto:true,

            // 文件接收服务端。
            server: '/sale/ticket/upload',
            fileVal:'file',

            // 选择文件的按钮。可选。
            pick: '#picker3',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false,
            thumb:{
                width: 150,
                height: 185,

                // 图片质量，只有type为`image/jpeg`的时候才有效。
                quality: 100,

                // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
                allowMagnify: true,

                // 是否允许裁剪。
                crop: true,

                // 为空的话则保留原有图片格式。
                // 否则强制转换成指定的类型。
                type: 'image/jpeg'
            }


        });

        upload3.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });

        upload3.on( 'uploadSuccess', function( file,data ) {
            if (data.status == 'success') {

                var $li = $("#photo3");

                $("#customerPhoto").val(data.data);

                upload3.makeThumb(file, function (error, ret) {
                    var $li = $("#photo3");
                    if (error) {
                        $li.text('预览错误');
                    } else {
                        $li.html("");
                        var $img = $("<img>").attr("src", ret).attr("style","margin-top:3px");
                        $li.append($img);
                    }
                });
            }
        });

        upload3.on( 'uploadError', function( file ) {
            layer.msg("系统异常");
        });

        upload3.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });
            /*------------------------表单的提交------------------------------------------*/
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });

        /*------------------------------checkbox的单选---------------------------------*/
        $("#male").click(function () {
            $(this).prop("checked","true");

            if($("#famle").is(":checked")){
                $("#famle").removeAttr("checked");
            }

        });


        $("#famle").click(function () {
            $(this).prop("checked","true");
            if($("#male").is(":checked")){
                $("#male").removeAttr("checked");
            }
        });

    })

</script>

</body>
</html>