document.querySelectorAll(".memberLookUp").forEach(button => {
  button.addEventListener("click", function() {
      var userNo = this.value; // 클릭된 버튼의 값 가져오기
      fetchUserData(userNo); // 서버로 값 전송
  });
});

function fetchUserData(userNo) {
  fetch("/admin/userSelect?user_no=" + userNo)
      .then(response => response.json())
      .then(data => {
          
          document.getElementById("item__first__name").value = data.user_name;
          document.getElementById("item__first__role").value = convertUserRole(data.user_role);
          document.getElementById("item__first__gender").value = convertUserGender(data.user_gender);
          document.getElementById("item__second__phone").value = data.user_phone;
          document.getElementById("item__second__email").value = data.user_email;
          document.getElementById("item__third__address").value = data.user_address;
          document.getElementById("item__third__birth").value = data.user_birth;
          document.getElementById("item__second__regDate").value = data.user_regDate;
      })
      .catch(error => console.error("Error:", error));
}

function convertUserRole(userRole) {
  
  if(userRole === '1' || userRole === 'ROLE_TEA'){
    return "교육자";
  }else if(userRole === '2' || userRole === 'ROLE_STU'){
    return "학생";
  }else if(userRole === '3' || userRole === 'ROLE_GEN'){
    return "일반";
  }
  return "";
}

function convertUserGender(userGender){

  if(userGender === 'w'){
    return "여성";
  }else{
    return "남성"
  }

}

