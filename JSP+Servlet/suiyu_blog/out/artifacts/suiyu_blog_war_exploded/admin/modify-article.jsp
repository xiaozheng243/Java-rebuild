<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="online.suiyu.domain.Astate" %>
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
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改文章</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/simditor.css">
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

<body class="hold-transition skin-purple-light fixed">
<div class="wrapper">

    <%@include file="admin-header.jsp" %>
    <!-- 主要信息展示-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <h1>
                修改文章
                <small>
                    快快给你的文章打补丁吧！
                </small>
            </h1>
        </section>

        <!-- 自定义主要信息存放 -->
        <section class="content container-fluid">

            <!--------------------------
            | Your Page Content Here |
            -------------------------->
            <%
                ArrayList<Astate> astates = (ArrayList<Astate>) request.getAttribute("state");
                ArrayList<Classify> classify = (ArrayList<Classify>) request.getAttribute("classify");
                PostDemo postDemo = (PostDemo) request.getAttribute("modifypost");
            %>
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">

                        <div class="box box-primary">
                            <div class="box-header">
                                <i class="ion ion-clipboard"></i>
                                <h3 class="box-title">写文章</h3>
                            </div>
                            <div class="box-body">

                                <input type="text" class="form-control" id="posttitle" autofocus placeholder="请输入标题"
                                       value="<%=postDemo.getTitle()%>">
                                <br>

                                <%String postDetails=postDemo.getDetails();

                                %>
                                <%--editor.setValue('');--%>
                                <textarea id="editor" name="post"><%=postDetails%></textarea>
                                <div class="form-group">
                                    <label>分类</label>
                                    <select class="form-control" id="astate" name="astate" style="width: 100px;">
                                        <%
                                            for (Astate astate : astates) {
                                        %>
                                        <option value="<%=astate.getStateId()%>">
                                        <%=astate.getAstate()%>
                                        </option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>状态</label>
                                    <select class="form-control" id="classify" name="classify" style="width: 100px;">
                                        <%
                                            for (Classify classify1 : classify) {
                                        %>
                                        <option value="<%=classify1.getcId()%>"
                                                <%
                                                    if (classify1.getcName().equals(postDemo.getClassify())) {
                                                %>
                                                selected
                                                <%}%>
                                        ><%=classify1.getcName()%>
                                        </option>
                                        <%}%>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-success">保存</button>
                            </div>
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
<script src="${pageContext.request.contextPath}/styles/js/module.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/hotkeys.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/uploader.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/simditor.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script>
    var toolbar = [
        'title',
        'bold',
        'italic',
        'underline',
        'strikethrough',
        'fontScale',
        'color',
        'ol',
        'ul',
        'blockquote',
        'code',
        'table',
        'link',
        'image',
        'hr',
        'indent',
        'outdent',
        'alignment'
    ];
    var editor = new Simditor({
        textarea: $('#editor'),
        toolbar: toolbar,
        pasteImage: true,
        toolbarFloat: true,
        toolbarFloatOffset: 0,
        defaultImage: '${pageContext.request.contextPath}/styles/img/image.png'
    });

</script>
<script>
    $(function () {
        $(".btn-success").click(function () {
            if ($("#editor").val() == "" || $("#posttitle").val == "") {
                // console.log("文章不可为空！");
                $.message({
                    message: '文章或标题内容不可为空！',
                    type: 'warning'
                });
            } else {
                var url = "${pageContext.request.contextPath}/admin/post/update-post";
                var posttitle = $('#posttitle').val();
                // var post = $('#editor').val();
                var id =<%=postDemo.getAid()%>;
                var post = editor.getValue();
                var astate = $('#astate').val();
                var classify = $('#classify').val();
                var params = {
                    "postid": id,
                    "posttitle": posttitle,
                    "post": post,
                    "astate": astate,
                    "classify": classify
                };
                $.post(url, params, function (res) {
                    // console.log(res);
                    if (res == 1) {
                        <%--$(location).attr('href', '${pageContext.request.contextPath}/admin/post/publish');--%>
                        $.message("修改成功，文章更加严谨喽！");
                        setInterval(function () {
                            $(location).attr('href', '${pageContext.request.contextPath}/admin/post/publish');
                        }, 2000);
                    } else {
                        $.message({
                            message: '额，出了点小失误，请保证网络畅通！',
                            type: 'error'
                        });
                    }
                })
            }
        });
    })
</script>
</body>

< /html>