<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals List</title>
    <style>
        .red {
            color: red;
        }
        .green {
            color: green;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<a href="add.jsp">Add meal</a>
<table border="1" cellpadding="8" cellspacing="0" title="Meals list">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr class="${meal.excess?"red":"green"}">
            <td>${meal.dateTimeStr}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals/update?id=${meal.id}&action=update">Update</a></td>
            <td><a href="meals/delete?id=${meal.id}&action=delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
