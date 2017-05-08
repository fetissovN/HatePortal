<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><spring:message code="label.formName"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.css"/> ">
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="bar.jsp"/>
    <div class="row">
        <div class="large-4 column"><!-- ... --></div>
        <div class="large-4 large-centered column">
<s:form method="post" commandName="loginForm" action="login">
    <div align="center">
        <legend><spring:message code="label.formName"/></legend>
            <p align="inherit">

            </p>
            </div>
            <tr>
                <td><p><spring:message code="label.username"/></p></td>
                <td><s:input path="email"/></td>
                <td><span class="error"><s:errors path="email" /></span></td>
            </tr>
            <tr>
                <td><p><spring:message code="label.password"/></p></td>
                <td><s:password path="password"/></td>
                <td><span class="error"><s:errors path="password" /></span></td>
                <td><span class="error"><c:if test="${loginErr eq 'loginErr'}">
                    <spring:message code="label.login.error"/>
                </c:if></span></td>
            </tr>
            <%--<tr>--%>
                <%--<td>Remember me?</td>--%>
                <%--<td><input type="checkbox" name="remember" value="1"></td>--%>
            <%--</tr>--%>
            <tr>
                <td><input class="button" type="submit" value="Ok"/></td>
            </tr>
        </table>
</s:form>
<p><a style="text-underline: none" href="/reg/">Register if u aren't a bellend!</a></p>
        </div>
        <div class="large-4 columns"><!-- ... --></div>
    </div>


</body>
</html>
