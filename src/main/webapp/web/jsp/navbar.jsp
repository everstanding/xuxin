<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#global-top-navbar" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="/web/images/logo.jpg" /></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="global-top-navbar">
                <ul class="nav navbar-nav">
                    <li class="broadcast"><a href="${pageContext.request.contextPath}/young/index">首页</a></li>
                    <li class="learning-team"><a href="${pageContext.request.contextPath}/young/learningTeam">学习组队</a></li>
                    <li class="project-team"><a href="${pageContext.request.contextPath}/young/projectTeam">项目组队</a></li>
                    <li class="article"><a href="${pageContext.request.contextPath}/young/articalShare">学习经验分享</a></li>
                    <li class="chat"><a href="${pageContext.request.contextPath}/young/p/1/post">交流问题</a></li>
                    <li class="chat"><a href="${pageContext.request.contextPath}/young/inviteTeacher">邀请教师</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="user-name"><a href="${pageContext.request.contextPath}/young/userInfo">${USER.uName}</a></li>
                    <li class="portrait">
                        <a href="${pageContext.request.contextPath}/young/userInfo"><img src="${pageContext.request.contextPath}${USER.uHeaderUrl}" /></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</head>
