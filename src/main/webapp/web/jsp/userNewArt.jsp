<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>分享新的经验</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/user.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/select.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        body {
            background-color: rgb(247, 247, 247);
        }

        .select-row .title {
            width: 150px;
        }

    </style>

</head>

<body>
<%@ include file="navbar.jsp" %>


<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <%@ include file="leftbar.jsp" %>

        <div id="user-right-wrap">
            <div class="global-title">
                <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
                <p>发布新的经验分享</p>
            </div>

            <!-------------new-article-panel--------------->
            <div id="new-article-panel">
                <form id="new_study_form" action="/young/up_study" method="post">
                        <div class="select-row">
                            <p class="title">标题</p>
                            <input type="text" class="global-input" id="article-title" name="sTitle">
                        </div>

                        <div class="clear-div" style="clear:both"></div>

                        <div class="select-row">
                            <p class="title">链接</p>
                            <input type="text" class="global-input" id="article-link" name="sUrl">
                        </div>

                        <div class="clear-div" style="clear:both"></div>
                    <input type="text" id="team-detail2"  hidden="hidden" name="sIntro">
                        <div class="select-row">
                            <p class="title" style="width:150px">心愿or自我介绍</p>
                            <textarea id="team-detail"></textarea>
                        </div>

                        <div class="clear-div" style="clear:both"></div>

                        <button type="button" class="submit" onclick="f()">发布经验</button>

                </form>
            </div>
            <!-------------/new-article-panel--------------->

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
        $("#left-bar").find(".new-article").addClass("act").siblings().removeClass("act");
    });
    function f() {
        $("#team-detail2").val($("#team-detail").val());
        $("#new_study_form").submit();
    }
</script>

</body>



</html>
