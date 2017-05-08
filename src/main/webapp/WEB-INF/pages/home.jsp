<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<body>
<jsp:include page="bar.jsp"/>
<h2>${sessionScope.get("auth").username}</h2>

</body>
</html>
