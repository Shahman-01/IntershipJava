<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<a href="add.jsp">Add meal</a>
<table cellspacing="3" bgcolor="#000000">
    <tr bgcolor="#ffffff">
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <c:if test="${meal.excess == false}">
            <tr bgcolor="#ffffff">
                <td><p style="color:#008000">${meal.dateTimeStr}</p></td>
                <td><p style="color:#008000">${meal.description}</p></td>
                <td><p style="color:#008000">${meal.calories}</p></td>
                <td><a href="meals/update?id=${meal.id}&action=update">Update</a></td>
                <td><a href="meals/delete?id=${meal.id}&action=delete">Delete</a></td>
            </tr>
        </c:if>
        <c:if test="${meal.excess == true}">
            <tr bgcolor="#ffffff">
                <td><p style="color:#FF0000">${meal.dateTimeStr}</p></td>
                <td><p style="color:#FF0000">${meal.description}</p></td>
                <td><p style="color:#FF0000">${meal.calories}</p></td>
                <td><a href="meals/update?id=${meal.id}&action=update">Update</a></td>
                <td><a href="meals/delete?id=${meal.id}&action=delete">Delete</a></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
