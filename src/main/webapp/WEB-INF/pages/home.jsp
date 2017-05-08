<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Hate</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/> ">

</head>
<body>
<jsp:include page="bar.jsp"/>
<%--<h2>${sessionScope.get("auth").username}</h2>--%>
<%--<ul class="button-group round">--%>
    <%--<li><a href="/post/" class="button"><spring:message code="label.post.buttonIn"/></a></li>--%>
<%--</ul>--%>
<c:if test="${not empty postForm}">
    <div class="row">
        <div class="large-3 column"><!-- ... --></div>
        <div class="large-6 large-centered column">
            <s:form method="post" commandName="postForm" action="create">
                <div align="center">
                    <legend><spring:message code="label.post.post"/></legend>
                </div>
                <tr>
                    <td><p><spring:message code="label.post.title"/></p></td>
                    <td><s:input path="title"/></td>
                        <%--<td><span class="error"><s:errors path="email" /></span></td>--%>
                </tr>
                <tr>
                    <td><p><spring:message code="label.post.message"/></p></td>
                    <td><s:textarea path="post"/></td>
                        <%--<td><span class="error"><s:errors path="password" /></span></td>--%>
                        <%--<td><span class="error"><c:if test="${loginErr eq 'loginErr'}">--%>
                        <%--<spring:message code="label.login.error"/>--%>
                        <%--</c:if></span></td>--%>
                </tr>
                <tr>
                    <td><p><spring:message code="label.post.message"/></p></td>
                    <td><s:input path="photo" type="file" name="photo" accept="image/*"/></td>
                        <%--<td><span class="error"><s:errors path="password" /></span></td>--%>
                        <%--<td><span class="error"><c:if test="${loginErr eq 'loginErr'}">--%>
                        <%--<spring:message code="label.login.error"/>--%>
                        <%--</c:if></span></td>--%>
                </tr>
                <tr>
                    <td><input class="button" type="submit" value="Ok"/></td>
                </tr>
                </table>
            </s:form>

        </div>
        <div class="large-3 column"></div>
    </div>
</c:if>
<div class="row">
    <div class="large-2 column">
        <ul class="button-group round">
            <li><a href="/post/" class="button"><spring:message code="label.post.buttonIn"/></a></li>
        </ul>
    </div>
    <div class="large-10 column">
<div class="article-row-section">
    <div class="article-row-section-inner">

        <h2 class="article-row-section-header">Hate Posts</h2>
<c:forEach items="${posts}" var="postMain">
        <a href="<c:url value="/post/${postMain.id}"/>">
            <article class="article-row">
                <div class="article-row-img">
                    <img src="http://placehold.it/200" alt="picture of a whale eating a donkey" />
                </div>
                <div class="article-row-content">
                    <h1 class="article-row-content-header">${postMain.title}</h1>

                    <p class="article-row-content-description">${postMain.post}</p>

                    <p class="article-row-content-author">${postMain.userId.username}</p>
                    <time class="article-row-content-time" datetime="2008-02-14 20:00">${postMain.postDate}</time>
                </div>
            </article>
        </a>
</c:forEach>


    </div>
</div>
    </div>
    <%--<div class="large-1 column">asdasdasdasd</div>--%>
</div>


<div class="row">
    <div class="large-3 column"><!-- ... --></div>
    <div class="large-6 large-centered column">
        <table align="center" border="1">
            <tr>
        <c:forEach items="${posts}" var="post">
            <th>

            </th>
        </c:forEach>
            </tr>
        </table>
    </div>
    <div class="large-3 column"></div>
</div>
</body>
</html>
