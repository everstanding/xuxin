<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>我分享的经验</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/user.css" rel="stylesheet">

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
                <p>我分享的经验</p>
            </div>

            <table id="my-article-table" class="table table-bordered">
                <thead>
                <tr>
                    <th>经验标题</th>
                    <th>操作</th>

                </tr>
                </thead>


                <tbody>

                <c:forEach items="${studys}" var="study"    varStatus="id" >
                    <tr>
                        <td>${study.sTitle}</td>
                        <td>
                            <button type="button" class="table-button"><a href="${study.sUrl}">查看</a></button>
                            <button type="button" class="table-button"><a href="/young/del_art/${study.sId}">删除</a></button>
                        </td>
                    </tr>
                </c:forEach>
                <%--<tr>
                    <td>Tiger Nixon</td>
                    <td>123456</td>
                    <td>
                        <button type="button" class="table-button">详情</button>
                        <button type="button" class="table-button">删除</button>
                    </td>
                </tr>--%>


                </tbody>
            </table>

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
    $(document).ready(function () {
        //leftbar act
        $("#left-bar").find(".my-article").addClass("act").siblings().removeClass("act");
    });


</script>

</body>



</html>
