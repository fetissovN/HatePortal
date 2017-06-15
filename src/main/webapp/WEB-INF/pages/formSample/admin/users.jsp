<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="userAdminAjax">
            <table style="font-size: xx-small; margin-right: 20px" cellpadding="4" cellspacing="1">
                <p>Total users: ${countUsers}</p>
                <tr>
                    <th>Id</th>
                    <th>Nickname</th>
                    <th>Username</th>
                    <th>Surname</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Rate</th>
                </tr>
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
</div>