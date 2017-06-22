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
                <p class="article-row-content-author">${post.target}</p>
                <p class="article-row-content-description">${post.post}</p>
                <p class="article-row-content-author">${post.userId.username}</p>
                <p id="likeTag" class="article-row-content-author">
                    Likes: ${post.like}
                    <a id="like" href="/post/like/${post.id}"><img class="logo" src="<c:url value="/resources/images/like-512.png"/>"></a>
                </p>
                <time class="article-row-content-time" datetime="2008-02-14 20:00">${post.postDate}</time>
                <p class="article-row-content-author">
                    <c:if test="${sessionScope.get('auth').role eq 0}">
                        <a style="color: #cc8b00" id="adminDel" href="/post/delete/${post.id}">delete</a>
                        <a style="color: darkblue" id="adminUpd" href="/post/updateShow/${post.id}">update</a>
                    </c:if>
                </p>
            </div>
        </article>
        <div id="updatePost"></div>
        <div class="row">
            <div class="large-3 column"></div>
                <div class="large-6 large-centered column">
                    <h5><spring:message code="label.post.comment"/></h5>
                        <s:form method="post" commandName="messagePost" action="/post/post/comment/${post.id}">
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
                                <p id="updMessPlace${message.id}"></p>
                                <p id="mess${message.id}" class="mess">${message.message}</p>
                            </div>
                            <div class="comment-section-text">
                                <p id="likeMessage" class="article-row-content-author">
                                    Likes: ${message.like}
                                    <a id="likeMessLink" href="/post/message/like/${message.id}"><img class="logo" src="<c:url value="/resources/images/like-512.png"/>"></a>
                                </p>
                                <c:if test="${sessionScope.get('auth').role eq 1}">
                                    <c:if test="${sessionScope.get('auth').id eq message.user_id.id}">
                                        <a style="color: #cc8b00" id="adminDel" href="/post/message/delete/${message.id}/${post.id}">delete</a>
                                        <a class="updMess" style="color: darkblue" id="adminMessUpdate${message.id}" href="/post/message/updateShow/${message.id}">update</a>
                                    </c:if>
                                </c:if>
                                <c:if test="${sessionScope.get('auth').role eq 0}">
                                    <a style="color: #cc8b00" id="adminDel" href="/post/message/delete/${message.id}/${post.id}">delete</a>
                                    <a style="color: darkblue" class="updMess" id="adminMessUpdate" href="/post/message/updateShow/${message.id}">update</a>
                                </c:if>
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
