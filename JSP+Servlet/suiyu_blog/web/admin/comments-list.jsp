<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="online.suiyu.domain.Comment" %>
<%@ page import="online.suiyu.domain.CommentDemo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理评论</title>
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

<body class="hold-transition skin-purple-light fixed">
<div class="wrapper">

    <%@include file="admin-header.jsp" %>
    <!-- 主要信息展示-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                管理评论
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
                                <h3 class="box-title">已发布文章评论</h3>
                            </div>
                            <%--<label>文章名称</label>--%>
                            <%--<select class="form-control" id="postdemo" name="astate">--%>
                            <%--<%--%>
                            <%--//                                    ArrayList<>--%>
                            <%--ArrayList<PostDemo> posts = (ArrayList<PostDemo>) request.getAttribute("publishArticles");--%>
                            <%--for (PostDemo post : posts) {--%>
                            <%--%>--%>
                            <%--<option value="<%=post.getAid()%>"><%=post.getTitle()%>--%>
                            <%--</option>--%>
                            <%--<script>--%>

                            <%--</script>--%>
                            <%--<%}%>--%>
                            <%--</select>--%>
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>评论时间</th>
                                    <th>评论内容</th>
                                    <th>文章</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    ArrayList<CommentDemo> comments = (ArrayList<CommentDemo>) request.getAttribute("comments");
                                    for (CommentDemo comment : comments) {
                                %>
                                <tr>
                                    <td><%=comment.getCommentUser()%>
                                    </td>
                                    <td><%=comment.getCreation()%>
                                    </td>
                                    <td><%=comment.getCdetails()%>
                                    </td>
                                    <td><%=comment.getTitle()%>
                                    </td>
                                    <td>
                                        <div class="btn-group" role="group" aria-label="...">
                                            <button type="button" class="btn btn-danger"
                                                    onclick="change(<%=comment.getCid()%>,3)">删除
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

                    <!-- /.box-body -->
                </div>
            </section>
        </section>
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page="admin-footer.jsp"></jsp:include>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->

<!-- Bootstrap 3.3.7 -->
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
    function change(aid, manage) {
        var url = '${pageContext.request.contextPath}/admin/post/comment-manage';
        var params = {'aid': aid, 'manage': manage};
        $.post(url, params, function (res) {
            if (res == 1) {
                $.message("删除成功,即将更新资源！");
                setInterval(function () {
                    $(location).attr('href', '${pageContext.request.contextPath}/admin/post/comments');
                }, 2000);
            } else if (res == 0) {
                $.message({
                    message: '额，出了点小故障，操作失败，请重试！',
                    type: 'error'
                });
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