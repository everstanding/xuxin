<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>学习组队</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/userDetail.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .global-title{
            margin-top:40px;
        }
        .global-banner {
            position: absolute;
        }

    </style>

</head>

<body>
<%@ include file="navbar.jsp" %>


<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <div id="user-detail-top">
            <img src="${user.uHeaderUrl}" class="portrait" />
            <p class="username">${user.uName}</p>
            <div class="detail-list">
                <p class="gender">性别：<span>${user.uGender}</span></p>
                <p class="stu-no">学号：<span>${user.uSchoolNum}</span></p>
                <br/>
                <p class="qq">QQ：<span>${user.uQq}</span></p>
                <p class="wx">微信：<span>${user.uWx}</span></p>
                <p class="phone">手机：<span>${user.uPhone}</span></p>
            </div>

        </div>

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>ta发布的组队</p>
        </div>

        <div id="" class="user-detail-block user-detail-team-block">
            <!--                <h3 class="title">ta的组队</h3>-->
            <ul class="user-detail-list">
                <c:if test="${team_create_list==null||team_create_list.size()==0}">
                    <li class="item"><a href="#">无</a></li>
                </c:if>
                <c:forEach items="${team_create_list}" var="team_create"    varStatus="id" >
                    <li class="item"><a href="/young/${team_create.tId}/teamDetail" target="_blank">${team_create.tTitle}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>ta的组队</p>
        </div>

        <div id="user-detail-team" class="user-detail-block user-detail-team-block">
            <!--                <h3 class="title">ta的组队</h3>-->
            <ul class="user-detail-list">
                <c:if test="${team_join_list==null||team_join_list.size()==0}">
                <li class="item"><a href="#">无</a></li>
                </c:if>
                <c:forEach items="${team_join_list}" var="team_join"    varStatus="id" >
                    <li class="item"><a href="/young/${team_join.tId}/teamDetail" target="_blank">${team_join.tTitle}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>ta的经验分享</p>
        </div>

        <div id="user-detail-article" class="user-detail-block">
            <ul class="user-detail-list">
                <c:if test="${studys==null||studys.size()==0}">
                    <li class="item"><a href="#">无</a></li>
                </c:if>
                <c:forEach items="${studys}" var="study"    varStatus="id" >
                    <li class="item"><a href="#"  onclick="f('${study.sUrl}',${study.sId})">${study.sTitle}</a></li>
                </c:forEach>
            </ul>
        </div>

    </div>

</div>

<footer>
    <%@ include file="footer.jsp" %>
</footer>


<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function() {
    });

    function f(url,s_id) {
        window.open(url);
        $.ajax({
            type: "post",
            async: true,
            dataType: "json", //收受数据格式
            traditional: true,
            url: "${pageContext.request.contextPath}/young/study_watch_update",
            cache: false,
            data: {
                "s_id" :s_id
            },
            success: function (data) {
            }
        }); //ajax over
    }
</script>

</body>



</html>
