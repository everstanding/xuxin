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
                    <li class="broadcast"><a href="${pageContext.request.contextPath}/young/index1">首页</a></li>
                    <li class="article"><a href="${pageContext.request.contextPath}/young/share2">学习经验分享</a></li>
                    <li class="chat"><a href="${pageContext.request.contextPath}/young/studentInvite">学生邀请</a></li>
                    <li class="study"><a href="${pageContext.request.contextPath}/young/files">教学视频与资料</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="teacher-name"><a href="${pageContext.request.contextPath}/young/teacherInfo">${USER.tName}</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</head>