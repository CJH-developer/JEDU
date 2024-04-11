//내 학습그룹 불러오기
$("#myGroup").click(function() {
	var userNo = $("#user_no").val();
	
	// 성공했습니다 간지나게 하기
	const cartMessage = document.getElementById('cartMessage');
	const inCartMessage = document.getElementById('inCartMessage'); 	
	
	inCartMessage.style.display = "block";
	
	              clearTimeout(inCartMessage.timeoutId); 
					cartMessage.classList.add('visible'); 
					cartMessage.style.opacity = '1'; 
					cartMessage.timeoutId = setTimeout(function() {
						cartMessage.style.opacity = '0'; 
					}, 2000)
	
	$.ajax({
		url: "/mygroup/" + userNo,
		method: "GET",
		success: function(data) {
			var selectElement = $("#selectGroup")
			selectElement.empty();
			
			data.forEach(function(group) {
				selectElement.append($('<option>', {
		            value: group.sg_no, // 그룹 번호
		            text: group.sg_name // 그룹 이름
				}));
			})
		},
		error: function(status, err) {
			console.log(status, err, "에러남")
			alert("에러")
		}
	})
	console.log(userNo);
})


/* 조회하기 눌렀을 때, 값들 */
$("#searchGroup").click(function() {
    var SG_NO = $("#selectGroup").val();
    
    $.ajax({
        url: "/groupDetail/" + SG_NO,
        method: "GET",
        success: function(data) {
            console.log(data);

            // 그룹 디테일 채우기
            $(".grl__bbt__one").text(data.groupdetail.game_title);
            $(".grl__bbt__two").text(data.groupdetail.game_target_level);
            $(".grl__bbt__three").text("일단 대기");
            $(".grl__bbt__four").text(data.groupdetail.sg_capa);
            $(".grl__bbt__five").text(data.groupdetail.sg_grouplimit);

            // 승인 요청 내역 채우기
            $(".grl__bbb__tbody").empty(); // 이전 데이터 삭제

            data.boys.forEach(function(boy, index) {
                var $row = $('<div class="grl__bbtb__wrap">');
                $row.append('<div class="grl_bttbb__one">' + (index + 1) + '</div>');
                $row.append('<div class="grl_bttbb__two">' + boy.user_name + '</div>');
                $row.append('<div class="grl_bttbb__three">' + boy.user_phone + '</div>');
                $row.append('<div class="grl_bttbb__four">' + boy.user_regdate + '</div>');
                $row.append('<div class="grl_bttbb__five"><input type="checkbox" class="checkbox"></div>');

                $(".grl__bbb__tbody").append($row);
            });
        }
    });
});

// 체크박스 누르면 값 받아와보기
    $('.checkbox').change(function() {
        if ($(this).is(':checked')) {
            var row = $(this).closest('.grl__bbtb__wrap');
            var name = row.find('.grl_bttbb__two').text();
            var phoneNumber = row.find('.grl_bttbb__three').text();
            var date = row.find('.grl_bttbb__four').text();
            console.log("Name: " + name + ", Phone Number: " + phoneNumber + ", Date: " + date);
            // 여기에서 필요한 작업을 수행하세요
        }
    });
    




