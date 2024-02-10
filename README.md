# MovingMate

# SpringBoot-Project-SoleManager
스프링 부트 -> 이삿짐 센터 프로젝트
<br>

## 🖥️ 프로젝트 소개
1. 편리하게 아사 거리, 이사 종류 등을 기입
2. 이사 업체에서 견적에 대한 금액 제시
3. 그 금액에 대한 결제 기능 제공
<br>

### ⌛️ 개발 기간
* 23.12 ~ 23.01 (약 1개월 소요)

### 🏃‍♀️ 맴버 구성
* 김양현 : 기업 회원가입 및 로그인, 캘린더, 주문, 가격 책정, 결제, Git Actions 를 통한 배포
<br>


### 김양현
<details>
<summary>메인페이지 / 이사서비스 주문 / 주문 내역</summary>

### 이사서비스 주문 / 검색
![이사신청, 찾기](https://github.com/yyy2724/MovingMate/assets/93104606/8f53f339-ed49-46b1-a0e9-a45310e7d95c)
<br>
#### FullCalendar
FullCalendar를 사용하면 웹 애플리케이션에 동적이고 시각적으로 매력적인 이벤트 캘린더를 구현할 수 있습니다.


### 주문내역
![image](https://github.com/yyy2724/MovingMate/assets/93104606/e4b60c18-4906-4967-88b1-593f685300ab)

</details>

<details>
<summary>기업 회원가입 및 로그인</summary>

### 기업 회원가입
![image](https://github.com/yyy2724/MovingMate/assets/93104606/fa83e8e3-7163-477d-a8c5-eeae529ab535)

### 기업 로그인
![모달로그인](https://github.com/yyy2724/MovingMate/assets/93104606/e87cac03-95e2-4d30-84ad-9db244601de5)
<br>
#### 모달창
모달창은 웹 페이지 위에서 나타나는 팝업 창입니다.
주로 사용자에게 추가 정보를 제공하거나 다양한 작업을 수행하기 위해 활용됩니다. 
</details>


<details>
<summary>금액 설정 / 결제 </summary>

### 금액 설정 / 결제 까지
![결제까지](https://github.com/yyy2724/MovingMate/assets/93104606/dca13ac6-dfe1-4e7d-b502-4418af49cd40)
<br>
#### 아임포트 API
아임포트는 대한민국의 전자상거래 및 결제 시스템에서 사용되는 결제 연동 서비스 중 하나입니다. <br>
#### REST FUL
rest ful 하게 하여 새로고침 없이 적용되도록 하였습니다. <br>

#### 그 외
* 기업 회원은 고객들이 신청한 목록들을 확인할 수 있습니다.
* 권한, 거래 과정에 따른 권한 설정을 하였습니다.
* 헤더 바 등의 기본적인 프론트엔트를 꾸몄습니다. <br>

#### 결제 진행

</details>

<details>
<summary>권한별 리스트</summary>

### 권한에 따른 3개의 리스트
![img_11.png](img_11.png)
![img_12.png](img_12.png)
회사계정, 직원계정, 프리랜서계정에 따라 각기 다른 list목록들입니다.

#### JPA 쿼리
![img_13.png](img_13.png)
JPA를 이용하여 리스트병 paging, search 등의 쿼리기능을 구현하였습니다. 

</details>

<details>
<summary>날씨 API</summary>

### API를 이용하여 오늘 날씨 가져오기
![img_14.png](img_14.png)
날씨와 지도를 보여주는 페이지입니다.

![img_15.png](img_15.png)
![img_16.png](img_16.png)
API에서 온도를 가져오는 코드입니다.

![img_17.png](img_17.png)
![img_18.png](img_18.png)
온도를 DB에 저장하는 코드입니다.


### 챗봇 시나리오
![img_19.png](img_19.png)
챗봇에 "서울 날씨"를 치면 나오는 정보입니다.
![img_21.png](img_21.png)
![img_22.png](img_22.png)
정보(온도)를 나타나게 하는 코드입니다.




![img_20.png](img_20.png)
챗봇에 지도를 나타나게 하는 script 코드입니다.

</details>
