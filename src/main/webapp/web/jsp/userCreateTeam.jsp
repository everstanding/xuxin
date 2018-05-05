<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>我的组队</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/user.css" rel="stylesheet">

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
                <p>我的组队</p>
            </div>

            <table id="my-team-table" class="table table-bordered">
                <thead>
                <tr>
                    <th>队伍标题</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>


                <tbody>

                <c:forEach items="${table}" var="team"    varStatus="id" >
                    <tr>
                        <td>${team.tTitle}</td>
                        <td>${team.tuStateString}</td>
                        <td>
                            <button type="button" class="table-button" ><a href="/young/${team.tId}/teamDetail" target="_blank">简介</a></button>
                            <button type="button" class="table-button" onclick="get_mates(${team.tId})">队友</button>
                            <button type="button" class="table-button" ><a href="/team/${team.tId}/teamTaskLeader" target="_blank">日历</a></button>
                        </td>
                    </tr>
                </c:forEach>
               <%-- <tr>
                    <td>Tiger Nixon</td>
                    <td>123456</td>
                    <td>
                        <button type="button" class="table-button">详情</button>
                        <button type="button" class="table-button view-mate">删除</button>
                    </td>
                </tr>--%>
                </tbody>
            </table>

        </div>


    </div>

    <!------------view-mate-modal--------------->
    <div class="modal fade" id="view-mate-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <%--<h4 class="modal-title" id="myModalLabel-2">提示</h4>--%>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="tb">
                        <tr>
                            <td>Tiger Nixon</td>
                            <td>
                                <button type="button" class="table-button">详情</button>
                                <button type="button" class="table-button">删除</button>
                            </td>
                        </tr>
                        <tr>
                            <td>Garrett Winters</td>
                            <td>
                                <button type="button" class="table-button">详情</button>
                                <button type="button" class="table-button">删除</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>
    <!-----------/view-mate-modal------------>
</div>
<footer>
    <%@ include file="footer.jsp" %>
</footer>


<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function() {
        //left bar
        $("#left-bar").find(".my-team-create").addClass("act").siblings().removeClass("act");
    });
    function go_mate_info(young) {
        window.location.href="/young/"+young+"/userDetail";
    }
    //view mate
   /* $("table .view-mate").on("click",function () {
        $("#view-mate-modal").modal();
    });*/
    function get_mates(t_id) {
        $.ajax({
            type: "post",
            async: true,
            dataType: "json", //收受数据格式
            traditional: true,
            url: "${pageContext.request.contextPath}/young/get_mates",
            cache: false,
            data: {
                "t_id":t_id
            },
            success: function (data) {
                var html = '';
                var users=data.obj;
                var users_num=users.length;
                for(var i=0;i<users_num;i++){
                    html+=' <tr>' +
                        '                            <td>'+users[i].uName+'</td>' +
                        '                            <td>' +
                        '                                <button type="button" class="table-button"><a href="/young/'+users[i].uId+'/userDetail" target="_blank">查看用户资料</a></button>' +
                        '                            </td>' +
                        '                        </tr>';
                }
                $("#tb").empty();
                $("#tb").append(html);
                $("#view-mate-modal").modal();

            }
        }); //ajax over
    }

</script>

</body>



</html>
