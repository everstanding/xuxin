<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="left-bar">
    <div class="portrait">
        <img src="${USER.uHeaderUrl}" />
        <p>${USER.uName}</p>
    </div>
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation" class="info"><a href="${pageContext.request.contextPath}/young/userInfo">基本信息</a></li>
        <li role="presentation" class="my-team-join"><a href="${pageContext.request.contextPath}/young/userMyTeam">我加入的组队</a></li>
        <li role="presentation" class="my-team-create"><a href="${pageContext.request.contextPath}/young/userMyTeamCreate">我发布的组队</a></li>
        <li role="presentation" class="new-team-learning"><a href="${pageContext.request.contextPath}/young/userNewTeam/study">发布新的学习组队</a></li>
        <li role="presentation" class="new-team-project"><a href="${pageContext.request.contextPath}/young/userNewTeam/project">发布新的项目组队</a></li>
        <li role="presentation" class="my-article"><a href="${pageContext.request.contextPath}/young/userMyArt">我分享的经验</a></li>
        <li role="presentation" class="new-article"><a href="${pageContext.request.contextPath}/young/userNewArt">发布新的经验分享</a></li>
        <li role="presentation" class="log-out"><a href="${pageContext.request.contextPath}/young/logout">登出</a></li>
    </ul>

    <!--                <div class="verticle-line" style="height:60%;top:25%;right:1px"></div>-->

</div>