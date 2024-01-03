<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Sortable/1.14.0/Sortable.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/company/address.js"></script>
<script src="/js/company/join.js"></script>
<link rel="stylesheet" href="/css/company/check.css">
<link rel="stylesheet" href="/css/company/join.css">
<!DOCTYPE html>
<html>

<body>
<div class="company">
    <h1 class="h11">회사 회원가입</h1>
    <form action="/company/join" method="post" id="comJoin">
        <div class="form-group" id="form1">
            <input type="text" name="companyName" id="companyName" placeholder="회사명">
            <div class="feedback">
                <span class="company_ok">사용 가능한 회사명입니다.</span>
                <span class="company_already">이미 사용중인 회사명 입니다.</span>
            </div>

            <input type="text" name="businessNumber" id="businessNumber" placeholder="사업자번호">
            <div class="feedback">
                <span class="businessNumber_ok">사용 가능한 사업자번호입니다.</span>
                <span class="businessNumber_already">이미 사용중인 사업자번호 입니다.</span>
                <span class="businessNumber_expression">올바른 사업자번호을 작성해주세요.</span>
                <span class="businessNumber_short">8-10자리로 입력해주세요.</span>
            </div>

            <input type="text" name="name" placeholder="대표자명">

            <div class="form1-1">
                <input type="text" name="email" id="mail" placeholder="회사대표 이메일">
                <button type="button" id="emailCheck">인증번호 받기</button>
            </div>

            <div class="feedback">
                <span class="member_ok">사용 가능한 이메일입니다.</span>
                <span class="member_already">이미 사용중인 이메일 입니다.</span>
                <span class="email_expression">올바른 이메일을 작성해주세요.</span>
            </div>
            <div class="form1-2">
                <input type="text" id="certificationNumber" placeholder="인증번호">
                <button type="button" id="certificationBtn">이메일인증확인</button>
            </div>
        </div>

        <div class="form-group" id="form2">
            <input type="text" name="phone" id="phone" placeholder="전화번호">
            <div class="feedback">
                <span class="phone_expression">올바른 전화번호를 작성해주세요.</span>
                <span class="phone_ok">사용 가능한 전화번호입니다.</span>
                <span class="phone_already">이미 가입된 전화번호입니다.</span>
            </div>

            <input type="password" name="password" id="password" placeholder="비밀번호">
            <div class="feedback">
                <span class="pw_string">숫자와 영문자, 특수문자 조합으로 8~16자리를 사용해야 합니다.</span>
                <span class="pw_length">숫자와 영문자, 특수문자를 혼용하여야 합니다.</span>
                <span class="pw_true">같은 문자를 3번 이상 사용하실 수 없습니다.</span>
                <span class="pw_email">비밀번호에 이메일이 포함되었습니다.</span>
            </div>

            <input type="password" name="checkPassword" id="checkPassword" placeholder="비밀번호 확인">
            <div class="feedback">
                <span class="password_already">비밀번호가 일치하지 않습니다.</span>
            </div>
        </div>

        <div class="form-group" id="form3">
            <div class="form1-3">
                <input type="text" id="postcode" name="postcode" class="postcode" placeholder="우편번호">
                <input type="button" id="uphyeon" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
            </div>
            <input type="text" id="address" name="address" class="address" placeholder="주소"><br>
            <input type="text" id="extraAddress" name="extraAddress" class="extraAddress" placeholder="참고항목">
            <input type="text" id="detailAddress" name="detailAddress" class="detailAddress" placeholder="상세주소">

            <input type="submit" value="회원가입" id="submit-button">
        </div>

    </form>
</div>
</body>
</html>