<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/css/company/login.css">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>adminLogin</title>
</head>
<body>
<div id="modal2" class="modal">
    <form action="/company/login" method="post">
        <span>id(이메일) : </span><input type="email" name="email" required><br>
        <span>password : </span> <input type="password" name="password" required><br>


        <% if (request.getParameter("error") != null && request.getParameter("exception") != null) { %>
        <p style="color: red;">
            실패 이유: <%= request.getParameter("exception") %>
        </p>
        <% } %>


        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>