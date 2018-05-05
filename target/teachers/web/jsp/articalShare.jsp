<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>学习经验分享</title>

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

    </style>

</head>

<body>
<%@ include file="navbar.jsp" %>

<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>SHARE</p>
        </div>

        <div id="learning-team-wrap">

            <c:forEach items="${studies}" var="study"    varStatus="id" >
                <div class="message-box">
                    <img src="${study.uHeaderUrl}" class="portrait" />
                    <p class="name">${study.uName}</p>
                   <%-- <p class="title"><a href="${study.sUrl}" target="_blank" onclick="f(${study.sUrl})">${study.sTitle}</a></p>--%>
                    <p class="title"><a href="#"  onclick="f('${study.sUrl}',${study.sId})">${study.sTitle}</a></p>
                    <p class="detail">${study.sIntro}</p>
                    <div class="box-bottom">
                        <div class="other">
                            <button type="button" class="thumbs-up">赞(${study.sTumbNum})</button>
                            <p class="hits-number">${study.sMatchNum}</p>
                        </div>
                    </div>
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

<script>
    $(document).ready(function() {
        //navbar act
        $("#global-top-navbar").find(".article").addClass("act").siblings().removeClass("act");
        //multi-select empty
        $(".multi-labels").empty();
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
