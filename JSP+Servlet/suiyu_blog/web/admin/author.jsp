<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="online.suiyu.domain.Classify" %>
<%@ page import="online.suiyu.domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: suiyu
Date: 2018/4/9
Time: 19:52
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!--<!DOCTYPE html>-->--%>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户信息管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/skin-purple.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/skin-purple-light.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->

<body class="hold-transition skin-purple-light fixed">
<div class="wrapper">

    <%--<jsp:include page="admin-header.jsp"></jsp:include>--%>
    <%@include file="admin-header.jsp" %>
    <!-- 主要信息展示-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <h1>
                个人信息管理
                <small>修改用户信息后需要重新登录</small>
            </h1>
        </section>

        <!-- 自定义主要信息存放 -->
        <section class="content container-fluid">

            <!--------------------------
            | Your Page Content Here |
            -------------------------->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- /.box-header -->
                        <div class="box box-primary">
                            <div class="box-header">
                                <h3 class="box-title">个人信息表</h3>
                            </div>
                            <%
                                User user1 = (User) request.getAttribute("userprofile");
                            %>
                            <!-- /.box-header -->
                            <!-- form start -->
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="username">用户名</label>
                                    <input type="text" class="form-control" id="username"
                                           placeholder="请输入用户名" name="username" value="<%=user1.getUsername()%>">
                                </div>
                                <div class="form-group">
                                    <label for="email">邮箱</label>
                                    <input type="email" class="form-control" id="email"
                                           placeholder="请输入邮箱" name="email" value="<%=user1.getEmail()%>">
                                </div>
                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input type="password" class="form-control" id="password"
                                           placeholder="请输入密码" name="password" value="<%=user1.getUpassword()%>">
                                </div>
                                <div class="form-group">
                                    <label for="sign">个性签名</label>
                                    <input type="text" class="form-control" id="sign"
                                           placeholder="请输入个性签名" name="sign" value="<%=user1.getUsign()%>">
                                </div>
                                <%--<div class="form-group">--%>
                                <%--<label for="sign">生日</label>--%>
                                <%--<input type="date" class="form-control" id="birth"--%>
                                <%--placeholder="请输入出生日期" name="birth" value="<%=user.getBirth()%>">--%>
                                <%--</div>--%>
                                <div class="form-group">
                                    <label for="sign">Github</label>
                                    <input type="text" class="form-control" id="github"
                                           placeholder="请输入URL" name="github" value="<%=user1.getGithub()%>">
                                </div>
                                <div class="form-group">
                                    <label for="disc">描述自己</label>
                                    <textarea class="form-control" rows="3" placeholder="描述自己" name="disc"
                                              id="disc"> <%=user1.getDisc()%> </textarea>
                                </div>
                                <%--<div class="form-group">--%>
                                <%--<label for="exampleInputFile">头像上传</label>--%>
                                <%--<input type="file" id="exampleInputFile">--%>
                                <%--<p class="help-block">Example block-level help text here.</p>--%>
                                <%--</div>--%>
                                <button class="btn btn-success">更新信息</button>
                            </div>
                            <!-- /.box-body -->
                        </div>

                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
                <!-- /.row -->
            </section>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="admin-footer.jsp"></jsp:include>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script>
    $(function () {
        $(".btn-success").click(function () {
            var id = <%=user1.getId()%>;
            var username = $("#username").val();
            var email = $("#email").val();
            var password = $("#password").val();
            var sign = $("#sign").val();
            // var birth = $("#birth").val();
            var github = $("#github").val();
            var disc = $("#disc").val();
            // console.log(password);
            var url = "${pageContext.request.contextPath}/admin/user/update";
            var params = {
                "id": id,
                "username": username,
                "email": email,
                "password": password,
                "sign": sign,
                "birth": birth,
                "github": github,
                "disc": disc
            };
            // console.log(id, username, email, password, sign, birth, github, disc);
            $.post(url, params, function (res) {
                if (res == 1) {
                    $.message("信息修改成功！");
                    setInterval(function () {
                        <%--$(location).attr('href', '${pageContext.request.contextPath}/admin/user/profile');
                        --%>
                        $(location).attr('href', '${pageContext.request.contextPath}/user-login');
                    }, 2000);
                } else {
                    $.message({
                        message: '额，出了点小失误，请保证网络畅通再试！',
                        type: 'error'
                    });
                }
            })
        })
    })
</script>
</body>

< /html>