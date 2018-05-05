<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>学习组队</title>

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

    </style>

</head>

<body>
<%@ include file="navbar.jsp" %>




<div id="container-wrap">

    <div class="global-banner"></div>

    <div id="my-middle-container">

        <div id="select-bar">

            <div class="global-title">
                <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
                <p>选择需要的学习组队</p>
            </div>

            <!---------------select-list---------------->
            <div class="select-list">

                <div class="select-row">
                    <p class="title">年级</p>
                    <ul class="label-list single-labels" id="grade-select">
                        <li class="my-label" data-id="1">大一</li>
                        <li class="my-label" data-id="2">大二</li>
                        <li class="my-label" data-id="3">大三</li>
                        <li class="my-label" data-id="4">大四</li>
                        <li class="my-label" data-id="0">不限制</li>
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
                        <li class="my-label" data-id="0">不限制</li>
                    </ul>
                </div>

                <div class="clear-div" style="clear:both"></div>

                <div class="select-row">
                    <p class="title">需求科目</p>
                    <div class="nice-select" name="nice-select" id="need-nice-select">
                        <input type="text" value="" readonly>
                        <ul>
                            <li data-id="0">不限制</li>
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

                <div class="select-row">
                    <p class="title">可提供科目</p>
                    <div class="nice-select" name="nice-select" id="supply-nice-select">
                        <input type="text" value="" readonly>
                        <ul>
                            <li data-id="0">不限制</li>
                            <c:forEach items="${labers}" var="laber"    varStatus="id" >
                                <li data-id="${laber.lId}">${laber.lName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <ul class="label-list multi-labels" id="supply-subject-select">
                        <!--                            <li class="my-label">操作系统</li>-->

                    </ul>

                </div>



            </div>
            <!---------------/select-list---------------->

            <div class="clear-div" style="clear:both"></div>

            <button type="button" id="submit-select">提交</button>

        </div>

        <div class="global-title">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>TEAM</p>
        </div>

        <div id="learning-team-wrap">

        </div>

    </div>

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
    <!-----------/add-team-modal------------>
    <form action="/young/add_team" method="post" id="add_team">
        <input type="text" hidden="hidden" id="t_id" name="t_id" >
        <input type="text" hidden="hidden" name="location" value="/young/learningTeam" >
    </form>

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
        $("#global-top-navbar").find(".learning-team").addClass("act").siblings().removeClass("act");
        //multi-select empty
        $(".multi-labels").empty();
    });


    //click select submit
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

        console.log("gradeString:" + gradeString);
        console.log("peopleString:" + peopleString);
        console.log("needLabelString:" + needLabelString);
        console.log("supplyLabelString:" + supplyLabelString);
        $.ajax({
            type: "post",
            async: true,
            dataType: "json", //收受数据格式
            traditional: true,
            url: "${pageContext.request.contextPath}/young/get_team_list",
            cache: false,
            data: {
                "grade":gradeString,
                "scale":peopleString,
                "need":needLabelString,
                "support":supplyLabelString,
                "type":1
            },
            success: function (data) {
                var html = '';
                var teams=data.obj;
                var teams_num=teams.length;
                for(var i=0;i<teams_num;i++){
                    html+='<div class="message-box">' +
                        '                            <img src="'+teams[i].uHeaderUrl+'" class="portrait" />' +
                        '                            <p class="name">'+teams[i].uName+'</p>' +
                        '                            <p class="title">'+teams[i].tTitle+'</p>\n' +
                        '                            <p class="detail">'+teams[i].tIntro+'</p>' +
                        '                        <div class="box-bottom">' +
                        '                            <ul class="labels">';
                    var labers = teams[i].labers;
                    var laber_num = labers.length;
                    for(var j=0;j<laber_num;j++){
                        html+=' <li class="label">'+labers[j].lName+'</li>'
                    }
                    html+='                            </ul>' +
                        '                            <div class="other">' +
                        ' <button type="button" class="view-detail gray-button"><a href="/young/'+teams[i].tId+'/teamDetail" target="_blank">查看详情</a></button>\n' +
                        '                        <button type="button" class="add-team gray-button" onclick="f('+teams[i].tId+')">加入组队</button>' +
      /*                  '                            <button type="button" class="thumbs-up">赞('+teams[i].tTumbNum+')</button>' +*/
                        '                            <p class="hits-number">'+teams[i].tWatchNum+'</p>' +
                        '                            </div>' +
                        '                            </div>' +
                        '                            </div>';
                    /**/
                }
                $("#learning-team-wrap").empty();
                $("#learning-team-wrap").html(html);
                alert(teams_num+"条组队信息满足搜索要求");
                $(".message-box .add-team").on("click",function () {
                    $("#add-team-modal").modal();
                });
            }
        }); //ajax over
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
