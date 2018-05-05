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
    <title>组队任务查看</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/calendar.css" rel="stylesheet">

    <!-- FullCalendar -->
    <!--<link href="../vendors/fullcalendar/dist/fullcalendar.css" rel="stylesheet">-->
    <!--<link href="../vendors/fullcalendar/dist/fullcalendar.print.css" rel="stylesheet" media="print">-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        body {
            background-color: rgb(245,245,245);
        }

    </style>

</head>

<body>


<div id="container-wrap">

    <<div id="left-flex-bar">
    <ul class="bar-content">
        <li ><a href="${href}">日历</a></li>
        <li class="active"><a href="/team/${tid}/album">查看</a></li>
    </ul>
    <button class="flex-button"><</button>
</div>

    <div id="my-middle-container">
        <div class="global-title" style="margin: 30px auto">
            <span class="glyphicon glyphicon-link" aria-hidden="true"></span>
            <p>队伍任务查看</p>
        </div>


            <c:forEach items="${tasks}" var="task"   >
        <div class="task-view-list-wrap">
            <h3 class="date-title">${task.task_date_String}&nbsp;${task.task_name}</h3>
                <ul class="task-view-list">

                <c:forEach items="${task.querys}" var="query"   >
                    <li class="view-item" data-head="${query.user.uHeaderUrl}" data-name="${query.user.uName}" data-time="${task.task_date_String}" data-title="${task.task_name}" data-detail="${query.userAndTask.utDetail}">
                        <div class="item-cover">
                            <p class="user-name">${query.user.uName}</p>
                            <p class="task-title">${query.userAndTask.utDetail}</p>
                        </div>
                        <img src="${query.userAndTask.utPicUrl}"/>
                    </li>
                 </c:forEach>
            </ul>
        </div>
            </c:forEach>





    </div>

    <div class="global-cover-deeper"></div>

    <div id="view-pic-page">
        <div class="img-wrap">
            <img src="${pageContext.request.contextPath}/web/images/noimage.png"/>
        </div>
        <div class="img-detail">
            <img class="user-portrait line-item" src="../images/portrait.jpg" id="data-head"/>
            <p class="user-name line-item" id="data-name">Phoebe</p>
            <p class="submit-date line-item" id="data-time">2018-03-14</p>
            <p class="task-title line-item" id="data-title">日语学习</p>
            <p class="task-detail" id="data-detail">日语学习日语学习日语学习日语学习日语学习日语学习</p>
        </div>
    </div>

</div>




<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<!--<script src="../vendors/moment/min/moment.min.js"></script>-->
<!--<script src="../vendors/fullcalendar/dist/fullcalendar.js"></script>-->
<!--<script src="../js/initVendors.js"></script>-->

<script>
    $(".task-view-list .view-item").on("click",function () {
        var imgUrl=$(this).find("img").attr("src");
        $("#view-pic-page .img-wrap img").attr("src",imgUrl);

        $("#data-head").attr("src",$(this).attr("data-head"));
        $("#data-name").html($(this).attr("data-name"));
        $("#data-time").html($(this).attr("data-time"));
        $("#data-title").html($(this).attr("data-title"));
        $("#data-detail").html($(this).attr("data-detail"));


        freshBigPicPosition();
        $(".global-cover-deeper").fadeIn(400);
        $("#view-pic-page").fadeIn(200);
    });

    $(".global-cover-deeper").on("click",function () {
        $(".global-cover-deeper").fadeOut();
        $("#view-pic-page").fadeOut();
    });

    function freshImgPosition() {
        $("#task-view-list .view-item").each(function () {
            var boxLen=170;
            var $img=$(this).find("img");
            var imgW=$img[0].width;
            var imgH=$img[0].height;
            if(imgW>imgH){
                $img.height(boxLen);
            }else{
                $img.width(boxLen);
            }
        });
    }

    function freshBigPicPosition() {
        var $wrap=$("#view-pic-page .img-wrap");
        var wrapW=$wrap.width();
        var wrapH=$wrap.height();
        var $img=$wrap.find("img");
        var imgW=$img[0].width;
        var imgH=$img[0].height;
        // console.log("wrapW",wrapW);
        // console.log("wrapH",wrapH);
        // console.log("imgW",imgW);
        // console.log("imgH",imgH);
        //scale
        if(imgH>wrapH){
            imgW=imgW*(wrapH/imgH);
            imgH=imgH*(wrapH/imgH);
        }
        if(imgW>wrapW){
            imgH=imgH*(wrapW/imgW);
            imgW=imgW*(wrapW/imgW);
        }
        $img.css({"width":imgW,"height":imgH});
        //position
        var _top=(wrapH-imgH)/2;
        var _left=(wrapW-imgW)/2;
        $img.css({"top":_top,"left":_left});


    }

    freshImgPosition();

</script>

</body>



</html>
