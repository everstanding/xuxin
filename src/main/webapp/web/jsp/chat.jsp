<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>chat</title>

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
        .sub-title{
            font-size: 20px;
            color: #37BC9B;
            font-weight: bold;
            letter-spacing: 0.2em;
        }

        .my-textArea{
            display: block;
            margin: 10px 0;
            width: 100%;
            height: 150px;
            padding: 10px;
            border:2px solid #37BC9B;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            outline: none
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
        .my-btn:hover{
            background-color: #24a888;
        }
        .question-list-wrap{
            margin: 20px 0;
        }
        .question-box{
            display: block;
            width: 100%;
            margin: 10px 0;
            border: none;
            border-bottom: 1px solid #cccccc;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            cursor: default;
            letter-spacing: 0.1em;
        }
        .question-box .title{
            display: inline;
            margin-right: 15px;
            font-size: 17px;
            font-weight: bold;
        }
        .question-box .content{
            min-height: 60px;
            padding: 10px;
            text-indent: 2em;
            font-size: 15px;
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
            <p>提出新问题</p>
        </div>

        <div>
            <form action="/young/add_post" id="sub" method="post">
                <h5 class="sub-title">标题</h5>
                <textarea name="title" id="title" class="my-textArea" placeholder="标题" style="height: 40px;line-height: 35px;padding: 0 10px;"></textarea>
                <h5 class="sub-title">具体内容</h5>
                <textarea name="main" id="main" class="my-textArea" placeholder="具体内容" style="height: 200px"></textarea>
                <input type="submit" value="提交"  name="submit" class="my-btn"/>
                <input type="reset" value="重置"  name="reset" class="my-btn"/>
            </form>
        </div>

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>所有问题</p>
        </div>

        <div class="question-list-wrap">
            <ul id="question-list">
                <c:forEach items="${post}" var="item"    varStatus="id" >
                    <li class="question-box">
                        <p class="title">${item.pTitle}-------------------------${item.uName}</p>
                        <a href="/young/${item.pId}/post" onclick=""><p class="content">${item.pMain}</p></a>
                    </li>
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
<script src="${pageContext.request.contextPath}/web/js/main.js"></script>



<script>
    $(document).ready(function() {
//navbar act
        $("#global-top-navbar").find(".chat").addClass("act").siblings().removeClass("act");
//multi-select empty
        $(".multi-labels").empty();
    });

</script>
</body>

</html>