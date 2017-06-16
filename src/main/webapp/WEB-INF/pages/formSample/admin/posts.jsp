<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="postAdminAjax">
        <c:choose>
            <c:when test="${postOfUser=='true'}">
                <a id="postIdDown" href="/admin?p=5&user=${listPosts.get(0).userId.id}"><button style="padding: 5px" type="button" class="button">Id down</button></a>
                <a id="postIdUp" href="/admin?p=6&user=${listPosts.get(0).userId.id}"><button style="padding: 5px" type="button" class="button">Id up</button></a>
                <a id="postDateDown" href="/admin?p=7&user=${listPosts.get(0).userId.id}"><button style="padding: 5px" type="button" class="button">Date down</button></a>
                <a id="postDateUp" href="/admin?p=8&user=${listPosts.get(0).userId.id}"><button style="padding: 5px" type="button" class="button">Date up</button></a>
            </c:when>
            <c:otherwise>
                <a id="postIdDown" href="/admin?p=5"><button style="padding: 5px" type="button" class="button">Id down</button></a>
                <a id="postIdUp" href="/admin?p=6"><button style="padding: 5px" type="button" class="button">Id up</button></a>
                <a id="postDateDown" href="/admin?p=7"><button style="padding: 5px" type="button" class="button">Date down</button></a>
                <a id="postDateUp" href="/admin?p=8"><button style="padding: 5px" type="button" class="button">Date up</button></a>
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
