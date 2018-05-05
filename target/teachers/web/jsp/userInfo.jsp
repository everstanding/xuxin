<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>用户信息</title>

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
                <p>个人信息</p>
            </div>

            <!--------user-info-------->
            <div id="user-info-panel">

                <ul class="info-list">
                    <li class="name">
                        <p class="title">姓名</p>
                        <p class="value">${user.uName}</p>
                    </li>
                    <li class="gender">
                        <p class="title">性别</p>
                        <p class="value">${user.uGender}</p>
                    </li>
                    <li class="stu-no">
                        <p class="title">学号</p>
                        <p class="value">${user.uSchoolNum}</p>
                    </li>
                    <li class="qq">
                        <p class="title">QQ</p>
                        <p class="value">${user.uQq}</p>
                    </li>
                    <li class="wx">
                        <p class="title">微信</p>
                        <p class="value">${user.uWx}</p>
                    </li>
                    <li class="phone">
                        <p class="title">电话</p>
                        <p class="value">${user.uPhone}</p>
                    </li>

                </ul>
                <button type="button" class="change">修改</button>

            </div>
            <!--------/user-info-------->

            <!--------/chenge-user-info-------->
            <div id="change-panel-user-info" class="change-panel">
                <form action="/young/change_user_info" method="post" id="change_info_form">
                    <div class="input-bar name">
                        <p>姓名</p>
                        <input name="uName" type="text" onkeypress="return event.keyCode!=32" value="${user.uName}" data-toggle="tooltip" data-placement="right" title="用户名不包括空格，不超过10个字符">
                    </div>
                    <input id="uGender1" name="uGender" hidden="hidden" value="">
                    <div class="input-bar gender">
                        <p>性别</p>
                        <div class="gender-radio" id="radio">
                            <label class="radio-inline">
                                <input type="radio" name="inlineRadioOptions" id="radio-male" value="1" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="inlineRadioOptions" id="radio-female" value="2"> 女
                            </label>
                        </div>
                    </div>
                    <div class="input-bar stu-no">
                        <p>学号</p>
                        <input type="text" value="${user.uSchoolNum}" name="uSchoolNum">
                    </div>
                    <div class="input-bar qq">
                        <p>QQ</p>
                        <input type="text" value="${user.uQq}" name="uQq">
                    </div>
                    <div class="input-bar wx">
                        <p>微信</p>
                        <input type="text" value="${user.uWx}" name="uWx">
                    </div>
                    <div class="input-bar phone">
                        <p>电话</p>
                        <input name="uPhone" type="text" onkeypress="return event.keyCode>=48&&event.keyCode<=57" data-toggle="tooltip" data-placement="right" title="请输入手机号" value="${user.uPhone}">
                    </div>
                    <button type="button" class="save" onclick="sub_f()">保存</button>
                </form>
            </div>
            <!--------/chenge-user-info-------->

        </div>


    </div>

</div>

<footer>
    <%@ include file="footer.jsp" %>
</footer>


