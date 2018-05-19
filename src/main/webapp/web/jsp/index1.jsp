<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>教师端</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/index.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        #my-middle-container{
            min-height: 500px;
        }

        .global-title{
            margin-top: 50px;
            width:750px;
        }

    </style>

</head>

<body>

<%@ include file="navbar1.jsp" %>


<div id="container-wrap">
    <div id="my-middle-container">
        <!------------index-carousel--------------->
        <div id="index-carousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#index-carousel" data-slide-to="0" class="active"></li>
                <li data-target="#index-carousel" data-slide-to="1"></li>
                <li data-target="#index-carousel" data-slide-to="2"></li>
                <li data-target="#index-carousel" data-slide-to="3"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="/web/images/bg.jpg" alt="">
                </div>
                <div class="item">
                    <img src="/web/images/bg2.jpg" alt="">
                </div>
                <div class="item">
                    <img src="/web/images/3.jpg" alt="">
                </div>
                <div class="item">
                    <img src="/web/images/bg2.jpg" alt="">
                </div>

            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#index-carousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-menu-left center-vertical-left" aria-hidden="true"></span>
            </a>
            <a class="right carousel-control" href="#index-carousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-menu-right center-vertical-right" aria-hidden="true"></span>
            </a>

        </div>
        <!------------/index-carousel--------------->

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>广播</p>
        </div>

        <!------------broadcast--------------->
        <div id="broadcast-wrap">

            <c:forEach items="${teams}" var="team"    varStatus="id" >
                <div class="message-box">
                    <img src="${team.uHeaderUrl}" class="portrait" />
                    <p class="name">${team.uName}</p>
                    <p class="title">${team.tTitle}</p>
                    <p class="detail">${team.tIntro}</p>
                    <div class="box-bottom">
                        <ul class="labels">
                            <c:forEach items="${team.labers}" var="laber"    varStatus="id" >
                                <li class="label">${laber.lName}</li>
                            </c:forEach>
                        </ul>
                        <div class="other">
                            <button type="button" class="view-detail gray-button"><a href="/young/${team.tId}/teamDetail1" target="_blank">查看详情</a></button>
                            <button type="button" class="add-team gray-button" onclick="f(${team.tId})">加入组队</button>
                                <%-- <button type="button" class="thumbs-up">赞(${team.tTumbNum})</button>--%>
                            <p class="hits-number">${team.tWatchNum}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <!------------add-team-modal-------------->
            <div class="modal fade" id="add-team-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <%--<h4 class="modal-title" id="myModalLabel">提示</h4>--%>
                        </div>
                        <div class="modal-body">
                            <p class="error-message">确认加入组队吗？</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="f2()">确定</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>

                    </div>
                </div>
            </div>

        </div>




        <form action="/young/add_team" method="post" id="add_team">
            <input type="text" hidden="hidden" id="t_id" name="t_id" >
            <input type="text" hidden="hidden" name="location" value="/young/index" >
        </form>
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
        //showMyNotice("notice");
        $("#global-top-navbar").find(".broadcast").addClass("act").siblings().removeClass("act");
    });
    $(".message-box .add-team").on("click",function () {
        $("#add-team-modal").modal();
    });
    function f(t_id) {
        $("#t_id").val(t_id);
    }
    function f2() {
        $("#add_team").submit();
    }
</script>

</body>



</html>
