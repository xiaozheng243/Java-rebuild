<%@ page import="online.suiyu.domain.User" %><%--
Created by IntelliJ IDEA.
User: suiyu
Date: 2018/4/9
Time: 19:52
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Main Header -->
<header class="main-header">

    <!-- AdminLTE Logo -->
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini">
          Admin</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">
          后台管理系统 </span>
    </a>

    <!-- 头bar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- 展开/折叠 -->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar 右侧 -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <%
                    User user = (User) request.getSession().getAttribute("user");
                %>
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- The user image in the navbar-->
                        <img src="${pageContext.request.contextPath}/dist/img/<%=user.getPhoto()%>" class="user-image"
                             alt="User Image">
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class="hidden-xs">suiyu</span>
                    </a>

                    <ul class="dropdown-menu">
                        <!-- The user image in the menu -->
                        <li class="user-header">
                            <img src="${pageContext.request.contextPath}/dist/img/<%=user.getPhoto()%>"
                                 class="img-circle"
                                 alt="User Image">
                            <p>
                                <%=user.getUsername()%> - Java Web开发人员
                                <small>创建于<%=user.getRegtime()%>
                                </small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <%--<li class="user-body">--%>
                        <%--<div class="row">--%>
                        <%--<div class="col-xs-4 text-center">--%>
                        <%--<a href="#">Followers</a>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-4 text-center">--%>
                        <%--<a href="#">Sales</a>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-4 text-center">--%>
                        <%--<a href="#">Friends</a>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<!-- /.row -->--%>
                        <%--</li>--%>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="${pageContext.request.contextPath}/admin/user/profile"
                                   class="btn btn-default btn-flat">资料</a>
                            </div>
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/logout"
                                   class="btn btn-default btn-flat">登出</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <%--<li>--%>
                <%--<a href="#" data-toggle="control-sidebar">--%>
                <%--<i class="fa fa-gears"></i>--%>
                <%--</a>--%>
                <%--</li>--%>
            </ul>
        </div>
    </nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- 左侧用户信息栏 -->
        <div class="user-panel">

            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/dist/img/<%=user.getPhoto()%>" class="img-circle"
                     alt="User Image">
            </div>
            <div class="pull-left info">
                <a href="${pageContext.request.contextPath}/index"><p>suiyu</p></a>
                <!-- Status -->
                <i class="fa fa-circle text-success"></i> Online
            </div>

        </div>

        <!-- 搜索框 (Optional) -->
        <%--<form action="#" method="get" class="sidebar-form">--%>
            <%--<div class="input-group">--%>
                <%--<input type="text" name="q" class="form-control" placeholder="搜索">--%>
                <%--<span class="input-group-btn">--%>
              <%--<button type="submit" name="search" id="search-btn" class="btn btn-flat">--%>
                <%--<i class="fa fa-search"></i>--%>
              <%--</button>--%>
            <%--</span>--%>
            <%--</div>--%>
        <%--</form>--%>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">操作栏</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i>
                    <span>文章</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/post/publish"><i
                                class="fa fa-file-word-o"></i> 已发布文章</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/post/draft"><i class="fa fa-inbox"></i>
                            草稿箱</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/post/dustbin"><i class="fa fa-dropbox"></i>
                            回收站</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/post/edit"> <i class="fa fa-edit"></i> 写文章</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/post/classify"><i class="fa fa-flag"></i> 分类目录</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/post/comments"><i class="fa fa-commenting-o"></i> 评论管理</a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user-o"></i>
                    <span>用户</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/user/profile"> <i class="fa fa-id-card-o"></i>
                            用户信息</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/user/upload"> <i class="fa fa-photo"></i>
                            更换头像</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/user/todo-list"> <i
                                class="fa fa-dot-circle-o"></i> 小目标</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>