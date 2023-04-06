
function checkValues(htmlForm) {

	// 항목의 값이 없으면 -> /join 페이지로 이동 ( 기존 입력된 항목을 파라미터로 들고감)
	// ㄴ 입력되지 않은 항목에 대한 alert() & join.jps 이동하면서 focus 넘기기

	// 읽어올 값들을 url 에 담아줌 
	let url = "join?";

	const cuscode = document.getElementById("cuscode").value;
	const cusname = document.getElementById("cusname").value;
	const contact = document.getElementById("contact").value;
	const email = document.getElementById("email").value;
	const id = document.getElementById("id").value;
	const password = document.getElementById("password").value;
	const age = document.getElementById("age").value;
	const joindate = document.getElementById("joindate").value;

	let check = true;

	if (cusname != "")
		url += "&cusname=" + cusname;
	if (contact != "")
		url += "&contact=" + contact;
	if (email != "")
		url += "&email=" + email;
	if (id != "")
		url += "&id=" + id;
	if (password != "")
		url += "&password=" + password;
	if (age != "")
		url += "&age=" + age;
	if (joindate != "")
		url += "&joindate=" + joindate;


	if (cusname === "") {
		alert('이름이 입력되지 않았습니다.');
		check = false;
	}
	else if(contact === ""){
		alert('연락처가 입력되지 않았습니다.');
		check = false;
	}
	else if(email === ""){
		alert('이메일이 입력되지 않았습니다.');
		check = false;
	}
	else if(id === ""){
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	}
	else if(password === ""){
	    alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}
	else if(age === ""){
		alert('나이가 입력되지 않았습니다.');
		check = false;
	}
	else if(joindate === ""){
		alert('가입날짜가 입력되지 않았습니다.');
		check = false;
	}

	if(check == false) {
		location.href=url;
	}
	
	else{
		htmlForm.submit();
	}

}