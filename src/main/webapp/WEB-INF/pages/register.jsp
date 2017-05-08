<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.reg.reg"/></title>
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

    <div class="large-3 column"><!-- ... --></div>
    <div class="large-6 large-centered column">
        <s:form method="post" commandName="regForm" action="do.reg">
            <div align="center">
                <legend><spring:message code="label.reg.reg"/></legend>
                <p align="center">
                </p>
            </div>
            <table>
                <tr>
                    <td><p><spring:message code="label.username"/></p></td>
                    <td><s:input path="username"/></td>
                    <td><span class="error"><s:errors path="username" /></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.surname"/></p></td>
                    <td><s:input path="surname"/></td>
                    <td><span class="error"><s:errors path="surname" /></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.reg.email"/></p></td>
                    <td><s:input path="email"/></td>
                    <td><span class="error"><s:errors path="email" /></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.reg.phone"/></p></td>
                    <td><s:input path="phone"/></td>
                    <td><span class="error"><s:errors path="phone"/></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.password"/></p></td>
                    <td><s:password path="password"/></td>
                    <td><span class="error"><s:errors path="password" /></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.password.check"/></p></td>
                    <td><s:password path="passwordCheck"/></td>
                    <td><span class="error"><s:errors
                            path="passwordCheck" /></span></td>
                </tr>
                <tr>
                    <td><input class="button" type="submit" value="Ok"/></td>
                    <td><span class="error"><c:if test="${userExist eq 'Exist'}">
                        <spring:message code="label.reg.userExist"/>
                    </c:if> </span></td>
                </tr>
            </table>
        </s:form>
    </div>
    <div class="large-3 columns"><!-- ... --></div>
</div>


</body>
</html>
