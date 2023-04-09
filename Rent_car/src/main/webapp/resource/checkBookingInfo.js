
function checkBookingInfo(htmlForm) {

	let url = "booking?";

	const bookCode = document.getElementById("bookCode").value;
	const carName = document.getElementById("carName").value;
	const venueId = document.getElementById("venueId").value;
	const cusName = document.getElementById("cusName").value;
	const startDate = document.getElementById("startDate").value;
	const startHour = document.getElementById("startHour").value;
	const periodDate = document.getElementById("periodDate").value;
	const endHour = document.getElementById("endHour").value;

	let check = true;

	if (bookCode != "")
		url += "&bookCode=" + bookCode;
	if (carName != "")
		url += "&carName=" + carName;
	if (venueId != "")
		url += "&email=" + venueId;
	if (cusName != "")
		url += "&cusName=" + cusName;
	if (startDate != "")
		url += "&startDate=" + startDate;
	if (startHour != "")
		url += "&startHour=" + startHour;
	if (periodDate != "")
		url += "&periodDate=" + periodDate;
	if (endHour != "")
		url += "&endHour=" + endHour;
		

 	// alert
	if(venueId === "0") {
		alert('대여장소가 선택되지 않았습니다.');
		check = false;
	}
	else if(cusName === "") {
		alert('예약자명을 입력해주세요.');
		check = false;
	}
	else if(startDate === "") {
		alert('대여일 선택되지않았습니다.');
		check = false;
	}
	else if(startHour === "") {
		alert('대여시작시간이 선택되지않았습니다.');
		check = false;
	}
	else if(periodDate === "") {
		alert('반납일이 선택되지않았습니다.');
		check = false;
	}
	else if(endHour === "") {
		alert('반납시간이 선택되지않았습니다.');
		check = false;
	}
	

	if(check == false) {
		location.href=url;
	}
	
	else{
		htmlForm.submit();
	}
	
}