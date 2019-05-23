<%@ page import="online.suiyu.domain.Classify" %>
<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>分类</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
</head>
<body>
<%@include file="font-header.jsp" %>

<div class="container clearfix">

    <div class="article-list">
        <%
            Map<Classify, List<PostDemo>> map = (Map<Classify, List<PostDemo>>) request.getAttribute("category");
            Set<Map.Entry<Classify, List<PostDemo>>> set = map.entrySet();
            for (Iterator<Map.Entry<Classify, List<PostDemo>>> iterator = set.iterator(); iterator.hasNext(); ) {
                Map.Entry<Classify, List<PostDemo>> entry = iterator.next();
        %>
        <div class="article">
            <div class="header">
                <%=entry.getKey().getcName()%>
            </div>
            <div class="content">
                <%
                    List<PostDemo> list = entry.getValue();
                    for (Iterator<PostDemo> iterator1 = list.iterator(); iterator1.hasNext(); ) {
                        PostDemo postDemo = iterator1.next();
                %>
                <a href="${pageContext.request.contextPath}/post?id=<%=postDemo.getAid()%>"><%=postDemo.getTitle()%>
                </a>
                <br>
                <%}%>
            </div>
        </div>
        <% }%>
    </div>

</div>


<script src="./bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="styles/js/hotkeys.min.js"></script>
<script>
    hotkeys('ctrl+b', function () {
        $(location).attr('href', '${pageContext.request.contextPath}/admin/login.jsp');
    });
</script>
</body>

</html>