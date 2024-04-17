document.addEventListener("DOMContentLoaded", function() {
  var startDateInput = document.getElementById("lg-startDate");
  var endDateInput = document.getElementById("lg-endDate");
  var resultDiv = document.getElementById("lg__month");

  startDateInput.addEventListener("change", calculateDifference);
  endDateInput.addEventListener("change", calculateDifference);

  function calculateDifference() {
      if (startDateInput.value && endDateInput.value) {
          var startDate = new Date(startDateInput.value);
          var endDate = new Date(endDateInput.value);

          var differenceInTime = endDate.getTime() - startDate.getTime();
          var differenceInDays = Math.floor(differenceInTime / (1000 * 3600 * 24));

          var months = Math.floor(differenceInDays / 30);
          var daysLeft = differenceInDays % 30;

          resultDiv.textContent = months + "개월 " + daysLeft + "일";
          document.getElementById("pre__head__date").innerHTML = months + "개월 " + daysLeft + "일";
      } else {
          resultDiv.textContent = "";
      }
  }
});


document.getElementById("learn__group__title").oninput = function() {
  var learn__group__title = document.getElementById("learn__group__title").value;
  document.getElementById("pre__title").innerHTML = learn__group__title;
};

document.getElementById("learn__group__limit").oninput = function() {
  var learn__group__limit = document.getElementById("learn__group__limit").value;
  document.getElementById("pre__head__limit").innerHTML = learn__group__limit + " 명";
};

document.getElementById("learn__group__level").oninput = function() {
  var learn__group__level = document.getElementById("learn__group__level").value;
  document.getElementById("pre__head__level").innerHTML = learn__group__level + " 레벨";
};

// 모달창(팝업으로 내 구매이력 가져오기)
var button = document.querySelector('.lg__tbody__one button');

// 버튼 클릭 이벤트 핸들러 등록
button.addEventListener('click', function() {
  // 모달 창 열기
  var modal = window.open('myproductPopup', 'popup', 'width=1400,height=1200');

});