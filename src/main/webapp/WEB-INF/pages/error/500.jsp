<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404 Error page</title>
    <link href="<c:url value="/resources/css/app.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/foundation.min.css"/>" type="text/css" rel="stylesheet">
    <%--<link href="<c:url value="/resources/css/app.css"/>" type="text/css" rel="stylesheet">--%>
</head>

<body>
<jsp:include page="bar.jsp"/>
<div class="error-div">
    <div class="large-3 column"><!-- ... --></div>
    <div class="large-6 large-centered column">

        <br/><br/>
        <h1 align="center">Something went wrong! Code 500</h1><br/>
        <p align="center">
            <img class="logo" src="<c:url value="/resources/images/kcMb77n6i.png"/>">
            <br/><br/>
            <button type="button" name="back" onclick="history.back()">back</button>
        </p>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

    </div>
    <div class="large-3 column"><!-- ... --></div>
</div>


</body>
</html>
