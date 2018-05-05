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
    <title>队员日历</title>

    <!---------css----------->
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/css/calendar.css" rel="stylesheet">

    <!-- FullCalendar -->
    <link href="${pageContext.request.contextPath}/web/vendors/fullcalendar/dist/fullcalendar.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/web/vendors/fullcalendar/dist/fullcalendar.print.css" rel="stylesheet" media="print">

    <!--pic upload-->
    <link href="${pageContext.request.contextPath}/web/vendors/bootstrap-fileinput.css" rel="stylesheet">

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
            <li><a href="/team/${tid}/2/album" >查看</a></li>
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

    <div id="calendar-modal-submit" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">提交任务</h4>
                </div>
                <div class="modal-body">
                    <div style="padding: 5px 20px;">
                        <div class="task-info">
                            <div class="info-row">
                                <p class="title">标题</p>
                                <p class="detail" id="task_title"></p>
                            </div>
                            <div class="info-row">
                                <p class="title">描述</p>
                                <p class="detail" id="task_detail"></p>
                            </div>
                        </div>
                        <form id="calendar-submit-form">
                            <ul id="task-submit-list">

                                <li class="submit-item">
                                    <div class="item-cover">
                                        <div class="view-more"></div>
                                        <div class="delete-item"></div>
                                    </div>
                                    <img src="${pageContext.request.contextPath}/web/images/bg.jpg"/>
                                </li>
                                <li class="submit-item">
                                    <div class="item-cover">
                                        <div class="view-more"></div>
                                        <div class="delete-item"></div>
                                    </div>
                                    <img src="${pageContext.request.contextPath}/web/images/portrait.jpg"/>
                                </li>
                                <li class="submit-item">
                                    <div class="item-cover">
                                        <div class="view-more"></div>
                                        <div class="delete-item"></div>
                                    </div>
                                    <img src="${pageContext.request.contextPath}/web/images/icon-qq-blue.png"/>
                                </li>
                                <li class="submit-item">
                                    <div class="item-cover">
                                        <div class="view-more"></div>
                                        <div class="delete-item"></div>
                                    </div>
                                    <img src="${pageContext.request.contextPath}/web/images/portrait.jpg"/>
                                </li>
                                <li class="submit-add-item">
                                    <div id="add-pic-item" class="icon"></div>
                                </li>
                            </ul>


                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <div id="fc_create" data-toggle="modal" data-target="#CalenderModalNew"></div>
    <!-- /calendar modal -->

    <div class="global-cover"></div>

    <div id="upload-pic">
        <form id="up_pic_form" action="/team/add_task_query" enctype='multipart/form-data' method="post">
            <input type="text" id="task_id"  hidden="hidden" name="task_id">
            <input type="text" id="team_id"  hidden="hidden" name="team_id" value="${tid}">
        <div class="select-row">
            <p class="title" style="letter-spacing: 5px;text-align: center">描述</p>
            <input name="ut_detail" type="text" id="item-title-input" class="global-input" style="z-index: 9999"/>
        </div>

        <div class="page-header" style="margin-left: 20px">
            <h3 style="font-size:18px;padding-left: 5px">课程图片上传</h3>
            <form>

                <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                    <div class="fileinput fileinput-new" data-provides="fileinput" id="exampleInputUpload">
                        <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                            <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="${pageContext.request.contextPath}/web/images/noimage.png" alt="" />
                        </div>
                        <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                        <div style="margin-top:10px">
                                                    <span class="btn btn-primary btn-file">
                                                    <span class="fileinput-new" style="cursor: pointer">选择文件</span>
                                                    <span class="fileinput-exists">换一张</span>
                                                    <input type="file" name="pic1" id="picID" accept="${pageContext.request.contextPath}/web/image/gif,image/jpeg,image/x-png" />
                                                    </span>
                            <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        </form>
        <div class="upload-pic-footer">
            <button id="save-item-detail" onclick="a()">保存</button>
            <button class="dismiss-upload">取消</button>
        </div>


    </div>

</div>




