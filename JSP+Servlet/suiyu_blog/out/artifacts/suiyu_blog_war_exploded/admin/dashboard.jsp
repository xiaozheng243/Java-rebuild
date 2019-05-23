<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="online.suiyu.domain.Classify" %>
<%@ page import="java.util.*" %>
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
    <title>控制面板</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/message.css">

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <style>
        .small-box {
            box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.05);
        }

    </style>
</head>


<body class="hold-transition skin-purple-light fixed">
<%
    Map<Classify, List<PostDemo>> map = (Map<Classify, List<PostDemo>>) request.getAttribute("category");
    ArrayList<PostDemo> publish = (ArrayList<PostDemo>) request.getAttribute("publishArticles");
    ArrayList<PostDemo> draft = (ArrayList<PostDemo>) request.getAttribute("draftArticles");
    Set<Map.Entry<Classify, List<PostDemo>>> set = map.entrySet();
%>
<div class="wrapper">

    <%--<jsp:include page="admin-header.jsp"></jsp:include>--%>
    <%@include file="admin-header.jsp" %>
    <!-- 主要信息展示-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                仪表盘
                <small>控制面板</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3><%=publish.size()%>
                            </h3>
                            <p>已发布文章</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-ios-paper-outline"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/admin/post/publish" class="small-box-footer">更多信息 <i
                                class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3><%=draft.size()%>
                            </h3>

                            <p>草稿箱</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-ios-box-outline"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/admin/post/draft" class="small-box-footer">更多信息 <i
                                class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3><%=set.size()%>
                            </h3>
                            <p>分类</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-ios-pie-outline"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/admin/post/classify" class="small-box-footer">更多信息
                            <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3><%int count = (int) request.getAttribute("todo");%><%=count%>
                            </h3>

                            <p>小目标</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-ionic"></i>
                        </div>
                        <a href="${pageContext.request.contextPath}/admin/user/todo-list" class="small-box-footer">更多信息 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
            </div>
            <!-- /.row -->
            <!-- Main row -->
            <div class="row">
                <!-- Left col col-lg-5 -->
                <section class="col-xs-12 connectedSortable">
                    <div class="box box-primary">
                        <div id="echartsdemo0" style="width: 1000px;height:400px;"></div>
                    </div>
                    <script src="${pageContext.request.contextPath}/styles/js/echarts.min.js"></script>
                    <!-- 引入 vintage 主题 -->
                    <script src="${pageContext.request.contextPath}/styles/js/macarons.js"></script>
                    <script>
                        // 第二个参数可以指定前面引入的主题
                        var chart = echarts.init(document.getElementById('echartsdemo0'), 'macarons');
                        var option = {
                            title: {
                                text: '文章分类占比',
                                subtext: '全部文章',
                                x: 'center'
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter: "{a} <br/>{b} : {c} ({d}%)"
                            },
                            legend: {
                                x: 'center',
                                y: 'bottom',
                                data:
                                    [
                                        <%
                                             for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
                                    Map.Entry<Classify, List<PostDemo>> entry = (Map.Entry<Classify, List<PostDemo>>) iterator.next();
                                    Classify classify = entry.getKey();
                                        %>
                                        '<%=classify.getcName()%>',
                                        <%}%>
                                    ]
                            },
                            // ['rose1', 'rose2', 'rose3', 'rose4', 'rose5', 'rose6', 'rose7', 'rose8']
                            toolbox: {
                                show: false,
                                feature: {
                                    mark: {
                                        show: true
                                    },
                                    dataView: {
                                        show: true,
                                        readOnly: false
                                    },
                                    magicType: {
                                        show: true,
                                        type: ['pie', 'funnel']
                                    },
                                    restore: {
                                        show: true
                                    },
                                    saveAsImage: {
                                        show: true
                                    }
                                }
                            },
                            calculable: true,
                            series: {
                                name: '分类占比',
                                type: 'pie',
                                radius: [30, 110],
                                left: ['75%', '50%'],
                                roseType: 'area',
                                data: [
                                    <%
                                            for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
                                   Map.Entry<Classify, List<PostDemo>> entry = (Map.Entry<Classify, List<PostDemo>>) iterator.next();
                                   Classify classify = entry.getKey();
                                       %>
                                    {
                                        value: <%=entry.getValue().size()%>,
                                        name: '<%=classify.getcName()%>'
                                    },
                                    <%}%>

                                ]
                            }
                        };
                        chart.setOption(
                            option
                        );
                    </script>

                </section>
            </div>

        </section>
    </div>

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
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script>
    function change(id, manage) {
        // console.log('发送ajax');
        var url = '${pageContext.request.contextPath}/post/admin/manage-classify';
        var sobj = '#s' + id;
        var cname = $(sobj).val();
        var params = {'cid': id, 'cname': cname, 'manage': manage};
        // console.log(cname);
        $.post(url, params, function (res) {
            if (res == 1) {
                $.message("操作成功,即将更新资源！");
                setInterval(function () {
                    $(location).attr('href', '${pageContext.request.contextPath}/admin/post/classify');
                }, 2000);
            } else if (res == 0) {
                $.message({
                    message: '存在文章处于当前分类中，不可删除！',
                    type: 'error'
                });
            }
        })
    }
</script>
</body>

< /html>