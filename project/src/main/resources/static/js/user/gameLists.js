var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.querySelectorAll("#myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("material-symbols-outlined")[0];

// When the user clicks the button, open the modal 
for(var i=0; i<btn.length; i++){

  btn[i].addEventListener("click", function(){
    modal.style.display = "block";
    test01();
    text02();
   text03();
    text04();
  
    
  });



// When the user clicks on <span> (x), close the modal
span.onclick = function(e) {
	e.preventDefault();
	
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
}}
function test01(){
	var spanText=document.querySelector('.class').textContent;
  document.querySelector('.gameContentInfo__wrap__mainTitle').textContent = spanText;

}


function text02(){
	var spanText2=document.querySelector(".game_price").textContent;

		

document.querySelector(".default__price1").textContent="정가 : "+spanText2;

}
function text03(){
	var spanText3=document.querySelector(".game_price").textContent;

		

document.getElementById("default__price").textContent="정가 : "+spanText3;

}



function text04(){
	var spanText4=document.querySelector(".game_target_level").textContent;
	
	
	document.getElementById("default__info").textContent="난이도 : "+spanText4;
}

  
}
