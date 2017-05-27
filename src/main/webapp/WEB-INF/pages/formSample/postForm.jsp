<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-color: bisque" class="row" id="ajaxPostFormSample">
    <div class="large-3 column">
    </div>
    <div class="large-6 large-centered column">
        <s:form id="formPostAjax"  method="post" commandName="postForm" action="/post/update/${postForm.id}">
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
                <td><input id="submitFormUpdate" class="button" type="submit" value="Ok"/></td>
                <td><input style="float: right" id="closePostFormUpdate" class="button" type="button" value="Later"/></td>
            </tr>
            </table>
        </s:form>

    </div>
    <div class="large-3 column"></div>
</div>
