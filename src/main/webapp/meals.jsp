<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Create new meal</h2>
<form method="post" action="/topjava/meals">
    <label><input type="text" name="dateTimeStr"></label>Time<br>
    <label><input type="text" name="description"></label>Description<br>
    <label><input type="text" name="calories"></label>calories<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>
<hr>
<table>
    <c:forEach var="meal" items="${meals}">
        <c:if test="${meal.excess == false}">
            <tr>
                <td><p style="color:#00FF00">${meal.dateTimeStr}</p></td>
                <td><p style="color:#00FF00">${meal.description}</p></td>
                <td><p style="color:#00FF00">${meal.calories}</p></td>
                <td>
                    <form method="post" action="/topjava/meals/edit">
                        <input type="number" hidden name="id" value="${meal.id}" />
                        <input type="submit" value="Update" name="update" />
                    </form>
                </td>
                <td>
                <form method="post" action="/topjava/meals/delete">
                    <input type="number" hidden name="id" value="${meal.id}" />
                    <input type="submit" value="Delete" name="delete" />
                </form>
                </td>
            </tr>
        </c:if>
        <c:if test="${meal.excess == true}">
            <tr>
                <td><p style="color:#FF0000">${meal.dateTimeStr}</p></td>
                <td><p style="color:#FF0000">${meal.description}</p></td>
                <td><p style="color:#FF0000">${meal.calories}</p></td>
                <td><a href="update.html">Edit</a></td>
                <td>
                    <form method="post" action="/topjava/meals/delete">
                        <input type="number" hidden name="id" value="${meal.id}" />
                        <input type="submit" value="Delete" name="delete" />
                    </form>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
