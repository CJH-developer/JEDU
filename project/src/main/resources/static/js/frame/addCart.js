const toCart = document.getElementById("toCart"); /*장바구니로 이동*/

const content__purchase = document.getElementById('content__purchase');

/*장바구니 추가시 나타나는 메세지*/
const cartMessages = document.querySelectorAll('#cartMessage');
const paidMessages = document.querySelectorAll('#paidMessage');
const inCartMessages = document.querySelectorAll('#inCartMessage');
const alreadyInCarts = document.querySelectorAll('#content__alreadyInCart');

const content__baskets = document.querySelectorAll(".tbody__item #content__basket");

for (let i = 0; i < content__baskets.length; i++) {
    content__baskets[i].onclick = function() {
        const user_no = $('#user_no').val();
        const game_no = this.closest('.tbody__item').querySelector('[name="game_no"]').value;

        console.log(user_no);
        console.log(game_no);
		
		$.get('/check/purchase', {user_no: user_no, game_no: game_no})
		 .done(function(paid) {
			 if(paid == false){
			  	paidMessages.forEach(function(paidMessage) {
                    paidMessage.style.display = "block";
                    clearTimeout(paidMessage.timeoutId);
                    paidMessage.classList.add('visible');
                    paidMessage.style.opacity = '1';
                    paidMessage.timeoutId = setTimeout(function() {
                        paidMessage.style.opacity = '0';
                    }, 2000);
                });
			 } else {
		        $.get('/check/cart', {user_no: user_no, game_no: game_no})
		            .done(function(checkData) {
		                console.log(checkData);
		                if (checkData == false) {
		                    inCartMessages.forEach(function(inCartMessage) {
                                inCartMessage.style.display = "block";
                                clearTimeout(inCartMessage.timeoutId);
                                inCartMessage.classList.add('visible');
                                inCartMessage.style.opacity = '1';
                                inCartMessage.timeoutId = setTimeout(function() {
                                    inCartMessage.style.opacity = '0';
                                }, 2000);
                            });
		                } else {
		                    $.get('/add/cart', {user_no: user_no, game_no: game_no})
		                        .done(function(data) {
		                            console.log("성공");
		                            console.log(data);
		                            alreadyInCarts.forEach(function(alreadyInCart) {
                                        alreadyInCart.style.display = "block";
                                        clearTimeout(alreadyInCart.timeoutId);
                                        alreadyInCart.classList.add('visible');
                                        alreadyInCart.style.opacity = '1';
                                        alreadyInCart.timeoutId = setTimeout(function() {
                                            alreadyInCart.style.opacity = '0';
                                        }, 2000);
                                    });
		                        })
		                        .fail(function(error) {
		                            console.log("추가 실패");
		                        });
		                }
		            })
		            .fail(function(error) {
		                console.log("Check 실패");
		            });
                }
            })
             .fail(function(error) {
		                console.log("Check 실패");
		   });
    }
}

