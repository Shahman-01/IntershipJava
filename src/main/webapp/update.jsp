<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateMeal</title>
    Update Meal
</head>
<body>

<br />

<form method="post" action="/topjava/meals/update">
    <input type="number" hidden name="id" value="${meal.id}" />
    <label><input type="text" name="dateTimeStr"></label>Time<br>
    <label><input type="text" name="description"></label>Description<br>
    <label><input type="text" name="calories"></label>calories<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
