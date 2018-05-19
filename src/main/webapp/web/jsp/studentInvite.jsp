<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>邀请老师</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/select.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        #learning-team-wrap {
            width: 100%;
        }

        .message-box {
            width: 100%;
            border-bottom: 1px solid #ccc;
        }

        .global-title {
            margin-top: 30px;
        }
        .my-btn{
            padding: 5px 20px;
            background-color: #37BC9B;
            color: #fff;
            border: none;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            font-size: 16px;
            letter-spacing: 4px;
            transition: all 0.5s;
            -moz-transition: all 0.5s;
            -webkit-transition: all 0.5s;
            -o-transition: all 0.5s;
        }

        .my-btn1{
            padding: 5px 20px;
            background-color: grey;
            color: #fff;
            border: none;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            font-size: 16px;
            letter-spacing: 4px;
            transition: all 0.5s;
            -moz-transition: all 0.5s;
            -webkit-transition: all 0.5s;
            -o-transition: all 0.5s;
        }
    </style>
</head>

<body>
<%@ include file="navbar1.jsp" %>

<div id="container-wrap">

    <div class="global-banner"></div>
    <div id="my-middle-container">
        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>收到的邀请</p>
        </div>
        <div>
            <c:forEach items="${invites}" var="item"    varStatus="id" >
                <div class="message-box">
                    <p>第${id.index+1}条邀请</p>
                    <p>邀请我的学生姓名：${item.uName}</p>
                    <c:choose>
                    <c:when test="${item.status==0}">
                        <p>邀请状态：未接收</p>
                        <form action="/young/teacher/agree/${item.inviteId}" method="get">
                            <input type="submit" value="接受" class="my-btn">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <p>邀请状态：已接收<p>
                        <button type="button" disabled="disabled" class="my-btn1">接受</button>
                    </c:otherwise>
                    </c:choose>
                    <hr/>
                </div>
            </c:forEach>
        </div>
    </div>


</div>

<footer>
    <%@ include file="footer.jsp" %>
</footer>


<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/main.js"></script>
</body>
</html>
