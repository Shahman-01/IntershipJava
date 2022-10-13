<!DOCTYPE html>
<html lang="en">
<head>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <meta charset="UTF-8">
    <title>Add meal</title>
</head>
<body>
<h2>Create new meal</h2>
<form method="post" action="/topjava/meals/add">
    <label><input type="text" name="dateTimeStr"></label>    Time<br>
    <label><input type="text" name="description"></label>    Description<br>
    <label><input type="text" name="calories"></label>     Calories<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>
<hr>
</body>
</html>
