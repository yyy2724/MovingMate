<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js" defer></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js" defer></script>
<!-- 모달 관련 라이브러리 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>
<link rel="stylesheet" href="/css/move/movingList.css">
<html>

<body>
<table>


    <h1>주문목록</h1>
    <thead>
    <div class="search">
        <div class="search-con">
            <form action="/move/movingList" method="get" class="search1">
                <select name="subject" id="subject">
                    <option value="moveWriter">작성자</option>
                    <option value="firstAddress">주소</option>
                    <option value="moveType">이사종류</option>
                </select>
                <input type="text" name="search" id="search" value="${param.search}">
                <input type="submit" value="검색">
            </form>
        </div>
    </div>
    <tr>
        <th>주문번호</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이사 전 주소</th>
        <th>이사 주소</th>
        <th>이사종류</th>
        <th>이사 시간</th>
        <th>이사 가격</th>
    </tr>
    </thead>

    <tbody>

    <script>

        function openModal(id,moveWriter, phone, firstAddress, endAddress, moveType, start){
            document.getElementById('id').value = id;
            document.getElementById('moveWriter').value = moveWriter;
            document.getElementById('phone').value = phone;
            document.getElementById('firstAddress').value = firstAddress;
            document.getElementById('endAddress').value = endAddress;
            document.getElementById('moveType').value = moveType;
            document.getElementById('start').value = start;

            $('#modal1').modal();
        }
    </script>

    <div id="modal1" class="modal">
        <form action="/move/price" method="post"> <!-- 금액설정 -->
            <input type="hidden" name="id" id="id">
            <input type="hidden" name="moveWriter" id="moveWriter" >
            <input type="hidden" name="phone" id="phone">
            <input type="hidden" name="firstAddress" id="firstAddress">
            <input type="hidden" name="endAddress" id="endAddress">
            <input type="hidden" name="moveType" id="moveType">
            <input type="hidden" name="start" id="start" >
            책정 금액을 입력해주세요.<br>
            <input type="text" name="price" id="price" oninput="addCommas(event)">
            <input type="submit" value="입력" onclick="alert('입력되었습니다.')">

            <a href="#" rel="modal:close" class="close">닫기</a>
        </form>
    </div>

    <div>
        <c:forEach var="item" items="${move}">
            <c:if test="${item.price == 0}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.moveWriter}"/></td>
                    <td><c:out value="${item.phone}"/></td>
                    <td><c:out value="${item.firstAddress}"/></td>
                    <td><c:out value="${item.endAddress}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${item.moveType eq 'oneRoom'}">원룸이사</c:when>
                            <c:when test="${item.moveType eq 'home'}">가정이사</c:when>
                            <c:when test="${item.moveType eq 'brave'}">용달이사</c:when>
                            <c:when test="${item.moveType eq 'company'}">기업이사</c:when>
                            <c:otherwise>
                                ${item.moveType}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:set var="formattedDate" value="${fn:substring(item.start, 0, 16)}"/>
                        <c:out value="${formattedDate.replace('T', ' ').replace('-', '/')}"/>
                    </td>
                        <%--                    <td><c:out value="${item.price}"/></td>--%>
                    <td><a href="#" onclick="openModal(
                            '${item.id}',
                            '${item.moveWriter}',
                            '${item.phone}',
                            '${item.firstAddress}',
                            '${item.endAddress}',
                            '${item.moveType}',
                            '${item.start}'
                            )">금액제시</a>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </div>
    </tbody>

    <tfoot>
    </tfoot>


</table>
<a href="/index">메인페이지</a>
<div class="paging">
    <ul>
        <li>
            <%-- 현재 페이지가 첫 번째 페이지이면 span 표시 --%>
            <c:if test="${1 == moveList.pageable.pageNumber + 1}">
                <span class="span0">START</span>
            </c:if>
            <%-- 처음 페이지가 아니면 처음(누를 시 1페이지로) --%>
            <c:if test="${1 != moveList.pageable.pageNumber + 1}">
                <span>
                    <a href="/move/moveingList?page=0&amp;search=${param.search}&amp;subject=${param.subject}"
                       class="span1">처음</a>
                </span>
            </c:if>
        </li>

        <li>
            <%-- 첫 페이지일 때 --%>
            <c:if test="${1 == moveList.pageable.pageNumber + 1}">
                <span class="span0">Pre</span>
            </c:if>
            <%-- 첫 페이지가 아니면 이전(이전 페이지로 이동) --%>
            <c:if test="${1 != moveList.pageable.pageNumber + 1}">
                <span>
                    <a href="/move/movingList?page=${moveList.pageable.pageNumber - 1}&amp;search=${param.search}&amp;subject=${param.subject}"
                       class="span1">이전</a>
                </span>
            </c:if>
        </li>

        <li>
            <%-- 페이지 번호 표시 --%>
            <c:forEach var="i" begin="${startPage}" end="${endPage}">
                <c:choose>
                    <c:when test="${i == moveList.pageable.pageNumber + 1}">
                        <span class="now">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="/move/movingList?page=${i - 1}&amp;search=${param.search}&amp;subject=${param.subject}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </li>

        <li>
            <%-- 마지막 페이지일 때 --%>
            <c:if test="${moveList.totalPages == moveList.pageable.pageNumber + 1}">
                <span class="span0">NEXT</span>
            </c:if>
            <%-- 마지막 페이지가 아니면 다음(다음 페이지로 이동) --%>
            <c:if test="${moveList.totalPages != moveList.pageable.pageNumber + 1}">
                <span>
                    <a href="/move/movingList?page=${moveList.pageable.pageNumber + 1}&amp;search=${param.search}&amp;subject=${param.subject}"
                       class="span1">다음</a>
                </span>
            </c:if>
        </li>

        <li>
            <%-- 마지막 페이지일 때 --%>
            <c:if test="${moveList.totalPages == moveList.pageable.pageNumber + 1}">
                <span class="span0">END</span>
            </c:if>
            <%-- 마지막 페이지가 아니면 마지막(마지막 페이지로 이동) --%>
            <c:if test="${moveList.totalPages != moveList.pageable.pageNumber + 1}">
                <span>
                    <a href="/move/movingList?page=${moveList.totalPages - 1}&amp;search=${param.search}&amp;subject=${param.subject}"
                       class="span1">마지막</a>
                </span>
            </c:if>
        </li>
    </ul>
</div>
</body>
</html>