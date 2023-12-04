<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${admins.adminName}님의 페이지</title>
</head>
<body>
<h3>${admins.adminName}님의 페이지!</h3>
<span>아이디 : </span> <span>${admins.adminId}</span><br>
<span>이름 : </span> <span>${admins.adminName}</span><br>
<span>전화번호 : </span> <span>${admins.adminPhone}</span><br>

</body>
</html>