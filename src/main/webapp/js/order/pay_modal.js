/* 결제 모달 창 - 02.14 */
const inputH = document.querySelector('.inputMonthH') //결제 개월 수 입력받는 inputhidden
const amountV = document.querySelector('.amountValue');
const modal1 = document.querySelector('.modal');
const closebtn = document.querySelector('.closebtn');
const amount = document.querySelector('.amount');

function modal(){ //결제창 on-off
    modal1.style.display = 'block';
}
closebtn.addEventListener('click', function(){
    modal1.style.display = 'none';
});

//결제 개월 수 view에 hidden으로 출력
// function monthSelect(e){
//     const paynum = (15000*e.value);
//     inputH.value = e.value;
//     amount.textContent = "결제 금액 : " + paynum + "원";
//     amountV.value = paynum;
// }