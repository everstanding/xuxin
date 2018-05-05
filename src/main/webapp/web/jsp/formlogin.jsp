<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>登录</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/form.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        body {
            background-color: #eee;
        }

    </style>

</head>

<body>


<div id="container-wrap">

    <form id="login-form" class="my-form" action="/young/login" method="post">
        <h3 class="title">立即登录</h3>
        <label for="student">学生</label>
        <input type="radio" id="student" value="student" name="user" />
        <label for="teacher">教师</label>
        <input type="radio" id="teacher" value="teacher" name="user" />
        <label for="administration">管理员</label>
        <input type="radio" id="administration" value="administration" name="user" />
        <ul class="form-list">
            <li class="form-item username">
                <input type="text" id="username-input" placeholder="学号" name="school_num"/>
            </li>
            <li class="form-item password">
                <input type="password" id="password-input" placeholder="密码" name="pw" />
            </li>
        </ul>

        <a href="/young/formRegister" class="to-register">免费注册</a>

        <button type="button" class="submit" onclick="f()">登录</button>
    </form>

</div>




<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<script>
function f() {
   $("#login-form").submit();
}

</script>

</body>



</html>
