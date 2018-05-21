<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>question</title>

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
            letter-spacing: 0.5em;
        }

        #question-text{
            display: block;
            margin: 10px 0;
            width: 100%;
            height: 150px;
            padding: 10px;
            border:2px solid #37BC9B;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            outline: none;
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

        .comment-wrap{
            margin: 20px 0;
        }
        .comment-box{
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
        .comment-box .box-header .user-name{
            display: inline;
            margin-right: 15px;
            font-size: 20px;
            font-weight: bold;
        }
        .comment-box .box-header .sub-info{
            display: inline;
            font-size: 15px;
        }
        .comment-box .content{
            min-height: 60px;
            padding: 10px;
            text-indent: 2em;
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
    </style>

</head>

<body>
<%@ include file="navbar.jsp" %>

<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>提出看法和回答</p>
        </div>
        <div>
            <h4 class="sub-title">问题:${post.pMain}</h4>
            <form action="/young/${p_id}/add_floor" id="sub" method="post">
            <textarea name="main" id="main" class="my-textArea" placeholder="在这提出你的想法和见解……"></textarea>
            <input type="submit" value="提交"  name="submit" class="my-btn"/>
            <input type="reset" value="重置"  name="reset" class="my-btn"/>
            </form>
        </div>
        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>评论区                     目前一共${post.pFloor}层回复</p>
        </div>

        <div class="comment-wrap">
            <ul id="comment-list">
                <c:forEach items="${floors}" var="team"    varStatus="id" >
                    <li class="comment-box">
                        <div class="box-header">
                            <p class="user-name">${team.uName}</p>
                            <p class="sub-info" >第${id.index+1}楼</p>
                        </div>
                        <div class="content">${team.fMain}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>
    <footer>
        <%@ include file="footer.jsp" %>
    </footer>
</div>
</body>



</html>