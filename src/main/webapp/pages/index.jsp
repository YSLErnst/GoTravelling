<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/pages/include/header.html"%>
<!DOCTYPE html>
<html>
<head>
<%@ page pageEncoding="UTF-8"%>
<title>Insert title here</title>
</head>
<body>
首页！
<br/>
<sec:authorize ifAllGranted="ROLE_ADMIN" >
    <a href="/pages/admin.jsp">进入admin.jsp页面</a>
</sec:authorize>
<br/>
<a href="/j_spring_security_logout">退出系统</a>
<input type="button" value="打招呼" onclick="sayHelo()"/>
<input type="button" value="说拜拜" onclick="sayBye()"/>
<script>
    function sayHelo() {
        $.ajax({
            url: "user/hello",
            type: "GET",
            async: false,
            success: function(data) {
                alert("success:"+data);
            },
            error: function() {
                alert("error");
            }
        });
    }

    function sayBye() {
        $.ajax({
            url: "user/bye",
            type: "GET",
            async: false,
            success: function(data) {
                alert("success:"+data);
            },
            error: function() {
                alert("error");
            }
        });
    }
</script>
<p>All Rights Reserved By Ernst</p>
</body>
</html> 