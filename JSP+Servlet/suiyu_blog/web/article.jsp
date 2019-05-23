<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="online.suiyu.domain.Comment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%
        PostDemo postDemo = (PostDemo) request.getAttribute("onepost");
        List<Comment> commentList = (List<Comment>) request.getAttribute("commentList");
    %>
    <title><%=postDemo.getTitle()%>
    </title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/article.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
</head>

<body>

<header>
    <!-- 首页导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <div class="col-md-4"></div>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index">Suiyu</a>
                <!-- <p class="navbar-text">Signed in as Mark Otto</p> -->
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${pageContext.request.contextPath}/index">Home</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/categorys">Categorys</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/time-line">Archives</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/about-me">About Me</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="title">
        <h1><%=postDemo.getTitle()%>
        </h1>
        <h4>时间：<a href="${pageContext.request.contextPath}/time-line"><%=postDemo.getCreation()%>
        </a>
        </h4>
        <h4>分类：<a href="${pageContext.request.contextPath}/categorys"><%=postDemo.getClassify()%>
        </a>
        </h4>
    </div>
</header>

<div class="container">

    <div class="article">
        <%=postDemo.getDetails()%>

    </div>
    <!-- <div class="sider-right right">
            <div class="author-img">
                <img src="http://upload-images.jianshu.io/upload_images/3457879-8e23e0ff609d84fe.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="">
            </div>
            <div class="author-name">Suiyu</div>
            <div class="author-name">博观而约取，厚积而薄发。</div>
        </div> -->
</div>


<div class="comments">
    <h2>Comments</h2>
    <%
        if (commentList.isEmpty()) {

    %>
    智慧如你，快来评论吧！
    <%
    } else {
        for (Comment comment : commentList) {
    %>
    <div class="comment clearfix">
        <img src="./styles/img/placeholder.jpg" alt="头像" class="img left">
        <div class="comment-detail">
            <h4><%=comment.getCommentUser()%>
                <small><%=comment.getCreation()%>
                </small>
            </h4>
            <p><%=comment.getCdetails()%>
            </p>
        </div>
    </div>
    <%}%>
    <%}%>
    <h2>说点什么吧</h2>
    <div class="comment-write">
        <input type="text" name="username" id="username" placeholder="用户名">
        <br>
        <%--<input type="email" name="email" id="email" placeholder="邮箱">--%>
        <%--<br>--%>
        <br>
        <textarea name="comment" id="comment-words" rows="10" class="cdetail" placeholder="写下想说的话吧(〃'▽'〃)"></textarea>
        <br>
        <button type="submit" id="submit-btn">提交</button>
    </div>
</div>
<script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script>
    $(function () {
        $("#username").blur(function () {
            console.log("blur");
            if ($(this).val().trim() == "")
                $.message({
                    message: '用户名不可为空！',
                    type: 'warning'
                });
        });
        $("#comment-words").blur(function () {
            if ($(this).val().trim() == "")
                $.message({
                    message: '评论内容不可为空！',
                    type: 'warning'
                });
        });
        $("#submit-btn").click(function () {
            if ($("#username").val().trim() == "" || $("#comment-words").val().trim() == "") {
                $.message({
                    message: '用户名或评论不可为空！',
                    type: 'warning'
                });
            } else {
                var url = "${pageContext.request.contextPath}/add-comment";
                var username = $('#username').val();
                var comment = $('#comment-words').val();
                var aid =<%=postDemo.getAid()%>;
                var params = {"username": username, "comment": comment, 'aid': aid};
                $.post(url, params, function (res) {
                    if (res == 1) {
                        $.message('评论成功！' + username + "，谢谢留下宝贵的意见！");
                        setInterval(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $.message({
                            message: '评论出错，请稍后再试！',
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