<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/4
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员端</title>
</head>
<body>
<div id="container-wrap">

    <div class="global-banner"></div>
    <div id="my-middle-container">
        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>学生用户</p>
        </div>
        <div>
            <c:forEach items="${user}" var="item"    varStatus="id" >
                <p>${item.uName}</p>
            </c:forEach>
        </div>
        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>教师用户</p>
        </div>
        <div>
            <c:forEach items="${teacher}" var="item"    varStatus="id" >
                <p>${item.tName}</p>
            </c:forEach>
        </div>
    </div>

    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</div>
</body>
</html>
