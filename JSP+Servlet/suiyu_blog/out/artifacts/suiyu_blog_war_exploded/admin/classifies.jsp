<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="online.suiyu.domain.Classify" %>
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
    <title>分类</title>
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
                文章分类
                <%
                    ArrayList<Classify> list = (ArrayList<Classify>) request.getAttribute("classifies");
                %>
                <small>共有<%=list.size()%>条文章分类！温馨提示：修改分类后，文章原分类会发生改变！<font
                        style="color: red;">如果分类下存在文章，则该分类不可删除，可以尝试修改分类！</font></small>
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
                        <div class="box box-primary">
                            <div class="box-header">
                                <h3 class="box-title">分类列表</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="input-group" style="height: 42px; margin-bottom: -1px;">
                                <input type="text" class="form-control"
                                       style="height: 42px;" placeholder="添加新的分类" id="save">
                                <span class="input-group-addon"><button style="width: 90%;height: 100%;"
                                                                        class="btn btn-success" title="添加"
                                                                        onclick="change('ave',3)"><i
                                        class="fa fa-edit"></i></button></span>
                            </div>
                            <div class="box-body">
                                <%
                                    for (Classify classify : list) {
                                %>
                                <div class="input-group" style="height: 42px; margin-bottom: -1px;">
                                    <input type="text" id="s<%=classify.getcId()%>" class="form-control"
                                           value="<%=classify.getcName()%>"
                                           style="height: 42px;">
                                    <span class="input-group-addon"><button style="width: 100%;height: 100%;"
                                                                            class="btn btn-info" title="修改"
                                                                            onclick="change(<%=classify.getcId()%>,1)"><i
                                            class="fa fa-edit"></i></button></span>
                                    <span class="input-group-addon"><button class="btn btn-danger"
                                                                            title="删除"
                                                                            onclick="change(<%=classify.getcId()%>,2)"><i
                                            class="fa fa-remove"></i></button></span>
                                </div>
                                <%}%>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>
                    <!-- /.col -->
                </div>
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
    function change(id, manage) {
        // console.log('发送ajax');
        var url = '${pageContext.request.contextPath}/post/admin/manage-classify';
        var sobj = '#s' + id;
        var cname = $(sobj).val();
        var params = {'cid': id, 'cname': cname, 'manage': manage};
        // console.log(cname);
        $.post(url, params, function (res) {
            if (res == 1) {
                $.message("操作成功,即将更新资源！");
                setInterval(function () {
                    $(location).attr('href', '${pageContext.request.contextPath}/admin/post/classify');
                }, 2000);
            } else if (res == 0) {
                $.message({
                    message: '存在文章处于当前分类中，不可删除！',
                    type: 'error'
                });
            }
        })
    }
</script>
</body>

< /html>