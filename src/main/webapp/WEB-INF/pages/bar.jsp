<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bar</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/> ">

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
                <li class="hide-for-small-only"><a href="/log/">
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
                    <button class="offcanvas-trigger" type="button" data-open="offCanvasRight">
                        <span class="offcanvas-trigger-text hide-for-small-only"><c:choose>
                            <c:when test="${ not empty sessionScope.get('auth')}">
                                ${sessionScope.get("auth").username}
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

<script src="/resources/js/vendor/jquery.js"></script>
<script src="/resources/js/vendor/foundation.js"></script>
<script src="/resources/js/vendor/what-input.js"></script>
<%--<script src="/resources/js/vendor/app.js"></script>--%>

</body>
</html>
