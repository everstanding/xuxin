<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/26
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>组队详情</title>

    <!---------css----------->
    <link href="/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="/web/css/global.css" rel="stylesheet">
    <link href="/web/css/team.css" rel="stylesheet">

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
        #team-detail-panel .team-detail .content{
            white-space: normal;
        }

    </style>

</head>

<body>


<div id="container-wrap">

    <div id="team-detail-panel">
        <h3>组队详情</h3>
        <div class="row">
            <p class="title">标题</p>
            <p class="content">${team.tTitle}</p>
        </div>
        <div class="row team-detail">
            <p class="title">组队说明</p>
            <p class="content">${team.tIntro}</p>
        </div>
        <div class="row">
            <p class="title">年级</p>
            <p class="content">${team.tGradeString}</p>
        </div>
        <div class="row">
            <p class="title">人数</p>
            <p class="content">${team.tScale}人</p>
        </div>
        <div class="row">
            <p class="title">创建者</p>
            <p class="content">${team.uName}</p>
        </div>
        <div class="row">
            <p class="title">创建时间</p>
            <p class="content">${team.tTimeString}</p>
        </div>
        <div class="row">
            <p class="title">组队状态</p>
            <p class="content">${team.state}</p>
        </div>
        <div class="row">
            <p class="title">需求标签</p>
            <div class="label-list">
                <c:forEach items="${team.labers_need}" var="laber"    varStatus="id" >
                    <li class="label">${laber.lName}</li>
                </c:forEach>
            </div>
        </div>



        <div class="row">
            <p class="title">提供标签</p>
            <div class="label-list">
                <c:forEach items="${team.labers_support}" var="laber"    varStatus="id" >
                    <li class="label">${laber.lName}</li>
                </c:forEach>
            </div>
        </div>
    </div>

</div>




<!----------js------------>
<script src="/web/js/jquery-3.1.1.min.js"></script>
<script src="/web/js/bootstrap.min.js"></script>

<script>


</script>

</body>



</html>

