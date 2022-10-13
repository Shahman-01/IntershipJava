<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h3><a href="/topjava/index.html">Home</a></h3>
    <hr>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${meal.description eq null?"Add meal":"Edit meal"}</title>
    <h2>Update Meal</h2>
</head>
<body>
<form method="post" action="/topjava/meals/update">
    <input type="number" hidden name="id" value="${meal.id}" />
    <label><input type="text" name="dateTimeStr"></label>   Time<br>
    <label><input type="text" name="description"></label>   Description<br>
    <label><input type="text" name="calories"></label>   Calories<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>
<hr>
</body>
</html>
