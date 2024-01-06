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
    <link rel="stylesheet" href="/css/common/footer.css">
    <link rel="stylesheet" href="/css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"
            defer></script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"
            defer></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"
            defer></script>
</head>
<body>
<div id="header" class="header">
    <div class="nav">

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

<div class="container" style="height: 1000px">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="5000">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/images/index/index1.png" class="d-block w-100"
                     alt="대체이미지1">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/index/index2.png" class="d-block w-100"
                     alt="대체이미지2">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/index/index3.png" class="d-block w-100"
                     alt="대체이미지3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <div class="move-form-container">
        <div class="opt">
            <sec:authorize access="!isAuthenticated()">
                <a href="#modal2" rel="modal:open" class="modal2">기업 로그인</a>
                <a href="#modal1" rel="modal:open" class="myOrder">내 주문내역</a>
                <a href="/company/join" class="join">기업 회원가입</a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a href="/company/logout" class="logout">로그아웃</a>
                <a href="/move/movingList" class="serviceList">서비스 신청 목록</a>
            </sec:authorize>
        </div>

        <div class="form-con">
            <form action="/move/save" method="post" class="move-form">
                <select class="form-select" aria-label="Default select example" style="margin-bottom: 15px">
                    <option selected name="moveType" id="oneroom" value="oneRoom">원룸이사</option>
                    <option name="moveType" id="home" value="home">가정이사</option>
                    <option name="moveType" id="brave" value="brave">용달이사</option>
                    <option name="moveType" id="company" value="company">기업이사</option>
                </select>

                <input type="text" name="moveWriter" id="moveWriter" class="move-input" placeholder="이름"><br>
                <input type="text" name="phone" id="phone" oninput="oninputPhone(this)" maxlength="14"
                       class="move-input"
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
            <form action="/order/orderSearchNum" method="post" style="padding-top: 100px">
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


    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js" defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js" defer></script>
    <script src="/js/index.js" defer></script>
    <script src="/js/index/moveSave.js" defer></script>
    <!-- 모달 관련 라이브러리 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
</div>


<div class="footer">
    <div class="footer-main">
        <div class="footer-con">
            <div class="footer-top">
                <div class="footer-left">
                    <div class="left-sec1">
                        <h2>노원그린 컴퓨터학원</h2>
                    </div>

                    <div class="left-sec2">
                        <h3>대표번호 : 02.6953.2002</h3>
                        <div>
                            <span>평일 09:00~22:30</span>
                            <span>토요일 09:00~18:30</span>
                        </div>
                    </div>


                </div>
                <div class="footer-right">
                    <div class="top">
                        <a th:href="@{/}">컬리소개</a>
                        <a th:href="@{/}">컬리소개영상</a>
                        <a th:href="@{/}">투자정보</a>
                        <a th:href="@{/}">인재채용</a>
                        <a th:href="@{/}">개인정보처리방침</a>
                        <a th:href="@{/}">이용안내</a>
                    </div>
                    <div class="middle">
                        <span>법인명 (상호) 주식회사 컬리</span><br>
                        <span>통신판매업 제 0000-서울노원-0000호</span><br>
                        <span>주소 : 서울특별시 강남구 테헤란로 000,00층(역삼동) | 대표팀장 안윤기</span><br>
                        <div>
                            <span>채용문의 : </span>
                            <span>0000@gmail.com</span>
                        </div>
                        <span>팩스 070-0000-0000</span>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>

</html>