/* // 로딩 열기
    function showLoading() {
        var screenWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
        var screenHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
        // 현재 스크롤 위치 가져오기
        var scrollX = window.scrollX || window.pageXOffset || document.documentElement.scrollLeft;
        var scrollY = window.scrollY || window.pageYOffset || document.documentElement.scrollTop;
        // 화면 중앙 좌표 계산
        var centerX = (scrollX + screenWidth / 2) - 30;
        var centerY = (scrollY + screenHeight / 2) - 12.7;
        $("#spinner").attr("style", "top:" + centerY + "px" + "; left:" + centerX + "px");
        document.querySelector("#loading").style.height = "100%";
        // body 스크롤 막기
        document.querySelector('body').classList.add('prev_loading');
        $('#loading').show();
        $('.loading p').show(); // 로딩 메시지 나타내기
        $(".body").css("opacity", "0.5");
    }
    // 로딩 닫기
    function closeLoading() {
        document.querySelector('body').classList.remove('prev_loading');
        $('#loading').hide();
        var screenWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
        var screenHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
        // 현재 스크롤 위치 가져오기
        var scrollX = window.scrollX || window.pageXOffset || document.documentElement.scrollLeft;
        var scrollY = window.scrollY || window.pageYOffset || document.documentElement.scrollTop;
        // 화면 중앙 좌표 계산
        var centerX = (scrollX + screenWidth / 2) - 30;
        var centerY = (scrollY + screenHeight / 2) - 12.7;
        document.querySelector("#loading").style.height = "100%";
        $("#spinner").attr("style", "top:" + centerY + "px" + "; left:" + centerX + "px");

        $(".looks__tbody").css("display", "block");
    }
   showLoading();
				setTimeout(function () {
                closeLoading();
            }, 4000);
            
*/
function simulateLoading() {
        var loadingSpinner = document.querySelector(".loading-wrap--js");
        var loadingMessage = document.getElementById("loadingMessage");
	
        // 로딩 시작
        loadingSpinner.style.display = "flex";
        loadingMessage.textContent = "AI가 추천할 만한 콘텐츠를 찾고 있는 중입니다.";

        // 1초 뒤에 로딩 완료
        setTimeout(function () {
          loadingSpinner.style.display = "none";
          loadingMessage.textContent = "완료!!";
        }, 3000);
      }

$(".ai_btn").click(function() {
		 $(".body").css("opacity", "0.5");
	    const user_no = $('#user_no').val();
	    console.log(user_no + "dfd");
	    simulateLoading();
	    $.get("/check/ai", {user_no: user_no})
	        .done(function(aiList) {
	          setTimeout(function () {
	            $(".body").css("opacity", "1");
	            displayStudyGroups(aiList);
				}, 3200);
	        })
	        .fail(function(error) {
	            console.log("실패");
	            $('#studyGroupList').html('<p>불러오는데 실패하였습니다.</p>'); 
	        });
	});
 
 function displayStudyGroups(aiList) {
	    var content = $(".looks__tbody").empty(); 

	    if (!aiList || aiList.length === 0) {
	        content.html('<div class="looks__tbody__content"><p>해당 유저에 추천할 만한 스터디 그룹이 없습니다.</p></div>');
	        return;
	    }

	    aiList.forEach(function(group, index) {
	        var html = `
	            <div class="looks__tbody__content">
	                <div id="looks__tbody__first">${index + 1}</div>
	                <a th:href="@{/student/groupApplyList(sg_no=${group.sg_no})}" id="looks__tbody__second">${group.sg_name}</a>
	                <div id="looks__tbody__third">${group.game_no}</div>
	                <div id="looks__tbody__fourth">${group.sg_capa}명 / ${group.sg_grouplimit}명</div>
	                <div id="looks__tbody__fifth">${group.sg_regdate} ~ ${group.sg_enddate}</div>
	                <div id="looks__tbody__sixth">${group.sg_level}레벨</div>
	                <div id="looks__tbody__seventh">${group.sg_capa}명</div>
	            </div>`;
	        content.append(html);  
	    });
	}
                    	
                    	
                    	
   
 /*   var isMouseMoved = false;
    document.addEventListener("DOMContentLoaded", function() {
    document.addEventListener("mousemove", (event) => {
        if (!isMouseMoved) {
            isMouseMoved = true;
            showLoading();
            setTimeout(function () {
                closeLoading();
            }, 4000);
            
        }
    });
  
        // 여기에 DOM이 완전히 로드된 후에 해야할 작업을 작성합니다.
    });*/
