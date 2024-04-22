var modals9 = document.getElementById("myModal10");
var btn9 = document.querySelectorAll(".myBtns8"); // 여러 버튼을 선택
var spans = document.getElementsByClassName("closes")[0]; // 닫기 버튼

// 버튼에 클릭 이벤트 리스너를 추가
btn9.forEach(function(btn) {
  btn.addEventListener("click", function() {
    modals9.style.display = "block";
    updateModalContent(); // 각각의 값을 기반으로 모달 컨텐츠 업데이트
  });
});

function updateModalContent() {
  // 각각의 값을 찾아서 업데이트
  var spanText1 = document.querySelector(".class01").textContent;
  document.querySelector('.gameContentInfo__wrap__mainTitle2').textContent = spanText1;

  var spanText2 = document.querySelector(".class03").textContent;
  document.querySelector(".content__price1").textContent = "정가: " + spanText2;

  var spanText3 = document.querySelector(".class03").textContent;
  document.querySelector(".content__price").textContent = "할인가: " + spanText3;

  var spanText4 = document.querySelector(".class02").textContent;
  document.getElementById("content__info").textContent = "난이도: " + spanText4;

  var game = document.querySelector(".class04").value;
  var games = document.querySelector(".class05").value;
  document.querySelector(".content__price2").textContent = "학습기간: " + game + " ~ " + games;
}

// 닫기 버튼에 클릭 이벤트 리스너를 추가
spans.onclick = function(e) {
  e.preventDefault();
  modals9.style.display = "none";
}

// 모달 바깥 클릭 시 모달 닫기
window.onclick = function(event) {
  if (event.target == modals9) {
    modals9.style.display = "none";
  }
}

