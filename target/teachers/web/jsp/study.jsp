<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>学习资料与视频</title>

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

<%@ include file="navbar1.jsp" %>

<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>上传学习资料或者视频</p>
        </div>

        <form action="/file/uploadFile" method="post" enctype="multipart/form-data">
            <%-- 类型enctype用multipart/form-data，这样可以把文件中的数据作为流式数据上传，不管是什么文件类型，均可上传。--%>
            <p style="color:slateblue;font-size: 20px">请选择要上传的文件:</p><input type="file" style="border-color: #2aabd2 ;color:slateblue;border-width:5px" name="file" size="50">
                <p>                </p>
                <input type="submit" value="提交2">
        </form>

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>我的学习资料和视频</p>
        </div>
        <div>
            <c:forEach items="${studyfiles}" var="item"    varStatus="id" >
                <p>${item.fName}</p>
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
        $("#global-top-navbar").find(".study").addClass("act").siblings().removeClass("act");
//multi-select empty
        $(".multi-labels").empty();
    });
</script>
</body>
</html>