<!----------js------------>
<script src="${pageContext.request.contextPath}/web/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function() {
        //leftbar act
        $("#left-bar").find(".info").addClass("act").siblings().removeClass("act");
        //$("#left-bar .nav .info").addClass("act").siblings().removeClass("act");
        //显示初始页面
        $("#change-panel-user-info").hide();
        $("#user-info-panel").show();

    });


    //click change
    $("#user-info-panel button.change").on("click", function() {
        console.log("click change");
        //            var $infoList = $("#user-info-panel .info-list"),
        //                $changePanel = $("#change-panel-user-info"),
        //                $infoPanel = $("#user-info-panel");
        //            var uName = $infoPanel.find(".name .value").html(),
        //                uPhone = $infoPanel.find(".phone .value").html(),
        //                uMail = $infoPanel.find(".mail .value").html(),
        //                uGender = $infoPanel.find(".gender .value").html();
        //            //set data
        //            $changePanel.find(".name input").val(uName);
        //            $changePanel.find(".phone input").val(uPhone);
        //            $changePanel.find(".mail input").val(uMail);
        //            console.log("change user gender:" + uGender);
        //            if (uGender == "男") {
        //                $changePanel.find(".gender-radio").find("input#radio-male").attr("checked", "checked");
        //                $changePanel.find(".gender-radio").find("input#radio-female").removeAttr("checked");
        //            } else if (uGender == "女") {
        //                $changePanel.find(".gender-radio").find("input#radio-female").attr("checked", "checked");
        //                $changePanel.find(".gender-radio").find("input#radio-male").removeAttr("checked");
        //            } else {
        //                console.log("user gender error");
        //            }
        $("#user-info-panel").hide();
        $("#change-panel-user-info").show();
    });

    //save changes
    $("#change-panel-user-info button.save").on("click", function() {
        console.log("save change");
        //            var $panel = $("#change-panel-user-info");
        //            var uName = $panel.find(".name input").val(),
        //                uPhone = $panel.find(".phone input").val(),
        //                uMail = $panel.find(".mail input").val(),
        //                uGender = $panel.find(".gender input[type='radio']:checked").val();
        //            var nameLen = uName.length;
        //            var nameLegal = (nameLen > 0) && (nameLen <= 10); //用户名合法性
        //            var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/;
        //            var phoneLegal = phoneReg.test(uPhone); //手机号合法性
        //            //邮箱：A@B形式，A包括字母、数字、下划线、短横杠，B部分为xx.yy或xx.yy.zz形式
        //            var mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        //            var mailLegal = mailReg.test(uMail); //邮箱地址合法性
        //            if (nameLegal && phoneLegal && mailLegal) {
        //                $.ajax({
        //                    type: "post",
        //                    async: true,
        //                    dataType: "json", //收受数据格式
        //                    traditional: true,
        //                    url: "${pageContext.request.contextPath}/user/change_info",
        //                    cache: false,
        //                    data: {
        //                        "u_name": uName,
        //                        "u_phone": uPhone,
        //                        "u_email": uMail,
        //                        "u_gender": uGender
        //                    },
        //                    success: function(data) {
        //                        if (data.errno == 0001) {
        //                            $("#change-user-info-modal-to-info .error-message").html("修改成功");
        //                            $("#change-user-info-modal-to-info").modal();
        //                        } else if (data.errno == 0002) {
        //                            $("#change-user-info-modal .error-message").html("邮箱已被注册");
        //                            $("#change-user-info-modal").modal();
        //                        } else if (data.errno == 0003) {
        //                            $("#change-user-info-modal .error-message").html("手机号已被注册");
        //                            $("#change-user-info-modal").modal();
        //                        } else if (data.errno == 0004) {
        //                            $("#change-user-info-modal .error-message").html("服务器异常");
        //                            $("#change-user-info-modal").modal();
        //                            console.log("errno:" + data.errno);
        //                        } else if (data.errno == 1010) {
        //                            console.log("not login");
        //                            $("#global-modal-not-login").modal();
        //                        } else {
        //                            $("#change-user-info-modal .error-message").html("服务器异常");
        //                            $("#change-user-info-modal").modal();
        //                            console.log("errno:" + data.errno);
        //                        }
        //                    },
        //                    fail: function() {
        //                        console.log("ajax fail");
        //                        $("#change-user-info-modal .error-message").html("服务器异常");
        //                        $("#change-user-info-modal").modal();
        //                    }
        //
        //                }); //ajax over
        //
        //
        //
        //            } else {
        //                console.log("someting wrong");
        //                var errorM = "以下未正确填写："
        //                if (!nameLegal) {
        //                    console.log("not legal name");
        //                    errorM += "用户名 "
        //                }
        //                if (!phoneLegal) {
        //                    console.log("not legal name");
        //                    errorM += "联系电话 "
        //                }
        //                if (!mailLegal) {
        //                    console.log("not legal name");
        //                    errorM += "电子邮箱 "
        //                }
        //                $("#change-user-info-modal .error-message").html(errorM);
        //                $("#change-user-info-modal").modal();
        //            }

    });

    //save change success,to info panel(refresh)
    $("#change-user-info-modal-to-info").on("hidden.bs.modal", function() {
        //            loadUserInfo();
        $("#change-panel-user-info").hide();
        $("#user-info-panel").show();
    });

    function sub_f() {
        if($("#radio").find(".radio-inline input[type='radio']:checked").val()==1){
            $("#uGender1").val('男');
        }else{
            $("#uGender1").val('女');
        }
        $("#change_info_form").submit();
    }
    
    
    
</script>

</body>



</html>
