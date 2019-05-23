<%@ page import="online.suiyu.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <%--<%User user = (User) request.getAttribute("user");%>--%>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index">Suiyu
                </a>
                <!-- <p class="navbar-text">Signed in as Mark Otto</p> -->
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/search" method="get">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索" name="search" id="search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${pageContext.request.contextPath}/index">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/categorys">分类</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/time-line">归档</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/about-me">关于我</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="title">
        <h2>Suiyu</h2>
        <%
            String url = new String(request.getRequestURL());
            if (url.contains("timeline.jsp")) {
        %>
        <h3>Timeline</h3>
        <%} else if (url.contains("categorys.jsp")) {%>
        <h3>Categorys</h3>
        <%} else if (url.contains(("search-result.jsp"))) {%>
        <h3>搜索结果</h3>
        <%} else {%>
        <h3>Knowledge makes humble, ignorance makes proud!</h3>
        <%}%>
    </div>
</header>

<%--<script>--%>
<%--$(function () {--%>
<%--$(".form-control").blur(function () {--%>
<%--if ($(this).val() == "")--%>
<%--$.message({--%>
<%--message: '搜索内容不可为空！',--%>
<%--type: 'warning'--%>
<%--});--%>
<%--});--%>
<%--$(".btn-default").click(function () {--%>
<%--if ($(".form-control").val() == "") {--%>
<%--$.message({--%>
<%--message: '搜索内容不可为空！',--%>
<%--type: 'warning'--%>
<%--});--%>
<%--return false;--%>
<%--} else {--%>
<%--var search = $(".form-control").val();--%>
<%--&lt;%&ndash;var url = "${pageContext.request.contextPath}/search?search="+search;&ndash;%&gt;--%>
<%--// var params = {"search": search};--%>
<%--$(location).attr('href', '${pageContext.request.contextPath}/search?search=' + search);--%>
<%--&lt;%&ndash;$.get(url, params, function (res) {&ndash;%&gt;--%>
<%--&lt;%&ndash;if (res == 0) {&ndash;%&gt;--%>
<%--&lt;%&ndash;$.message({&ndash;%&gt;--%>
<%--&lt;%&ndash;message: '抱歉，没有您想要的东西！',&ndash;%&gt;--%>
<%--&lt;%&ndash;type: 'error'&ndash;%&gt;--%>
<%--&lt;%&ndash;});&ndash;%&gt;--%>
<%--&lt;%&ndash;setInterval(function () {&ndash;%&gt;--%>
<%--&lt;%&ndash;console.log("查找失败");&ndash;%&gt;--%>
<%--&lt;%&ndash;}, 2000);&ndash;%&gt;--%>
<%--&lt;%&ndash;return false;&ndash;%&gt;--%>
<%--&lt;%&ndash;} else if (res == 1) {&ndash;%&gt;--%>
<%--&lt;%&ndash;console.log("搜索到了");&ndash;%&gt;--%>
<%--&lt;%&ndash;$(location).attr('href', '${pageContext.request.contextPath}/search-result');&ndash;%&gt;--%>
<%--&lt;%&ndash;// $.message('登录成功！' + username + "，欢迎回来！");&ndash;%&gt;--%>
<%--&lt;%&ndash;// console.log("登录成功！");&ndash;%&gt;--%>
<%--&lt;%&ndash;// setInterval(function () {&ndash;%&gt;--%>
<%--&lt;%&ndash;//&ndash;%&gt;--%>
<%--&lt;%&ndash;// }, 2000);&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;})&ndash;%&gt;--%>
<%--}--%>
<%--})--%>
<%--})--%>
<%--</script>--%>