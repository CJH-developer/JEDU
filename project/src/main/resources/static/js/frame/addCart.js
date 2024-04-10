const cartModal = document.getElementById("addCartModal");
const content__basket = document.getElementById("content__basket");
const span = document.getElementsByClassName("close")[0];
const toCart = document.getElementById("toCart");
const content__complCart = document.getElementById('content__complCart');
const content__purchase = document.getElementById('content__purchase');
const content__alreadyInCart = document.getElementById('content__alreadyInCart');
const cartMessage = document.getElementById('cartMessage');
const inCartMessage = document.getElementById('inCartMessage'); 


content__basket.onclick = function() {

	  const user_no = $('#user_no').val();
	  const game_no = $('#game_no').val();
	  
	  console.log(user_no);
	  //console.log(game_no);

    	  $.get('/check/cart', {user_no: user_no, game_no : game_no})
           .done(function(checkData) {
		      console.log(checkData);
			  if(checkData == false){
				  inCartMessage.style.display = "block";
				  content__alreadyInCart.style.display = "block";
				  content__basket.style.display = "none";
	              content__purchase.style.display = "none";
	              
	              clearTimeout(inCartMessage.timeoutId); 
					inCartMessage.classList.add('visible'); 
					inCartMessage.style.opacity = '1'; 
					inCartMessage.timeoutId = setTimeout(function() {
						inCartMessage.style.opacity = '0'; 
					}, 2000)
	              
			  } else {
				
	            $.get('/add/cart', { user_no: user_no, game_no: game_no})
	            .done(function(data) {
	                console.log("성공");
	                console.log(data);
	                
	                clearTimeout(cartMessage.timeoutId); 
					cartMessage.classList.add('visible'); 
					cartMessage.style.opacity = '1'; 
					cartMessage.timeoutId = setTimeout(function() {
						cartMessage.style.opacity = '0'; 
					}, 2000)
	                
	                content__basket.style.display = "none";
	                content__purchase.style.display = "none";
	            })
	            .fail(function(error) {
	                console.log("추가 실패");
	            });
	          }
	         })
	        .fail(function(error){
				console.log("Check 실패");
			});
    }
    
    span.onclick = function() {
      cartModal.style.display = "none";
    }

    window.onclick = function(event) {
      if (event.target == cartModal) {
      cartModal.style.display = "none";
      
      }else if (event.target == toCart){
        window.location.href="/command/cart"
      }
    };
/*  

	for(var i=0; i<content__basket.length; i++){
		content__basket[i].addEventListener("click", function(){
			
		})
	}
*/
