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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>队长日历</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/calendar.css" rel="stylesheet">

    <!-- FullCalendar -->
    <link href="${pageContext.request.contextPath}/web/vendors/fullcalendar/dist/fullcalendar.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/vendors/fullcalendar/dist/fullcalendar.print.css" rel="stylesheet" media="print">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        body {
            /*background-color: #eee;*/
        }

    </style>

</head>

<body>


<div id="container-wrap">

    <div id="left-flex-bar">
        <ul class="bar-content">
            <li class="active"><a>日历</a></li>
            <li><a href="/team/${tid}/1/album">查看</a></li>
        </ul>
        <button class="flex-button"><</button>
    </div>

    <div class="global-title" style="width: 900px;margin: 25px auto">
        <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
        <p>任务日历</p>
    </div>

    <div id="calendar-wrap">
        <div id="calendar"></div>

    </div>

    <div id="calendar-modal-create" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">创建新任务</h4>
                </div>
                <div class="modal-body">
                    <div style="padding: 5px 20px;">
                        <form id="calendar-create-form" action="/team/add_task" method="post" >

                            <input type="text" id="task_detail"  hidden="hidden" name="task_detail">
                            <input type="text" id="date"  hidden="hidden" name="date">
                            <input type="text" id="team_id"  hidden="hidden" name="team_id" value="${tid}">

                            <div class="select-row">
                                <p class="title">标题</p>
                                <input type="text" class="global-input" id="task_title" name="task_title"/>
                            </div>

                            <div class="select-row">
                                <p class="title">描述</p>
                                <textarea id="task-detail2"></textarea>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="submit_button">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <div id="fc_create" data-toggle="modal" data-target="#CalenderModalNew"></div>
    <!-- /calendar modal -->

</div>




<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<!-- FullCalendar -->
<script src="${pageContext.request.contextPath}/web/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/web/vendors/fullcalendar/dist/fullcalendar.js"></script>
<script src="${pageContext.request.contextPath}/web/js/initVendors.js"></script>

<script>

    $(".fc-day").each(function (value) {

        <c:forEach items="${tasks}" var="task"   >
        if($(this).attr("data-date")==="${task.task_date_String}"){
            $(this).addClass("fc-bgevent");
            console.log("add class");
        }
        </c:forEach>

    });


    $(".fc-day").on("click",function () {
        $("#calendar-modal-create").modal();
        $("#date").val($(this).attr("data-date"));
        console.log("click grid",$(this).attr("data-date"));
    });


    $("#submit_button").on("click",function () {
        console.log("12313  ");
        $("#task_detail").val($("#task-detail2").val());
        $("#calendar-create-form").submit();
    });


</script>

</body>



</html>
