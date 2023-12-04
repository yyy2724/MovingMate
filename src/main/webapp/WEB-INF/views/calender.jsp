<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js" defer></script>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.4/index.global.min.js'></script>


<head>
    <meta charset='utf-8'/>
    <%--    <script src='${pageContext.request.contextPath}/webapp/js/calender/calender.js'></script>--%>
    <input type="hidden" id="moveId" value="${moveEntity.id}"/>
    <input type="hidden" id="moveWriter" value="${moveEntity.moveWriter}"/>
    <input type="hidden" id="movePhone" value="${moveEntity.phone}"/>
    <input type="hidden" id="moveFirst" value="${moveEntity.firstAddress}"/>
    <input type="hidden" id="moveEnd" value="${moveEntity.endAddress}"/>
    <input type="hidden" id="moveType" value="${moveEntity.moveType}"/>

    <script>
        document.addEventListener('DOMContentLoaded', function () {

            var id = document.getElementById('moveId').value;
            var moveWriter = document.getElementById('moveWriter').value;
            var movePhone = document.getElementById('movePhone').value;
            var moveFirst = document.getElementById('moveFirst').value;
            var moveEnd = document.getElementById('moveEnd').value;
            var moveType = document.getElementById('moveType').value;

            var calendarEl = document.getElementById('calendar');


            var calendar = new FullCalendar.Calendar(calendarEl, {
                    headerToolbar: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
                    },
                    initialDate: '2023-01-12',
                    navLinks: true, // can click day/week names to navigate views
                    businessHours: true, // display business hours
                    editable: true,
                    selectable: true,
                    events: '/calendar/list',


                    dateClick: function (info) {
                        if (confirm("이 날짜로 하시겠습니까?")) {


                            var eventData = {
                                id: id,
                                moveWriter: moveWriter,
                                phone: movePhone,
                                firstAddress: moveFirst,
                                endAddress: moveEnd,
                                moveType: moveType,
                                start: info.date
                                // 이벤트에 대한 다양한 정보 추가 가능
                            };
                            console.log(eventData)

                            $.ajax({
                                    type: 'POST',
                                    url: '/addEvent',
                                    contentType: 'application/json',
                                    data: JSON.stringify(eventData),
                                    success: function (response) {
                                        alert('날짜 설정 완료')

                                        // 지정된 이벤트의 정보 가져옴 캘린더에 추가
                                        calendar.addEvent({
                                            title: '이 날짜에 이사',
                                            start: info.date,

                                        });

                                        $.ajax({
                                            type: 'POST',
                                            url: '/order/order',
                                            contentType: 'application/json',
                                            data: JSON.stringify(eventData),
                                            success: function (response) {
                                                // 성공적으로 처리된 후 실행되는 코드
                                                console.log('이동이력이 전달되었습니다.');

                                                window.location.href = '/order/order?id=' + id + '&moveWriter=' + moveWriter + '&phone=' + movePhone + '&firstAddress=' + moveFirst + '&endAddress=' + moveEnd + '&moveType=' + moveType;

                                            },
                                            error: function (xhr, status, error) {
                                                // 에러 발생 시 실행되는 코드
                                                console.error('이동이력 전달 실패');
                                            }
                                        });

                                        // 이벤트를 다시 가져와 캘린더에 반영
                                        calendar.refetchEvents();
                                    },
                                    error: function (xhr, status, error) {
                                        alert('날짜 설정 실패!')
                                    }
                                }
                            );
                        }
                    }


                })
            ;

            calendar.render();
        });
    </script>

    <style>
        body {
            margin: 40px 10px;
            padding: 0;
            font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
            font-size: 14px;
        }

        #calendar {
            max-width: 1100px;
            margin: 0 auto;
        }
    </style>
    <title></title>
</head>
<body>

<div id='calendar'></div>
</body>
