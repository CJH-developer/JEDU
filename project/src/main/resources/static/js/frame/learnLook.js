var learn_checkBox = document.querySelectorAll(".learn_checkBox");
	for(var i=0; i<learn_checkBox.length; i++){
		learn_checkBox[i].addEventListener("click", function(){
			console.log(event.target.value);
		})
}