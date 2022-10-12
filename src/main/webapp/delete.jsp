<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${meal.description eq null?"Add meal":"Edit meal"}</title>
    Update Meal
</head>
<body>

<br />

<form method="post" action="/delete">
    <label><input type="text" name="id"></label>Id<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>