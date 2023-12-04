<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/css/order/order.css">
<%-- 폰트 링크 --%>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
<html>
<head>
    <title>Order Details</title>
</head>
<body>
<h1>주문내역</h1>
<p>주문번호: ${moveData.id}</p>
<p>이름: ${moveData.moveWriter}</p>
<p>전화번호: ${moveData.phone}</p>
<p>이사 전 주소: ${moveData.firstAddress}</p>
<p>이사 주소: ${moveData.endAddress}</p>
<c:choose>
    <c:when test="${moveData.moveType eq 'oneroom'}"><p>이사종류: 원룸이사</p></c:when>
    <c:when test="${moveData.moveType eq 'oneroom'}"><p>이사종류: 가정이사</p></c:when>
    <c:when test="${moveData.moveType eq 'brave'}"><p>이사종류: 용달이사</p></c:when>
    <c:when test="${moveData.moveType eq 'company'}"><p>이사종류: 기업이사</p></c:when>
    <c:otherwise>
        <p>이사종류: ${moveData.moveType}</p>
    </c:otherwise>
</c:choose>
</body>
</html>