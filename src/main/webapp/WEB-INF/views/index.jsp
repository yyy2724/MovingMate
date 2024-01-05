<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<script defer>
    function openModal() {
        $.ajax({
            type: "GET", // 또는 "POST"
            url: "/order/orderSearchNum", // 가져올 페이지 URL
            success: function (data) {
                // 가져온 데이터(data)를 모달창에 추가
                $("#myModal .modal-content").html(data);
                $("#myModal").modal(); // 모달 열기
            },
            error: function () {
                alert("페이지를 불러오는 중 오류가 발생했습니다.");
            }
        });
    }

    $(document).ready(function () {
        // 관리자 로그인 모달 열기
        $("a[href='#modal2']").click(function () {
            $("#modal2").modal();
        });

        // 내 주문내역 모달 열기
        $("a[href='#modal1']").click(function () {
            $("#modal1").modal();
        });

    });

</script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" href="/css/common/header.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/company/login.css">

</head>
<body>
<div id="header" class="header">
    <div class="nav">
        <div class="top-nav">
            <a href="/index">무빙메이트</a>
        </div>

        <ul>
            <li><a href="#">이사</a></li>
            <li><a href="#">이사비교견적</a></li>
            <li><a href="#">청소</a></li>
            <li><a href="#">혜택</a></li>
            <li><a href="#">건물관리</a></li>
            <li><a href="#">커뮤니티</a></li>
            <li><a href="#">영구이사</a></li>
            <li><a href="#">고객만족센터</a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/index/menu.JPG" alt="메뉴바" class="menu"
                                 style="width: 50px; height: 50px;"></a></li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="sections-con">
        <div class="sections">
            <div class="section1-con">
                <div class="section1">

                    <div class="slideshow-container">

                        <div class="mySlides fade">
                            <div class="numbertext">1 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index1.png"
                                 style="width:100%; height: 300px"
                                 alt="대체이미지1">
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">2 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index2.png"
                                 style="width:100%; height: 300px"
                                 alt="대체이미지2">
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">3 / 3</div>
                            <img src="${pageContext.request.contextPath}/images/index/index3.png"
                                 style="width:100%; height: 300px"
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
<div class="move-form-container">
    <form action="/move/save" method="post" class="move-form">
        <div class="isa">
            <input type="radio" name="moveType" id="oneroom" value="oneRoom">
            <label for="oneroom">원룸이사</label>
            <input type="radio" name="moveType" id="home" value="home">
            <label for="home">가정이사</label>
            <input type="radio" name="moveType" id="brave" value="brave">
            <label for="brave">용달이사</label>
            <input type="radio" name="moveType" id="company" value="company">
            <label for="company">기업이사</label><br>
        </div>

        <input type="text" name="moveWriter" id="moveWriter" class="move-input" placeholder="이름"><br>
        <input type="text" name="phone" id="phone" oninput="oninputPhone(this)" maxlength="14" class="move-input"
               placeholder="전화번호"><br>
        <input type="text" name="firstAddress" id="firstAddress" onclick="firstAddressList()" class="move-input"
               placeholder="출발지"><br>
        <input type="text" name="endAddress" id="endAddress" onclick="endAddressList()" class="move-input"
               placeholder="도착지"><br>
        <input type="submit" value="견적접수" class="submit-btn">
    </form>
</div>


<%-- 주문 신청 내역 모달창--%>
<div id="modal1" class="modal">
    <form action="/order/orderSearchNum" method="post">
        주문번호를 입력해주세요.<br>
        <input type="number" name="id" id="id">
        <input type="submit" value="찾기">

        <a href="#" rel="modal:close" class="close">닫기</a>
    </form>
</div>


<%-- 로그인 모달창 --%>
<div id="modal2" class="modal">
    <form action="/company/login" method="post" class="loginForm">
        <span>id(이메일) : </span><input type="email" name="email" class="email" required><br>
        <span>password : </span> <input type="password" name="password" class="password" required><br>

        <% if (request.getParameter("error") != null && request.getParameter("exception") != null) { %>
        <p style="color: red;">
            실패 이유: <%= request.getParameter("exception") %>
        </p>
        <% } %>


        <input type="submit" value="로그인" class="login-form-submit">

        <a href="#" rel="modal:close" class="close">닫기</a>
    </form>
</div>

<sec:authorize access="!isAuthenticated()">
    <a href="#modal2" rel="modal:open" class="modal2">관리자 로그인</a>
    <a href="#modal1" rel="modal:open" class="myOrder">내 주문내역</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <a href="/company/logout" class="logout">로그아웃</a>
    <a href="/move/movingList" class="serviceList">서비스 신청 목록</a>
</sec:authorize>

<a href="/company/join" class="join">회사 회원가입</a>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js" defer></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js" defer></script>
<script src="/js/index.js" defer></script>
<script src="/js/index/moveSave.js" defer></script>
<!-- 모달 관련 라이브러리 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>


<div class="footer" id="footer">

</div>
</body>
</html>