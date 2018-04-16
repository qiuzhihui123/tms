<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS-综合管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/dist/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/aero.css">
    <link rel="stylesheet" href="/static/dist/css/skins/_all-skins.min.css">

    <%--<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->--%>

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
<body class=" hold-transition  login-page " style="background:#fffdfb;">
<div class="login-box" style="background:#e4ff9f;">
    <div class="login-logo">
        <a href="javascript:;"><b>TMS</b>综合管理系统</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body" style="background:#e4ff9f">
        <c:if test="${not empty message}">
            <p class="login-box-msg text-danger">${message}</p>
        </c:if>
        <form method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="accountMobile" placeholder="电话号码" autofocus value="${not empty account ? account : ''}${not empty account ? '': mobile}">
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" placeholder="密码">
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck" style="color: #2e1d24">
                        <label>
                            <input type="checkbox" name="remember" value="remember" ${not empty account ? 'checked' : ''}>  &nbsp记住帐号
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录系统</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="#">忘记密码</a><br>
    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="/static/plugins/jquery/jquery3.2.1.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-aero',
            radioClass: 'iradio_square-aero',
            increaseArea: '25%' /* optional */
        });
    });
</script>
</body>
</html>