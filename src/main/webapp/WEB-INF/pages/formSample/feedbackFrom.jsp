
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="translucent-form-overlay-feed" style="float: right;">
    <s:form id="barFeedbackId" method="post" commandName="barFeedback" action="/sendFeedback">
        <h3><spring:message code="label.bar.feedback.nameForm"/></h3>
        <div class="row columns">
            <label><spring:message code="label.reg.email"/>
                <s:input path="email" value="${sessionScope.get('auth').email}" />
                <span class="error"><s:errors path="email" /></span>
            </label>
        </div>
        <div class="row columns">
            <label><spring:message code="label.bar.feedback.text"/>
                <s:textarea path="feedback"/>
                <span class="error"><s:errors path="email" /></span>
            </label>
        </div>

        <%--<input class="button" type="submit" value="Ok"/>--%>
        <button id="submitFeed" type="submit" class="primary button expanded search-button">
            Ok
        </button>
    </s:form>
</div>