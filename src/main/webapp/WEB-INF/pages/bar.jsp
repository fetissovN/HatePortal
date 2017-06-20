<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="<c:url value="/resources/js/feedback.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/postUpdate.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/messageUpdate.js"/>"></script>

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

            <c:if test="${sessionScope.get('auth').role eq 0}">
                <a style="margin-left: 50px" class="nav-bar-logo" href="/admin/">Admin</a>
            </c:if>
        </div>
        <div class="nav-bar-right">
            <ul class="menu">
                <li id="feedback" class="hide-for-small-only"><a href="#"><spring:message code="label.bar.feedback"/></a></li>
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
                                <spring:message code="label.bar.inf"/>
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
<div id="formFeed" class="formFeed"></div>
<div id="formB" class="formBar"></div>
<script src="/resources/js/vendor/foundation.js"></script>
<script src="/resources/js/vendor/what-input.js"></script>
</body>
</html>
