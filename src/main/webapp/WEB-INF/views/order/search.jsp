<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
<script src="https://cdn.iamport.kr/v1/iamport.js" defer></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" defer></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js" defer></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>
<script src=""></script>

<link rel="stylesheet" href="/css/order/search.css">
<html>

<head>
    <title>주문내역</title>
</head>

<body>
<table>
    <h1>주문내역</h1>
    <thead>
    <tr>
        <th>주문번호</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이사 전 주소</th>
        <th>이사 주소</th>
        <th>이사종류</th>
        <th>이사 시간</th>
        <th>이사 가격</th>
        <th>결제</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%--        <input type="hidden" value="${moveEntity.}">--%>
        <td id="id">${moveEntity.id}</td>
        <td id="moveWriter">${moveEntity.moveWriter}</td>
        <td id="phone">${moveEntity.phone}</td>
        <td id="firstAddress">${moveEntity.firstAddress}</td>
        <td id="endAddress">${moveEntity.endAddress}</td>
        <td id="moveType"><c:choose><c:when test="${moveEntity.moveType eq 'oneRoom'}">원룸이사</c:when><c:when test="${moveEntity.moveType eq 'home'}">가정이사</c:when><c:when test="${moveEntity.moveType eq 'brave'}">용달이사</c:when><c:when test="${moveEntity.moveType eq 'company'}">기업이사</c:when><c:otherwise>${moveEntity.moveType}</c:otherwise></c:choose></td>
        <td id="moveDate">${formattedDate}</td>
        <td id="price">
            <c:choose>
                <c:when test="${moveEntity.price eq 0 && sessionScope['SPRING_SECURITY_CONTEXT'].authentication.principal.companyEntity.role eq 'COMPANY'}">
                    <a href="#">가격설정</a>
                </c:when>

                <c:when test="${moveEntity.price eq 0}">
                    가격 책정 중
                </c:when>
                <c:when test="${moveEntity.price eq 1}">
                    결제완료
                </c:when>
                <c:otherwise>
                    ${moveEntity.price} 원
                </c:otherwise>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${moveEntity.price eq 0}">
                    결제불가
                </c:when>
                <c:when test="${moveEntity.price eq 1}">
                    결제완료
                </c:when>
                <c:otherwise>
                    <button onclick="KGpay()">결제</button>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    </tbody>


    <script>
        function KGpay() {
            const self = this;
            const moveWriter = document.querySelector('#moveWriter').textContent;
            const phone = document.querySelector('#phone').textContent;
            const firstAddress = document.querySelector('#firstAddress').textContent;
            const moveType = document.querySelector('#moveType').textContent;

            const price = parseInt(document.querySelector('#price').textContent);

            IMP.init("imp78035400");
            IMP.request_pay({
                pg: 'html5_inicis',
                pay_method: 'card',
                merchant_uid: this.email + '_' + new Date().getTime(),
                name: moveType,
                amount: price,
                buyer_email: 'email',
                buyer_name: moveWriter,
                buyer_tel: phone,
                buyer_addr: firstAddress,
            }, function (rsp) {
                // 결제 후 호출되는 callback 함수
                if (rsp.success) {
                    console.log(rsp);
                    $('#price').value = 1;
                    alert("결제가 완료되었습니다.")
                } else {
                    alert('결제실패 : ' + rsp.error_msg);
                }
            })
        }
    </script>

</table>


</body>
</html>


