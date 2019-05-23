<%--
  Created by IntelliJ IDEA.
  User: suiyu
  Date: 2018/4/9
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>欢迎登录</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
    <style>
        .form-group {
            margin: 0;
        }

        .login {
            width: 20%;
            margin: 200px auto;
        }

        .btn-success {
            width: 100%;
        }

        body {
            <%--background-image: url("${pageContext.request.contextPath}/dist/img/ravenna.png");--%>
            background: linear-gradient(to right, #89fffd, #ef32d9);
        }
    </style>
</head>

<body>
<div class="login">
    <h3>欢迎登录</h3>
    <br>
    <form>
        <div class="form-group">

            <input type="text" class="form-control" id="username" name="username" placeholder="用户名" autofocus>
            <label for="username"></label>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
            <label for="password"></label>
        </div>
        <%--<div class="checkbox">--%>
            <%--<label>--%>
                <%--<input type="checkbox" id="checkbox"> 7天免登陆--%>
            <%--</label>--%>
        <%--</div>--%>
        <button type="button" class="btn btn-success">登录</button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script>
    $(function () {
        $("#username").blur(function () {
            if ($(this).val() == "")
                $.message({
                    message: '用户名不可为空！',
                    type: 'warning'
                });
        });
        $("#password").blur(function () {
            if ($(this).val() == "")
                $.message({
                    message: '密码不可为空！',
                    type: 'warning'
                });
        });
        $(".btn-success").click(function () {
            if ($(".form-control").val() == "") {
                $.message({
                    message: '用户名或密码不可为空！',
                    type: 'warning'
                });
            } else {
                var url = "${pageContext.request.contextPath}/login";
                var username = $('#username').val();
                var password = $('#password').val();
                var checkbox = $('#checkbox').val();
                var params = {"username": username, "password": password, "checkbox": checkbox};
                // console.log(params);
                $.post(url, params, function (res) {
                    // console.log(res);
                    if (res == 1) {
                        $.message('登录成功！' + username + "，欢迎回来！");
                        console.log("登录成功！");
                        setInterval(function () {
                            $(location).attr('href', '${pageContext.request.contextPath}/admin/dashboard');
                        }, 2000);
                    } else {
                        $.message({
                            message: '用户名或密码出错！',
                            type: 'error'
                        });
                    }
                })
            }
        });
    })
</script>
</body>

</html>