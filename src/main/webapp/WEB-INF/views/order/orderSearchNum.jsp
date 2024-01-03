<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>주문찾기</title>
    <link rel="stylesheet" href="/css/order/orderSearchNum.css">
</head>
<body>


<div id="modal1" class="modal">
    <form action="/order/orderSearchNum" method="post">
        주문번호를 입력해주세요.<br>
        <input type="number" name="id" id="id">
        <input type="submit" value="찾기">

        <a href="#" rel="modal:close">닫기</a>
    </form>
</div>

</body>

</html>