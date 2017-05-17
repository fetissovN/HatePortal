
<div class="translucent-form-overlay" style="float: right;">
<s:form method="post" commandName="barUserInfo" action="/post/post/comment/${post.id}">
    <h3><spring:message code="label.bar.droptitle"/></h3>
    <div class="row columns">
        <label><spring:message code="label.nickname"/>
            <s:input path="nickname"/>
                <%--<input type="text" name="keyword" placeholder="Any">--%>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.username"/>
            <s:input path="username"/>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.surname"/>
            <s:input path="surname"/>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.reg.email"/>
            <s:input path="email"/>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.reg.phone"/>
            <s:input path="phone"/>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.password"/>
            <s:password path="password"/>
        </label>
    </div>
    <div class="row columns">
        <label><spring:message code="label.password.check"/>
            <s:password path="passwordCheck"/>
        </label>
    </div>
    <%--<input class="button" type="submit" value="Ok"/>--%>
    <button type="submit" class="primary button expanded search-button">
        Ok
    </button>
</s:form>
</div>