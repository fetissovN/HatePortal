<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