<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<!-- FullCalendar -->
<script src="${pageContext.request.contextPath}/web/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/web/vendors/fullcalendar/dist/fullcalendar.js"></script>
<script src="${pageContext.request.contextPath}/web/js/initVendors.js"></script>

<!--pic upload-->
<script src="${pageContext.request.contextPath}/web/vendors/bootstrap-fileinput.js"></script>

<script>

    function a() {
        $("#up_pic_form").submit();
    }
    // var imgPositionFreshed=false;
    //click grid

    $(".fc-day").each(function (value) {
        <c:forEach items="${tasks}" var="task"   >
        if($(this).attr("data-date")==="${task.task_date_String}"){
            $(this).addClass("fc-bgevent");
            $(this).attr("data-id","${task.task_id}");
            console.log("add class");
        }
        </c:forEach>

    });

    $(".fc-day").on("click",function () {
        if($(this).attr("data-id")!=undefined){
            $("#calendar-modal-submit").modal();
            $("#task_id").val($(this).attr("data-id"));
            get_task_info_by_task_id($(this).attr("data-id"));
        }

    });

    $(".dismiss-upload").on("click",function () {
        $("#upload-pic").fadeOut();
        $(".global-cover").fadeOut();
    });

    //click add item
    $("#add-pic-item").on("click",function (e) {
        console.log("click add item");
        $("#picImg").attr("src","${pageContext.request.contextPath}/web/images/noimage.png");//无图片
        $("#item-title-input").val("");
        $("#upload-pic").fadeIn();
        $(".global-cover").fadeIn();
    });

    //click view item
    $(".submit-item .view-more").on("click",function () {
        var imgUrl=$(this).parents(".submit-item").find("img").attr("src");
        console.log("src",imgUrl);
        $("#picImg").attr("src",imgUrl);
        $("#upload-pic").fadeIn();
        $(".global-cover").fadeIn();
        $("#item-title-input").val("123");
    });



    function freshImgPosition() {
        $("#task-submit-list .submit-item").each(function () {
            var boxLen=100;
            var $img=$(this).find("img");
            // setTimeout(function () {
            var imgW=$img[0].width;
            var imgH=$img[0].height;
            // console.log("imgW",imgW);
            // console.log("imgH",imgH);
            if(imgW>imgH){
                $img.height(boxLen);
                // console.log("set by hei");
            }else{
                $img.width(boxLen);
                // console.log("set by wid");
            }
            // },500);

        });
    }

    freshImgPosition();

    function get_task_info_by_task_id(task_id){
        $.ajax({
            type: "post",
            async: true,
            dataType: "json", //收受数据格式
            traditional: true,
            url: "${pageContext.request.contextPath}/team/user_get_task",
            cache: false,
            data: {
                "task_id":task_id
            },
            success: function (data) {
                var pic_html = '' ;

                var len=data.obj.querys.length;
                for(var i=0;i<len;i++){
                    var jsonData=data.obj.querys[i];
                    pic_html+=' <li class="submit-item" >' +
                        '                                    <div class="item-cover">' +
                        '                                        <div class="view-more"></div>' +
                        '                                        <div class="delete-item"></div>' +
                        '                                    </div>' +
                        '                                    <img src="${pageContext.request.contextPath}'+jsonData.utPicUrl+'"/>' +
                        '                                </li>'
                }

                pic_html+=' <li class="submit-add-item">' +
                    '                                    <div id="add-pic-item" class="icon"></div>' +
                    '                                </li>';

                $("#task-submit-list").empty();
                $("#task-submit-list").append(pic_html);

                //click add item
                $("#add-pic-item").on("click",function (e) {
                    console.log("click add item");
                    $("#picImg").attr("src","${pageContext.request.contextPath}/web/images/noimage.png");//无图片
                    $("#item-title-input").val("");
                    $("#upload-pic").fadeIn();
                    $(".global-cover").fadeIn();
                });

                $("#task_title").empty();
                $("#task_title").append(data.obj.task.taskTitle);

                $("#task_detail").empty();
                $("#task_detail").append(data.obj.task.taskDetail);





            }
        }); //ajax over
    }



</script>

</body>



</html>
