// 비밀번호 유효성 검사 
function checkPassword() {	
	var pwd1 = document.getElementById('memberPwd');
	var helper = document.getElementById('pwdHelper');
	var memberPwdRegExp = /^[a-zA-Z0-9]{8,16}$/;
	
	if(document.getElementById('memberPwd').value != '') {
		if(!memberPwdRegExp.test(pwd1.value)) {
			helper.style.color = 'red';
			pwd1.value = "";
			pwd1.focus();
		} else {
			helper.style.color = 'blue';
		}
	}	
}

// 비밀번호 일치 확인 
function isSame() {
	var pwd1 = document.getElementById('memberPwd');
	var pwd2 = document.getElementById('memberPwd2');
	var same = document.getElementById('same');
	
	if(document.getElementById('memberPwd2').value != '') {
		if(pwd1.value == pwd2.value) {
			same.innerHTML = '비밀번호가 일치합니다.';
			same.style.color = 'blue';
		} else {
			same.innerHTML = '비밀번호 확인이 올바르지 않습니다.';
			same.style.color = 'red';
			pwd2.focus();
		}
	}
}

// 회원가입 전 검사 
function checkBeforeSubmit() {
	var pwd1 = document.getElementById('memberPwd');
	var pwd2 = document.getElementById('memberPwd2');
	var memberPwdRegExp = /^[a-zA-z0-9]{8,16}$/;
	
	if(!memberPwdRegExp.test(pwd1.value)) {
		return false;	
	}
	
	if(pwd1.value != pwd2.value) {
		return false;
	}
	
	return true;
}