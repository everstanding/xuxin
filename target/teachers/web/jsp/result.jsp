<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/24
  Time: 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>修改成功</title>

    <!---------css----------->
    <link href="/web/css/bootstrap.min.css" rel="stylesheet">
    <link href="/web/css/global.css" rel="stylesheet">

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

        .success-panel {
            display: block;
            position: relative;
            margin: 20px auto;
            margin-top: 120px;
            width: 420px;
            padding: 20px 20px;
            background-color: #fff;
            box-shadow: 0 -5px 20px #ddd, /*top*/
            0 5px 20px #ddd, /*bottom*/
            -5px 0 20px #ddd, /*left*/
            5px 0 20px #ddd;
            /*right*/
        }

        .success-panel p {
            display: block;
            width: 100%;
            margin: 20px auto;
            text-align: center;
            font-size: 16px;
            font-weight: 700;
            letter-spacing: 2px;
            color: #555;
        }

        .success-panel button {
            display: block;
            margin: 10px auto;
            border: none;
            background-color: #37BC9B;
            color: #fff;
            font-size: 14px;
            transition: background-color 0.4s;
            -moz-transition: background-color 0.4s;
            -webkit-transition: background-color 0.4s;
            -o-transition: background-color 0.4s;
            letter-spacing: 4px;
        }

        .success-panel button:hover {
            background-color: #48CFAD;
        }

        .success-panel button a {
            display: block;
            padding: 5px 10px;
            text-decoration: none;
            color: #fff;
        }

        .success-panel button a:hover {
            color: #fff;
        }

    </style>

</head>

<body>



<div id="container-wrap">
    <div class="success-panel">
        <p class="title">${msg}</p>
        <button type="button" class="submit" id="back-button"><a href="${url}">返回</a></button>
    </div>


</div>



<!----------js------------>
<script src="/web/js/jquery-3.1.1.min.js"></script>
<script src="/web/js/bootstrap.min.js"></script>

<script>


</script>

</body>



</html>

