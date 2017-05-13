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
<div class="row">
    <div class="large-12 column">
        <article class="article-row">
            <div class="article-row-img">
                <img src="http://placehold.it/200" alt="picture of a whale eating a donkey" />
            </div>
            <div class="article-row-content">
                <h1 class="article-row-content-header">${post.title}</h1>

                <p class="article-row-content-description">${post.post}</p>

                <p class="article-row-content-author">${post.userId.username}</p>
                <time class="article-row-content-time" datetime="2008-02-14 20:00">${post.postDate}</time>
            </div>
        </article>
        <div class="row">
            <div class="large-3 column"></div>
                <div class="large-6 large-centered column">
                    <h5><spring:message code="label.post.comment"/></h5>
                        <s:form method="post" commandName="messagePost" action="comment/${post.id}">
                            <tr>
                                <td><p><spring:message code="label.message"/></p></td>
                                <td><s:input path="message"/></td>
                                <td><span class="error"><s:errors path="message" /></span></td>
                            </tr>
                            <tr>
                                <td><input class="button" type="submit" value="Ok"/></td>
                            </tr>
                        </s:form>
                    <c:forEach items="${messages}" var="message">
                        <!-- comments -->
                        <div class="comment-section-container">
                            <div class="comment-section-author">
                                <%--<img src="http://placehold.it/50x50" alt="">--%>
                                <div class="comment-section-name">
                                    <h5><a href="">${message.user_id.username}</a></h5>
                                    <p>${message.message_date}</p>
                                </div>
                            </div>
                            <div class="comment-section-text">
                                <p>${message.message}</p>
                            </div>
                        </div>

                    </c:forEach>
                </div>
                    <div class="large-3 column"></div>
        </div>
    </div>
</div>

</body>
</html>
