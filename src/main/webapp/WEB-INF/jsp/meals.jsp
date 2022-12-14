<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3><spring:message code="meal.title"/></h3>

    <form method="get" action="meals/filter">
        <dl>
            <dt><spring:message code="meal.startDate"/>:</dt>
            <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
        </dl>
        <dl>
            <dt><spring:message code="meal.endDate"/>:</dt>
            <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
        </dl>
        <dl>
            <dt><spring:message code="meal.startTime"/>:</dt>
            <dd><input type="time" name="startTime" value="${param.startTime}"></dd>
        </dl>
        <dl>
            <dt><spring:message code="meal.endTime"/>:</dt>
            <dd><input type="time" name="endTime" value="${param.endTime}"></dd>
        </dl>
        <button type="submit" class="btn btn-primary ml-3"><spring:message code="meal.filter"/></button>
    </form>
    <hr>
    <div>
        <button class="btn btn-outline-success ml-3" data-toggle="modal" data-target="#modal"><spring:message code="meal.add"/></button>
    </div>

    <div class="modal fade" id="modal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
<%--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
                </div>
                <div class="modal-body">
                    <form method="post" action="meals">
                        <input type="hidden" name="id" value="${meal.id}">
                        <dl>
                            <dt><spring:message code="meal.dateTime"/>:</dt>
                            <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime" required></dd>
                        </dl>
                        <dl>
                            <dt><spring:message code="meal.description"/>:</dt>
                            <dd><input type="text" value="${meal.description}" size=40 name="description" required></dd>
                        </dl>
                        <dl>
                            <dt><spring:message code="meal.calories"/>:</dt>
                            <dd><input type="number" value="${meal.calories}" name="calories" required></dd>
                        </dl>
                        <button type="submit" class="btn btn-primary"><spring:message code="common.save"/></button>
                        <button onclick="window.history.back()" type="button" class="btn btn-secondary"><spring:message code="common.cancel"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<%--    <a href="meals/create"><spring:message code="meal.add"/></a>--%>
    <hr>
    <table id="datatable" class="table table-striped">
        <thead>
        <tr>
            <th><spring:message code="meal.dateTime"/></th>
            <th><spring:message code="meal.description"/></th>
            <th><spring:message code="meal.calories"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.meals}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.to.MealTo"/>
            <tr data-meal-excess="${meal.excess}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        <%--${fn:replace(meal.dateTime, 'T', ' ')}--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals/update?id=${meal.id}"><spring:message code="common.update"/></a></td>
                <td><a href="meals/delete?id=${meal.id}" id="detailsForm"><spring:message code="common.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
<script src="resources/js/topjava.users.js"></script>
<script src="resources/js/topjava.common.js"></script>
</body>
</html>