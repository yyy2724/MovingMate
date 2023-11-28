function oninputPhone(target) {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
}

function firstAddressList() {
    new daum.Postcode({
        oncomplete: function (data) {
            var addr = ''; // 주소 변수
            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.

            addr = data.sido + ' ' + data.sigungu + ' ' + data.bname;
            document.getElementById("firstAddress").value = addr;
        }
    }).open();
}
function endAddressList() {
    new daum.Postcode({
        oncomplete: function (data) {
            var addr = ''; // 주소 변수
            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.

            addr = data.sido + ' ' + data.sigungu + ' ' + data.bname;
            document.getElementById("endAddress").value = addr;
        }
    }).open();
}