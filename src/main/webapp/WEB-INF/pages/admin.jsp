<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/> ">

</head>
<body>
<div class="row">
    <div class="large-6 column">
        <button><a href="/admin/"></a></button>
        <table>
            <table style="font-size: xx-small" cellpadding="4" cellspacing="1">
                <tr><th>Id</th><th>Nickname</th><th>Username</th><th>Surname</th><th>Email</th><th>Phone</th><th>Rate</th></tr>
                <c:forEach items="${list}" var="user">
                    <tr><td>${user.id}</td><td>${user.nickname}</td><td>${user.username}</td><td>${user.surname}</td><td>${user.email}</td><td>${user.phone}</td><td>${user.rate}</td></tr>
                </c:forEach>

            </table>
        </table>
    </div>
    <div class="large-3 large-centered column">

    </div>
    <div class="large-3 column"></div>
</div>
</body>
</html>
