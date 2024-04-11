// 드롭다운 메뉴
var coll = document.getElementsByClassName("section__sub__menu");

for (var i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    // 현재 클릭된 메뉴 요소
    var currentMenu = this;
    
    // 현재 클릭된 메뉴의 드롭다운 컨텐츠
    var content = currentMenu.nextElementSibling;
    
    // 현재 클릭된 메뉴를 제외한 다른 모든 드롭다운 메뉴 닫기
    for (var j = 0; j < coll.length; j++) {
      if (coll[j] !== currentMenu) {
        coll[j].classList.remove("activess");
        coll[j].nextElementSibling.style.maxHeight = null;
      }
    }

    // 현재 클릭된 메뉴의 드롭다운 메뉴 열고 닫기
    currentMenu.classList.toggle("activess");
    if (content.style.maxHeight){
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
    } 
  });
}


// 상단 타이틀 표출 /////////////////////////////////////////////////////////////////
var section__sub__menu = document.querySelectorAll(".section__sub__menu");

// section__sub__menu의 클릭 이벤트 리스너 설정
section__sub__menu.forEach(function(item) {
    item.addEventListener("click", function() {
        // 클릭된 버튼의 값 가져오기
        var mainMenuTitle = this.value;
        document.getElementById("displayMenu").style = "display : block";
        // 클릭된 버튼의 값 표시
        document.getElementById("displayMenu").innerText = mainMenuTitle;
        document.getElementById("displayMenu2").innerText = "";
        document.getElementById("title").innerText = "";
    });
});

var small__menu = document.querySelectorAll(".small__menu");

// small__menu의 클릭 이벤트 리스너 설정
small__menu.forEach(function(item) {
    item.addEventListener("click", function() {
        // 클릭된 작은 메뉴의 제목 가져오기
        var subMenuTitle = '▶' + this.dataset.title;
        var bigMenuTitle = this.dataset.title;
        // 현재 표시된 메인 메뉴의 제목 가져오기
        var mainMenuTitle = document.getElementById("displayMenu").innerText;
        
        // 메인 메뉴와 작은 메뉴의 제목 결합하여 표시
        document.getElementById("displayMenu").style = "display : none";
        document.getElementById("displayMenu2").innerText = mainMenuTitle + ' ' + subMenuTitle;
        document.getElementById("title").innerText = bigMenuTitle;
    });
});




// 달력
const makeCalendar = (date) => {
  const currentYear = new Date(date).getFullYear();
  const currentMonth = new Date(date).getMonth() + 1;

  const firstDay = new Date(date.setDate(1)).getDay();
  const lastDay = new Date(currentYear, currentMonth, 0).getDate();

  const limitDay = firstDay + lastDay;
  const nextDay = Math.ceil(limitDay / 7) * 7;

  let htmlDummy = '';

  for (let i = 0; i < firstDay; i++) {
    htmlDummy += `<div class="noColor"></div>`;
  }

  for (let i = 1; i <= lastDay; i++) {    
    htmlDummy += `<div>${i}</div>`;
  }

  for (let i = limitDay; i < nextDay; i++) {
    htmlDummy += `<div class="noColor"></div>`;
  }

  document.querySelector(`.dateBoard`).innerHTML = htmlDummy;
  document.querySelector(`.dateTitle`).innerText = `${currentYear}년 ${currentMonth}월`;
}

const date = new Date();

makeCalendar(date);

// 이전달 이동
document.querySelector(`.prevDay`).onclick = () => {
makeCalendar(new Date(date.setMonth(date.getMonth() - 1)));
}

// 다음달 이동
document.querySelector(`.nextDay`).onclick = () => {
makeCalendar(new Date(date.setMonth(date.getMonth() + 1)));
}


$(window).on("load resize ", function() {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({'padding-right':scrollWidth});
}).resize();


// swiper
var swiper = new Swiper('.swiper', {
  slidesPerView: 4,
  direction: getDirection(),
  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },
  on: {
    resize: function () {
      swiper.changeDirection(getDirection());
    },
  },
});

function getDirection() {
  var windowWidth = window.innerWidth;
  var direction = window.innerWidth <= 760 ? 'vertical' : 'horizontal';

  return direction;
}

