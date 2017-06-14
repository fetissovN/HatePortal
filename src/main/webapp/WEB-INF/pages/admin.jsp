<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin.app.css"/> ">
    <script type="text/javascript" src="<c:url value="/resources/js/admin.app.js"/>"></script>

</head>
<body>
<a style="margin-left: 100px" href="/admin/reload"><img class="logo" src="<c:url value="/resources/images/reload.png"/>"></a>

<div class="row">
    <div class="large-8 column" style="border-right: 1px solid black; position: inherit">
        <a href="/admin?n=1"><button type="button" class="button">Id down</button></a>
        <a href="/admin?n=2"><button type="button" class="button">Id up</button></a>
        <a href="/admin?n=3"><button type="button" class="button">Rate down</button></a>
        <a href="/admin?n=4"><button type="button" class="button">Rate up</button></a>
        <table>
            <table style="font-size: xx-small; margin-right: 20px" cellpadding="4" cellspacing="1">
                <p>Total users: ${countUsers}</p><tr><th>Id</th><th>Nickname</th><th>Username</th><th>Surname</th><th>Email</th><th>Phone</th><th>Rate</th></tr>
                <c:forEach items="${list}" var="user">
                    <tr>
                        <td><a href="/admin/userPosts${user.id}">${user.id}</a></td>
                        <td>${user.nickname}</td>
                        <td>${user.username}</td>
                        <td>${user.surname}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.rate}</td>
                    </tr>
                </c:forEach>

            </table>
        </table>
    </div>
    <div class="large-4 column">
        <a href="/admin?p=5"><button style="padding: 5px" type="button" class="button">Id down</button></a>
        <a href="/admin?p=6"><button style="padding: 5px" type="button" class="button">Id up</button></a>
        <a href="/admin?p=7"><button style="padding: 5px" type="button" class="button">Date down</button></a>
        <a href="/admin?p=8"><button style="padding: 5px" type="button" class="button">Date up</button></a>
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
</div>
</body>
</html>
