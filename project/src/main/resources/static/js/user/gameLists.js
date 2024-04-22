

var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.querySelectorAll(".myBtn");


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
for (var i = 0; i < btn.length; i++) {
  btn[i].addEventListener("click", function() {
    modal.style.display = "block";
    updateModalContent(); // 각각의 값을 기반으로 모달 컨텐츠 업데이트
  });


function updateModalContent() {
  // 각각의 값을 찾아서 업데이트
  var spanText1 = document.querySelector(".class").textContent;
  document.querySelector('.gameContentInfo__wrap__mainTitle').textContent = spanText1;

  var spanText2 = document.querySelector(".game_price").textContent;
  document.querySelector(".default__price12").textContent = " 정가 : " + spanText2;

  var spanText3 = document.querySelector(".game_price").textContent; // 만약 class03이 여러 값을 가진다면, 이 부분은 조정이 필요합니다.
  document.querySelector(".default__price").textContent = "할인가 : " + spanText3;

  var spanText4 = document.querySelector(".game_target_level").textContent;
  document.querySelector(".default__info2").textContent = "난이도 : " + spanText4;

  var game = document.querySelector(".game").value;
  var games = document.querySelector(".games").value;
  document.querySelector(".default__price2").textContent = " 학습기간 : " + games + " ~ " +  game;
}

// When the user clicks on <span> (x), close the modal
span.onclick = function(e) {
  e.preventDefault();
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
}


