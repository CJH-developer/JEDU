// 체크 박스 클릭시 value 값 호출
var game_checkBox = document.querySelectorAll(".game_checkBox");
	for(var i=0; i<game_checkBox.length; i++){
		game_checkBox[i].addEventListener("click", function(){
			console.log(event.target.value);
		})
}


document.addEventListener('DOMContentLoaded', function() {
        var levelSelect = document.getElementById('levelSelect');
        var initialLevel = levelSelect.value; // 초기 선택된 레벨 가져오기

        // 페이지 로드 시 초기 선택된 레벨에 따라 AJAX 요청을 보냄
        sendAjaxRequest(initialLevel);

        // 레벨 선택이 변경될 때마다 AJAX 요청 보내고 페이지 업데이트
        levelSelect.addEventListener('change', function() {
            var selectedLevel = levelSelect.value;
            sendAjaxRequest(selectedLevel);
        });

        function sendAjaxRequest(level) {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/level?level=' + level, true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        // 서버에서 성공적으로 데이터를 받았을 때 처리
                        var gameContentContainer = document.getElementById('gameContentContainer');
                        gameContentContainer.innerHTML = xhr.responseText;
                    } else {
                        console.error('서버에서 오류가 발생했습니다.');
                    }
                }
            };
            xhr.send();
        }
    });