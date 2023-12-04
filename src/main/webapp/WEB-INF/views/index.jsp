<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/index.js" defer></script>
    <script src="/js/index/moveSave.js" defer></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div class="container">
    <div class="sections-con">
        <div class="sections">
            <div class="section1-con">
                <div class="section1">

                    <div class="slideshow-container">

                        <div class="mySlides fade">
                            <div class="numbertext">1 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index1.png" style="width:100%; height: 300px"
                                 alt="대체이미지1">
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">2 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index2.png" style="width:100%; height: 300px"
                                 alt="대체이미지2">
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">3 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index3.png" style="width:100%; height: 300px"
                                 alt="대체이미지3">
                        </div>

                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a>

                    </div>

                    <div style="text-align:center">
                        <span class="dot" onclick="currentSlide(1)"></span>
                        <span class="dot" onclick="currentSlide(2)"></span>
                        <span class="dot" onclick="currentSlide(3)"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<form action="/move/save" method="post">
    <input type="radio" name="moveType" id="oneroom" value="oneRoom">원룸이사
    <input type="radio" name="moveType" id="home" value="home">가정이사
    <input type="radio" name="moveType" id="brave" value="brave">용달이사
    <input type="radio" name="moveType" id="company" value="company">기업이사
    이름 : <input type="text" name="moveWriter" id="moveWriter">
    연락처 : <input type="text" name="phone" oninput="oninputPhone(this)" maxlength="14">
    출발지 : <input type="text" name="firstAddress" id="firstAddress"  onclick="firstAddressList()">
    도착지 : <input type="text" name="endAddress" id="endAddress"  onclick="endAddressList()">
    <input type="submit" value="이사상담받기">
</form>
<a href="/admin/login">관리자 로그인</a>
</body>
</html>