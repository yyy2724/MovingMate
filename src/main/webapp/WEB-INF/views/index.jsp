<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/css/index.css">
<script src="/js/index.js" defer></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
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
                            <img src="${pageContext.request.contextPath}/images/index/index1.png" style="width:100%"
                                 alt="대체이미지1">
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">2 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index2.png" style="width:100%"
                                 alt="대체이미지2">
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">3 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index3.png" style="width:100%"
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

</body>
</html>