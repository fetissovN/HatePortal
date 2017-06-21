<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="postAdminAjax">
        <c:choose>
            <c:when test="${postOfUser=='true'}">
                <a class="postLinkMethod" href="/admin?p=5&user=${listPosts.get(0).userId.id}"><button type="button" class="button">Id down</button></a>
                <a class="postLinkMethod" href="/admin?p=6&user=${listPosts.get(0).userId.id}"><button type="button" class="button">Id up</button></a>
                <a class="postLinkMethod" href="/admin?p=7&user=${listPosts.get(0).userId.id}"><button type="button" class="button">Date down</button></a>
                <a class="postLinkMethod" href="/admin?p=8&user=${listPosts.get(0).userId.id}"><button type="button" class="button">Date up</button></a>
            </c:when>
            <c:otherwise>
                <a class="postLinkMethod" href="/admin?p=5"><button type="button" class="button">Id down</button></a>
                <a class="postLinkMethod" href="/admin?p=6"><button type="button" class="button">Id up</button></a>
                <a class="postLinkMethod" href="/admin?p=7"><button type="button" class="button">Date down</button></a>
                <a class="postLinkMethod" href="/admin?p=8"><button type="button" class="button">Date up</button></a>
            </c:otherwise>
        </c:choose>
        <p>Posts amount: ${countPosts}</p>
        <c:forEach items="${listPosts}" var="post">
            <tr>
                <td>Id: ${post.id}</td><br>
                <td>Place: ${post.target}</td><br>
                <td>${post.post}</td><br>
                <td>Date: ${post.postDate}</td><br>
                <td>Likes: ${post.like}</td><br>
                <td><a id="adminLinkToPost" href="/post/post/${post.id}">Messages: ${post.postRelatedMessages.size()}</a></td><br>
            </tr>
            <hr>
        </c:forEach>
    </div>
