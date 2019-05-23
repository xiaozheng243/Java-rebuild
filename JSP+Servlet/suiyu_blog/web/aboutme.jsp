<%@ page import="online.suiyu.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>关于我</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/css/demo.css"/>

    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/css/component.css"/>

</head>
<body>
<div class="container demo-2">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <h1 class="main-title">
                <%User user = (User) request.getAttribute("user");%>
                <%=user.getUsername()%>
                <br>
                <%=user.getDisc()%>
                <br>
                <a href="<%=user.getGithub()%>" target="_blank">Github</a>
                <a href="mailto:<%=user.getEmail()%>">Email</a>
            </h1>
        </div>
    </div>
</div><!-- /container -->
<script src="${pageContext.request.contextPath}/styles/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/demo-2.js"></script>
</body>
</html>