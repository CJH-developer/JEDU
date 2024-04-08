
const cartModal = document.getElementById("addCartModal");
const content__basket = document.getElementById("content__basket");
const span = document.getElementsByClassName("close")[0];
const toCart = document.getElementById("toCart");
const content__complCart = document.getElementById('content__complCart');
const content__purchase = document.getElementById('content__purchase');

    
    content__basket.onclick = function() {

      cartModal.style.display = "block";
      
	  const user_no = $('#user_no').val();

	  const game_no = $('#game_no').val();
	  
	  console.log(user_no);
	  console.log(game_no);
	  

    	  $.get('/add/cart', {
              user_no: user_no,
              game_no : game_no
          })
          .done(function(data) {
              console.log("성공");
              console.log(data);
              content__complCart.style.display = "block";
    	  	  content__basket.style.display = "none";
    	  	  content__purchase.style.display = "none";
          })
          .fail(function(error) {
              console.log("실패");
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
    
    
