<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 회원가입</title>
    <script src="js/admin/join.js"></script>
</head>
<body>
    <form action="join" method="post">
        <span>아이디 : </span><input type="text" name="adminId" required><br>
        <span>성함 : </span><input type="text" name="adminName" required><br>
        <span>비밀번호 : </span> <input type="password" name="password" required><br>
        <span>핸드폰번호 : </span><input type="text" name="adminPhone" oninput="oninputPhone(this)" maxlength="14">
        <input type="submit" value="회원가입">
    </form>
</body>
</html>