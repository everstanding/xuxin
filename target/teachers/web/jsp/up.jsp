<%--
  Created by IntelliJ IDEA.
  User: YoungTree
  Date: 2017/11/14
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/up" METHOD="post" id="form_"  enctype='multipart/form-data'>
                <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <input id="exampleInputFile" name="pic" type="file" />
                </div>
                <button class="btn btn-default" type="submit" onclick="">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
function click_submit() {
    document.getElementById('form_').submit();
}

</script>
