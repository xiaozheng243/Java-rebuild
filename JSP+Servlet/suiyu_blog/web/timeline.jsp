<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javafx.geometry.Pos" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>归档</title>

    <link href="${pageContext.request.contextPath}/styles/css/timeline.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/styles/js/modernizr.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
</head>
<body>
<%@include file="font-header.jsp" %>
<%--<header>--%>
    <%--<h1>时光旅行</h1>--%>
<%--</header>--%>

<section id="cd-timeline" class="cd-container">
    <%
        int i = 0;
        ArrayList<PostDemo> publish = (ArrayList<PostDemo>) request.getAttribute("publishArticles");
        for (PostDemo postDemo : publish) {
    %>
    <div class="cd-timeline-block">
        <div class="cd-timeline-img cd-picture">
            <img src="${pageContext.request.contextPath}/styles/img/icon<%=(i++)%3%>.svg" alt="Picture">
        </div><!-- cd-timeline-img -->

        <div class="cd-timeline-content">
            <h2><%=postDemo.getTitle()%>
            </h2>
            <p><%=postDemo.getDetails().split("<hr>")[0]%>
            </p>
            <a href="${pageContext.request.contextPath}/post?id=<%=postDemo.getAid()%>" class="cd-read-more">阅读更多</a>
            <span class="cd-date"><%=postDemo.getCreation()%></span>
        </div> <!-- cd-timeline-content -->
    </div> <!-- cd-timeline-block -->
    <%}%>
</section> <!-- cd-timeline -->

<script>
    $(function () {
        var $timeline_block = $('.cd-timeline-block');
        //hide timeline blocks which are outside the viewport
        $timeline_block.each(function () {
            if ($(this).offset().top > $(window).scrollTop() + $(window).height() * 0.75) {
                $(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
            }
        });
        //on scolling, show/animate timeline blocks when enter the viewport
        $(window).on('scroll', function () {
            $timeline_block.each(function () {
                if ($(this).offset().top <= $(window).scrollTop() + $(window).height() * 0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden')) {
                    $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
                }
            });
        });
    });
</script>

</body>
</html>
