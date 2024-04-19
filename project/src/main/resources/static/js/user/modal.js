var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.querySelectorAll("#myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("material-symbols-outlined")[0];

// When the user clicks the button, open the modal 
for(var i=0; i<btn.length; i++){

  btn[i].addEventListener("click", function(){
    modal.style.display = "block";
  });

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