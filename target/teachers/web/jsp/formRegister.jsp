<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册</title>

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

    <form id="register-form" class="my-form" action="/young/register" method="post">
        <h3 class="title">免费注册</h3>

        <ul class="form-list">
            <li class="form-item username">
                <input type="text" id="username-input" placeholder="姓名" name="uName"/>
            </li>
            <li class="form-item stu-no">
                <input type="text" id="stu-no-input" placeholder="学号" name="uSchoolNum"/>
            </li>
            <li class="form-item gender" id="radio">
                <input id="uGender1" name="uGender" hidden="hidden" value="">
                <div class="gender-radio">
                    <p class="title-male">男</p>
                    <input type="radio" name="gender-radio" id="male-radio" value="1" checked="checked">
                    <p class="title-female">女</p>
                    <input type="radio" name="gender-radio" id="female-radio" value="2">
                </div>
            </li>
            <li class="form-item qq">
                <input type="text" id="qq-input" placeholder="QQ" name="uQq" />
            </li>
            <li class="form-item wx">
                <input type="text" id="wx-input" placeholder="微信" name="uWx"/>
            </li>
            <li class="form-item phone">
                <input type="text" id="phone-input" placeholder="手机号" name="uPhone"/>
            </li>
            <li class="form-item password">
                <input type="password" id="password-input" placeholder="密码" name="Pw"/>
            </li>

        </ul>

        <a href="#" class="to-login">已有账号，立即登录</a>

        <button type="button" class="submit" onclick="sub_f()">立即注册</button>
    </form>

</div>




<!----------js------------>
<script src="/web/js/jquery-3.1.1.min.js"></script>
<script src="/web/js/bootstrap.min.js"></script>

<script>
    function sub_f() {
        if($("#radio").find(".gender-radio input[type='radio']:checked").val()==1){
            $("#uGender1").val('男');
        }else{
            $("#uGender1").val('女');
        }
        $("#register-form").submit();
    }
</script>

</body>



</html>
