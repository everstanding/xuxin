<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/10/25
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<meta name="viewport" content="width=device-width; initial-scale=1.0;  minimum-scale=1.0; maximum-scale=2.0"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/web/css/index.css" rel="stylesheet" type="text/css" />
<link href="ico.ico" rel="shortcut icon" />
<title>这？是宇宙第一美少女？</title>
<meta name="keywords" content="送给皇子"/>
<meta name="description" content="送给皇子"/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                hippocrates
            </h3>
            <img src="${pageContext.request.contextPath}${pic.imageUrl}"/>
            <button class="btn btn-default btn-primary" type="button" onclick="f()">换一张</button>
        </div>
    </div>
</div>
</body>

</html>
<script>
    function f(){
        window.location.href="${pageContext.request.contextPath}/young";
    }
</script>