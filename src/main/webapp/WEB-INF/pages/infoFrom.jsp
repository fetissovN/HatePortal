<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="translucent-form-overlay" style="float: right;">
<s:form id="infoFormId" method="post" commandName="barUserInfo" action="/infoCh">
    <h3><spring:message code="label.bar.droptitle"/></h3>
    <div class="row columns">
        <label><spring:message code="label.nickname"/>
            <s:input path="nickname" value="${sessionScope.get('auth').nickname}" />
                <%--<input type="text" name="keyword" placeholder="Any">--%>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.username" />
            <s:input path="username" value="${sessionScope.get('auth').username}" />
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.surname"/>
            <s:input path="surname" value="${sessionScope.get('auth').surname}" />
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.reg.email"/>
            <s:input path="email" value="${sessionScope.get('auth').email}" />
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.reg.phone"/>
            <s:input path="phone" value="${sessionScope.get('auth').phone}" />
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.password"/>
            <s:password path="password" />
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.password.check"/>
            <s:password path="passwordCheck"/>
        </label>
    </div>
    <%--<input class="button" type="submit" value="Ok"/>--%>
    <button id="submitInfo" type="submit" class="primary button expanded search-button">
        Ok
    </button>
</s:form>
</div>