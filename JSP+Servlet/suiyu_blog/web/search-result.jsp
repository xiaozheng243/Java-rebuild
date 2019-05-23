<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Suiyu'blog</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
</head>
<%ArrayList<PostDemo> list = (ArrayList<PostDemo>) request.getAttribute("searchlist");%>
<body>
<%@include file="font-header.jsp" %>


<div class="container clearfix">

    <div class="article-list">
        <%

            if (list.size() > 0) {
                for (PostDemo postDemo : list) {
        %>
        <div class="article">
            <div class="header">
                <a href="${pageContext.request.contextPath}/post?id=<%=postDemo.getAid()%>"><%=postDemo.getTitle()%>
                </a>
            </div>
            <div class="subtitle">
                <div class="sub time">发表于 <a
                        href="${pageContext.request.contextPath}/time-line"><%=postDemo.getCreation()%>
                </a>
                </div>
                <div class="sub classfy">分类：
                    <a href="${pageContext.request.contextPath}/categorys"><%=postDemo.getClassify()%>
                    </a>
                </div>
            </div>
            <div class="content">
                <%=postDemo.getDetails().split("<hr>")[0]%>
            </div>
            <div class="continue">
                <a href="${pageContext.request.contextPath}/post?id=<%=postDemo.getAid()%>">阅读全文</a>
            </div>
        </div>
        <%}%>
        <%} else {%>
        <div class="article">
            抱歉，暂无搜索结果！
        </div>
        <%}%>

    </div>
</div>

<script src="./bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="styles/js/hotkeys.min.js"></script>
<%--<script>--%>
<%--hotkeys('ctrl+b', function () {--%>
<%--$(location).attr('href', '${pageContext.request.contextPath}/user-login');--%>
<%--});--%>
<%--</script>--%>
</body>

</html>