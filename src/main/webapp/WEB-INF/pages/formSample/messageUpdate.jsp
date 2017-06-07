<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <s:form id="messageAjaxId" method="post" commandName="messageUpdate" action="/post/comment/update">
    <div class="supportId" style="display: none">${messageUpdate.id}</div>
    <tr>
        <td><s:input path="id" cssStyle="display: none"/></td>

        <td><s:input path="message"/></td>
    <td><span class="error"><s:errors path="message" /></span></td>
    </tr>
    <tr>
        <td><input id="messSubmitUpdateFormId" class="button" type="submit" value="Ok"/></td>
        <td><input style="float: right" id="closeMessFormUpdate" class="button" type="button" value="Later"/></td>
    </tr>
    </s:form>