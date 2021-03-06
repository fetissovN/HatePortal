<%@ page import="com.nick.hateportal.DTO.UserDTO" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Hate</title>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="bar.jsp"/>
    <div class="row">
        <div class="large-3 column">

        </div>
        <div class="large-6 large-centered column">
            <s:form id="form" cssStyle="display: none" method="post" commandName="postForm" action="/post/create">
                <div align="center">
                    <legend><spring:message code="label.post.post"/></legend>
                </div>
                <tr>
                    <td><p><spring:message code="label.post.title"/></p></td>
                    <td><s:input path="title"/></td>
                    <td><span class="error"><s:errors path="title" /></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.post.target"/></p></td>
                    <td><s:input path="target"/></td>
                    <td><span class="error"><s:errors path="target" /></span></td>
                </tr>
                <tr>
                    <td><p><spring:message code="label.post.message"/></p></td>
                    <td><s:textarea path="post"/></td>
                    <td><span class="error"><s:errors path="post" /></span></td>
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
                    <td><input id="submitForm" class="button" type="submit" value="Ok"/></td>
                    <td><button style="float: right" id="closePostForm" class="button" type="button"><spring:message code="label.post.later"/></button></td>
                </tr>
                </table>
            </s:form>

        </div>
        <div class="large-3 column"></div>
    </div>
<div class="row">
    <div class="large-2 column">
        <ul class="button-group round">
            <li><button id="postForm" class="button"><spring:message code="label.post.buttonIn"/></button></li>
        </ul>
    </div>
    <div class="large-10 column">
<div class="article-row-section">
    <div class="article-row-section-inner">
        <h2 class="article-row-section-header"><spring:message code="label.main.posts"/></h2>
<c:forEach items="${posts}" var="postMain">
        <a href="<c:url value="post/post/${postMain.id}"/>">
            <article class="article-row">
                <div class="article-row-img">
                    <img src="http://placehold.it/200" alt="picture of a whale eating a donkey" />
                </div>
                <div class="article-row-content">
                    <h1 class="article-row-content-header">${postMain.title}</h1>

                    <p class="article-row-content-description">${postMain.post}</p>

                    <p class="article-row-content-author">${postMain.userId.username}</p>
                    <time class="article-row-content-time" datetime="2008-02-14 20:00">${postMain.postDate}</time>
                    <p id="likeTag" class="article-row-content-author">
                        Likes: ${postMain.like}
                        <a id="like" href="/post/like/${postMain.id}"><img class="logo" src="<c:url value="/resources/images/like-512.png"/>"></a>
                    </p>
                    <p class="article-row-content-author">
                        <c:if test="${sessionScope.get('auth').role eq 0}">
                            <a style="color: #cc8b00" id="adminDel" href="/post/delete/${postMain.id}">delete</a>
                        </c:if>
                    </p>
                </div>
            </article>
        </a>
</c:forEach>
        <ul class="button-group round">
            <li><button id="ajaxLoadPosts" name="0" class="button"><spring:message code="label.post.load"/></button></li>
        </ul>
        <div class="loadedPostsPlaceholder0"></div>
    </div>
</div>
    </div>
</div>

</body>
</html>
