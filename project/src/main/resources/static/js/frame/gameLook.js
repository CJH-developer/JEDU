var game_checkBox = document.querySelectorAll(".game_checkBox");
	for(var i=0; i<game_checkBox.length; i++){
		game_checkBox[i].addEventListener("click", function(){
			console.log(event.target.value);
		})
}