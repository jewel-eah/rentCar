

function checkLoginInfo(htmlForm){

	let url = "login?";

	const id = document.getElementById("id").value;
	const password = document.getElementById("password").value;

	let check = true;

	if (id != "") {
		url += "&id=" + id;
	}

	if (password != "") {
		url += "&password=" + password;
	}

	if (id === "") {
		alert('아이디를 확인해주세요.');
		check = false;
	}
	else if (password === "") {
		alert('비밀번호를 확인해주세요.');
		check = false;
	}

	if (check == false) {
		location.href = url;
	}
	else {
		htmlForm.submit();
	}
}