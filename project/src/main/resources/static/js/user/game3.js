var modals3 = document.getElementById("myModal4");
var btn3 = document.querySelectorAll(".myBtns2");
var spans3 = document.getElementsByClassName("closes")[0];
// When the user clicks the button, open the modal
for (var i = 0; i < btn3.length; i++) {
  btn3[i].addEventListener("click", function() {
    modals3.style.display = "block";
    updateModalContent(); // 각각의 값을 기반으로 모달 컨텐츠 업데이트
  });


function updateModalContent() {
  // 각각의 값을 찾아서 업데이트
  var spanText1 = document.querySelector(".class01").textContent;
  document.querySelector('.gameContentInfo__wrap__mainTitle2').textContent = spanText1;

  var spanText2 = document.querySelector(".class03").textContent;
  document.querySelector(".content__price1").textContent = " 정가 : " + spanText2;

  var spanText3 = document.querySelector(".class03").textContent; // 만약 class03이 여러 값을 가진다면, 이 부분은 조정이 필요합니다.
  document.querySelector(".content__price").textContent = "할인가 : " + spanText3;

  var spanText4 = document.querySelector(".class02").textContent;
  document.getElementById("content__info").textContent = "난이도 : " + spanText4;

  var game = document.querySelector(".class04").value;
  var games = document.querySelector(".class05").value;
  document.querySelector(".content__price2").textContent = " 학습기간 : " + game + " ~ " + games;
}

// When the user clicks on <span> (x), close the modal
spans3.onclick = function(e) {
  e.preventDefault();
  modals3.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modals3) {
    modals3.style.display = "none";
  }
}
}