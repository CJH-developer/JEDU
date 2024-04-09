/* 장바구니 목록 불러오기 */
$(document).ready(function() {
	
    const user_no = document.getElementById("user_no").value;
    console.log(user_no);

  	$.get('/list/cart', {user_no: user_no})
  	 .done(function(data){
  		 console.log("성공")
  	 })
  	 .fail(function(error){
  		 console.log("실패")
  	 });
  });
