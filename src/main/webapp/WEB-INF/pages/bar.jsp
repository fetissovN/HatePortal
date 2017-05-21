<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>--%>
<%--<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bar</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/> ">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery_cookie.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/appInfoToolbar.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</head>
<body>
<div class="row">
<span style="float: right">
                <a href="?lang=en">en</a>
                |
                <a href="?lang=ru">ru</a>
</span>
</div>
<div class="off-canvas-content" data-off-canvas-content>
    <div class="nav-bar">
        <div class="nav-bar-left">
            <a style="margin-left: 50px" class="nav-bar-logo" href="/"><img class="logo" src="<c:url value="/resources/images/logo.png"/>"></a>
        </div>
        <div class="nav-bar-right">
            <ul class="menu">
                <li class="hide-for-small-only"><a href="#"><spring:message code="label.bar.feedback"/></a></li>
                <li class="hide-for-small-only"><a href="#"><spring:message code="label.bar.about"/></a></li>
                <li id="log" class="hide-for-small-only"><a href="/log/">
                    <c:choose>
                        <c:when test="${not empty sessionScope.get('auth')}">
                            <spring:message code="label.bar.logout"/>
                        </c:when>
                        <c:otherwise>
                            <spring:message code="label.bar.login"/>
                        </c:otherwise>
                    </c:choose></a></li>
                <li>
                <li>
                    <button id="toolBarInfo" class="offcanvas-trigger" type="button" data-open="offCanvasRight">
                        <span class="offcanvas-trigger-text hide-for-small-only">
                            <c:choose>
                            <c:when test="${ not empty sessionScope.get('auth')}">
                                ${sessionScope.get("auth").nickname}
                            </c:when>
                            <c:otherwise>
                                INF
                            </c:otherwise>
                        </c:choose></span>
                        <div class="hamburger">
                            <span class="line"></span>
                            <span class="line"></span>
                            <span class="line"></span>
                        </div>
                    </button>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="formB" class="formBar">

    <%--<div class="large-3 column"><!-- ... --></div>--%>
    <%--<div class="large-6 large-centered column"></div>--%>
    <%--<div class="large-3 column">--%>
        <%--<div class="translucent-form-overlay" style="float: right;">--%>
<%--<s:form method="post" commandName="barUserInfo" action="/post/post/comment/${post.id}">--%>
                <%--<h3><spring:message code="label.bar.droptitle"/></h3>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.nickname"/>--%>
                        <%--<s:input path="nickname"/>--%>
                            <%--&lt;%&ndash;<input type="text" name="keyword" placeholder="Any">&ndash;%&gt;--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.username"/>--%>
                        <%--<s:input path="username"/>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.surname"/>--%>
                        <%--<s:input path="surname"/>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.reg.email"/>--%>
                        <%--<s:input path="email"/>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.reg.phone"/>--%>
                        <%--<s:input path="phone"/>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.password"/>--%>
                        <%--<s:password path="password"/>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="row columns">--%>
                    <%--<label><spring:message code="label.password.check"/>--%>
                        <%--<s:password path="passwordCheck"/>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--&lt;%&ndash;<input class="button" type="submit" value="Ok"/>&ndash;%&gt;--%>
                <%--<button type="submit" class="primary button expanded search-button">--%>
                    <%--Ok--%>
                <%--</button>--%>
<%--</s:form>--%>
        <%--</div>--%>
    </div>
<%--</div>--%>
<%--<script src="/resources/js/vendor/jquery.js"></script>--%>
<script src="/resources/js/vendor/foundation.js"></script>
<script src="/resources/js/vendor/what-input.js"></script>
<%--<script>--%>
    <%--$('#submitInfo').click(function (e) {--%>
        <%--e.preventDefault();--%>
        <%--alert('test');--%>
        <%--ajaxSentInfoForm();--%>
    <%--});--%>
    <%--function ajaxSentInfoForm(){--%>

        <%--$.ajax({--%>
            <%--type: 'GET',--%>
            <%--url: '/infoCh',--%>
            <%--// data: {'s': term},--%>
            <%--success: function(data){--%>
                <%--alert(data);--%>
                <%--$('.translucent-form-overlay').remove();--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>

<%--</script>--%>

</body>
</html>
