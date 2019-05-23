<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
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
    <title>回收站</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/skin-purple.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/skin-purple-light.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>

<body class="hold-transition skin-purple-light fixed">
<div class="wrapper">

    <%@include file="admin-header.jsp" %>
    <!-- 主要信息展示-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <h1>
                回收站
                <%
                    ArrayList<PostDemo> list = (ArrayList<PostDemo>) request.getAttribute("recycleArticles");
                %>
                <small>
                    此处的删除将使文章被不可恢复的永久删除，请谨慎操作！
                </small>
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
                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">文章列表</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>标题</th>
                                        <th>创建时间</th>
                                        <th>分类</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%

                                        for (PostDemo postDemo : list) {
                                    %>
                                    <tr>
                                        <td><%=postDemo.getTitle()%>
                                        </td>
                                        <td><%=postDemo.getCreation()%>
                                        </td>
                                        <td><%=postDemo.getClassify()%>
                                        </td>
                                        <td>
                                            <div class="btn-group" id="caozuo" role="group" aria-label="..."
                                                 value="<%=postDemo.getAid()%>">
                                                <button type="button" class="btn btn-info" id="editpost"
                                                        onclick="change(<%=postDemo.getAid()%>,1)"
                                                >编辑
                                                </button>
                                                <button type="button" class="btn btn-warning" id="previewpost"
                                                        onclick="preview(<%=postDemo.getAid()%>)"
                                                >预览
                                                </button>
                                                <button type="button" class="btn btn-success"
                                                        id="publishpost"
                                                        onclick="change(<%=postDemo.getAid()%>,2)"
                                                >发布
                                                </button>
                                                <button type="button" class="btn btn-danger" id="removepost"
                                                        onclick="change(<%=postDemo.getAid()%>,5)"
                                                >删除
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
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
<script src="${pageContext.request.contextPath}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/bower_components/fastclick/lib/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
<script>
    function preview(id) {
        $(location).attr('href', '${pageContext.request.contextPath}/post?id=' + id);
    }
    function change(aid, manage) {
        // console.log('发送ajax');
        var url = '${pageContext.request.contextPath}/post/admin/managepost';
        var params = {'aid': aid, 'manage': manage};
        $.post(url, params, function (res) {
            if (res == 1) {
                <%--$(location).attr('href', '${pageContext.request.contextPath}/admin/post/draft');--%>
                $.message("操作成功,即将更新资源！");
                setInterval(function () {
                    $(location).attr('href', '${pageContext.request.contextPath}/admin/post/dustbin');
                }, 2000);
            } else if (res == 0) {
                $.message({
                    message: '额，出了点小故障，操作失败，请重试！',
                    type: 'error'
                });
            } else if (res == 2) {
                $(location).attr('href', '${pageContext.request.contextPath}/post/admin/modify-post?aid=' + aid);
            }
        })
    }
</script>
<script>
    $(function () {
        $('#example1').DataTable()
        $('#example2').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': true,
            'ordering': true,
            'info': false,
            'autoWidth': true
        })
    })
</script>
</body>

</html>