<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="postAdminAjax">
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
