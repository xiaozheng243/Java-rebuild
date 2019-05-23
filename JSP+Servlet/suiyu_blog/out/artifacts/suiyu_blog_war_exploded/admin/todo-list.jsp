<%@ page import="online.suiyu.domain.PostDemo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="online.suiyu.domain.Classify" %>
<%@ page import="online.suiyu.domain.User" %>
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
    <title>小目标</title>
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
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <style>

        .todo li {
            list-style: none;
            width: 100%;
        }

        .todo {
            color: #3c3c3c;
        }

        .todo #item {
            width: 100%;
            padding: 16px 16px 16px 60px;
            border: none;
            font-size: 24px;
            outline: none;
        }

        .todo li {
            padding: 0 15px;
            font-size: 20px;
            white-space: pre-line;
            transition: color 0.4s;
            height: 50px;
            line-height: 48px;
            position: relative;
            /*border: 1px solid #ccc;*/
        }

        .todo .content {
            color: #4d4d4d;
        }

        .todo .finished {
            color: #d9d9d9;
            text-decoration: line-through;
        }

        .todo .check {
            text-align: center;
            width: 15px;
            height: 15px;
            border: none;
            outline: none;
        }

        .todo #delete {
            position: absolute;
            right: 45px;
            top: 15px;
            display: none;
            transition: all 0.5s ease;
        }

        .todo li:hover #delete {
            display: block;
            transition: all 0.5s ease;
        }
    </style>
</head>

<body class="hold-transition skin-purple-light fixed">
<div class="wrapper">

    <%--<jsp:include page="admin-header.jsp"></jsp:include>--%>
    <%@include file="admin-header.jsp" %>
    <!-- 主要信息展示-->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <h1>
                To Do List
                <small>今日事，今日毕！<font style="color: red;">请完成制定的计划，不要拖拉！</font></small>
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
                                <i class="ion ion-clipboard"></i>
                                <h3 class="box-title">To Do List</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
                                <div class="todo">
                                    <input type="text" name="item" id="item" autofocus @keyup.enter="addTodo"
                                           placeholder="接下来要做什么" class="form-control">
                                    <br>
                                    <ul>
                                        <li v-for="todo in todos" :key="todo.id">
                                            <input type="checkbox" class="check" v-model="todo.finished">
                                            <label :class="['content',todo.finished?'finished':'']">{{todo.content}}</label>
                                            <button @click="deleteTodo" id="delete" class="btn btn-danger">删除</button>
                                        </li>
                                        <li>
                                            <button @click="deleteAllFinished" class="btn btn-danger">清除已完成</button>
                                            <button @click="deleteAll" class="btn btn-danger">清除所有</button>
                                        </li>
                                    </ul>
                                    {{getTodos}}
                                </div>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
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
<script src="${pageContext.request.contextPath}/styles/js/message.min.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/vue.js"></script>

<script>
    var id = 3;
    new Vue({
        el: '.todo',
        data: {
            todos: [
                <%
                   String todostr = (String) request.getAttribute("todo");
                   if(todostr!=null&&!todostr.equals("")){
                        String[] todos = todostr.split(";");
                        for (String todo : todos) {
                            String[] todos1 = todo.split(",");
                            String id = todos1[0];
                            String content = todos1[1];
                            String finished = todos1[2];
                %>
                            {
                                id: <%=Integer.parseInt(id)%>,
                                content: '<%=content%>',
                                finished: <%=Boolean.parseBoolean(finished)%>
                            },
                <%}%>
                <%}%>
            ]
        },
        methods: {
            addTodo(e) {
                var content = e.target.value.trim();
                if (content != "") {
                    this.todos.unshift({
                        id: id++,
                        content: e.target.value.trim(),
                        finished: false
                    });
                }
                e.target.value = '';
            },
            deleteTodo(id) {
                this.todos.splice(function (todo) {
                        return todo.id
                    }, 1
                )
            },
            deleteAllFinished() {
                this.todos = this.todos.filter(
                    function (todo) {
                        return !todo.finished
                    }
                );
            },
            deleteAll() {
                this.todos = [];
            }
        },
        computed: {
            getTodos() {
                var todoinfo = '';
                for (var i = 0; i < this.todos.length; i++) {
                    var element = this.todos[i];
                    // console.log(element.id, element.content, element.finished);
                    todoinfo = todoinfo + element.id + "," + element.content + "," + element.finished + ";";
                }
                console.log(todoinfo);
                var url = "${pageContext.request.contextPath}/admin/user/update-todo";
                //发送ajax
                var params = {'todo': todoinfo};
                // console.log(this.todos);
                $.post(url, params, function (res) {
                    if (res == 1) {
                        console.log("成功");
                    } else {
                        $.message({
                            message: '额，出了点小失误，请保证网络畅通再试！',
                            type: 'error'
                        });
                    }
                })
            }
        }
    });
</script>
</body>

< /html>