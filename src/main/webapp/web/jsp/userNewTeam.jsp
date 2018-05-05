<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>发布新的组队</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/user.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/select.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        body {
            background-color: rgb(247, 247, 247);
        }

        .select-row ul.multi-labels {
            width: 465px;
        }

    </style>

</head>

<body>
<%@ include file="navbar.jsp" %>

<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <%@ include file="leftbar.jsp" %>

        <div id="user-right-wrap">
            <div class="global-title">
                <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
                <p>发布新的组队</p>
            </div>

            <!-------------new-team-panel--------------->
            <div id="new-team-panel">

                <div class="select-row">
                    <p class="title">标题</p>
                    <input type="text" class="global-input" id="team-title">
                </div>

                <div class="clear-div" style="clear:both"></div>

                <%--<div class="select-row">
                    <p class="title">分类</p>
                    <ul class="label-list single-labels" id="people-select">
                        <li class="my-label act">学习组队</li>
                        <li class="my-label">项目组队</li>
                    </ul>
                </div>

                <div class="clear-div" style="clear:both"></div>--%>


                <div class="select-row">
                    <p class="title">年级</p>
                    <ul class="label-list single-labels" id="grade-select">
                        <li class="my-label" data-id="1">大一</li>
                        <li class="my-label" data-id="2">大二</li>
                        <li class="my-label" data-id="3">大三</li>
                        <li class="my-label" data-id="4">大四</li>
                    </ul>
                </div>

                <div class="clear-div" style="clear:both"></div>

                <div class="select-row">
                    <p class="title">人数</p>
                    <ul class="label-list single-labels" id="people-select">
                        <li class="my-label" data-id="1">1人</li>
                        <li class="my-label" data-id="2">2人</li>
                        <li class="my-label" data-id="3">3人</li>
                        <li class="my-label" data-id="4">4人</li>
                    </ul>
                </div>

                <div class="clear-div" style="clear:both"></div>

                <div class="select-row">
                    <p class="title">需求科目</p>
                    <div class="nice-select" name="nice-select" id="need-nice-select">
                        <input type="text" value="" readonly>
                        <ul>
                            <c:forEach items="${labers}" var="laber"    varStatus="id" >
                                <li data-id="${laber.lId}">${laber.lName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <ul class="label-list multi-labels" id="need-subject-select">
                        <!--                            <li class="my-label">操作系统</li>-->

                    </ul>

                </div>


                <div class="clear-div" style="clear:both"></div>



                <c:if test="${type == 1}">
                    <div class="select-row">
                        <p class="title">可提供科目</p>
                        <div class="nice-select" name="nice-select" id="supply-nice-select">
                            <input type="text" value="" readonly>
                            <ul>
                                <c:forEach items="${labers}" var="laber"    varStatus="id" >
                                    <li data-id="${laber.lId}">${laber.lName}</li>
                                </c:forEach>
                            </ul>
                        </div>
                        <ul class="label-list multi-labels" id="supply-subject-select">


                        </ul>
                    </div>

                    <div class="clear-div" style="clear:both"></div>
                </c:if>


                <div class="select-row">
                    <p class="title" style="width:150px">心愿or自我介绍</p>
                    <textarea id="team-detail"></textarea>
                </div>

                <div class="clear-div" style="clear:both"></div>

                <button type="button" class="submit" id="submit-select">提交组队</button>


            </div>
            <!-------------/new-team-panel--------------->

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
        $("#left-bar").find(".${page}").addClass("act").siblings().removeClass("act");
    });
    $("#submit-select").on("click", function() {
        var needLabelString = '',
            supplyLabelString = '';
        var gradeString = $("#grade-select").find(".act").attr("data-id");
        var peopleString = $("#people-select").find(".act").attr("data-id");
        //need label list
        var needLabelList = $("#need-subject-select").find("li");
        for (var i = 0; i < needLabelList.length; i++) {
            if (i > 0) {
                needLabelString += '_';
            }
            needLabelString += needLabelList.eq(i).attr("data-id");
        }
        //supply label list
        var supplyLabelList = $("#supply-subject-select").find("li");
        for (var i = 0; i < supplyLabelList.length; i++) {
            if (i > 0) {
                supplyLabelString += '_';
            }
            supplyLabelString += supplyLabelList.eq(i).attr("data-id");
        }
        if(2==${type}){
            supplyLabelString=needLabelString;
        }
        console.log("gradeString:" + gradeString);
        console.log("peopleString:" + peopleString);
        console.log("needLabelString:" + needLabelString);
        console.log("supplyLabelString:" + supplyLabelString);
        $.ajax({
            type: "post",
            async: true,
            dataType: "json", //收受数据格式
            traditional: true,
            url: "${pageContext.request.contextPath}/young/new_team",
            cache: false,
            data: {
                "tTile" : $("#team-title").val(),
                "grade":gradeString,
                "scale":peopleString,
                "need":needLabelString,
                "support":supplyLabelString,
                "tIntro":$("#team-detail").val() ,
                "type" : ${type}
            },
            success: function (data) {
                alert(data.errmsg);
            }
        }); //ajax over
    });

</script>

</body>





</html>
