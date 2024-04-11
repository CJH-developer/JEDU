//내 학습그룹 불러오기
$("#myGroup").click(function() {
	var userNo = $("#user_no").val();
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
			alert("내 학습그룹 불러오기 성공");
		},
		error: function(status, err) {
			console.log(status, err, "에러남")
			alert("에러")
		}
	})
	console.log(userNo);
})

// 일단 조회하기 누르면 값은 나옴
$("#searchGroup").click(function() {
	console.log($("#selectGroup").val());
})

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


