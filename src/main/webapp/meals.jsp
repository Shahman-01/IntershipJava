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
    <c:forEach var="meal" items="${meals}">
        <c:if test="${meal.excess == false}">
            <tr bgcolor="#ffffff">
                <td><p style="color:#008000">${meal.dateTimeStr}</p></td>
                <td><p style="color:#008000">${meal.description}</p></td>
                <td><p style="color:#008000">${meal.calories}</p></td>
                <td>
                    <a href="update.jsp?id=${meal.id}"><input type="submit" value="Update" name="update" /></a>
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
            <tr bgcolor="#ffffff">
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
