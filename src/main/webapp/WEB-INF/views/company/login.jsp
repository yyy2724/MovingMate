<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>adminLogin</title>
</head>
<body>
    <form action="company/login" method="post">
        <span>id : </span><input type="text" name="username" required><br>
        <span>password : </span> <input type="password" name="password" required><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>