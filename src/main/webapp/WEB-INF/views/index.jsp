<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <script src="js/index/moveSave.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<form action="/move/save" method="post">
    <input type="radio" name="moveType" id="oneroom" value="oneRoom">원룸이사
    <input type="radio" name="moveType" id="home" value="home">가정이사
    <input type="radio" name="moveType" id="brave" value="brave">용달이사
    <input type="radio" name="moveType" id="company" value="company">기업이사
    이름 : <input type="text" name="name" id="name">
    연락처 : <input type="text" name="phone" oninput="oninputPhone(this)" maxlength="14">
    출발지 : <input type="text" name="firstAddress" id="firstAddress"  onclick="firstAddressList()">
    도착지 : <input type="text" name="endAddress" id="endAddress"  onclick="endAddressList()">
    <input type="submit" value="이사상담받기">
</form>

</body>
</html>