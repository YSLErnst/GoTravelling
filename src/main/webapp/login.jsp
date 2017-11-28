<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ include file="/pages/include/header.html"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="container">
    <div id="content">
        <div class="span-24 last">
            <h3>
                用户登录
            </h3>
            ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
            <div class="error">
                ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }
            </div>
            <form id="loginForm" style="margin-top: 1em;"
                  action="${pageContext.request.contextPath}/j_spring_security_check"method="POST">
            <table class="noborder">
                <tr>
                    <td>
                        <label>
                            用户名:
                        </label>
                    </td>
                    <td>
                        <input type="text" name="j_username" class="required" />
                    </td>
                    <td rowspan="3">
                        <img id="captchaImg" src="<c:url value="/jcaptcha.jpg"/>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            密码:
                        </label>
                    </td>
                    <td>
                        <input type="password" name="j_password" class="required">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            验证码:
                        </label>
                    </td>
                    <td>
                        <input type='text' name='j_captcha' class="required" size='5' />
                    </td>
                </tr>
                <tr>
                    <td colspan='3'>
                        <input type="checkbox" name="_spring_security_remember_me" />
                        两周内记住我
									<span style="margin-left: 25px"><a
                                            href="javascript:refreshCaptcha()">看不清楚换一张</a>
									</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" class="button" value="登录">
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function refreshCaptcha() {
        $('#captchaImg').hide().attr(
                'src',
                '<c:url value="/jcaptcha.jpg"/>' + '?' + Math
                        .floor(Math.random() * 100)).fadeIn();
    }
</script>

</html>
