
function showinfor() {
	var dis1 = document.getElementById("lookinfor").style.display;
	var dis2 = document.getElementById("billlist").style.display;
	var dis3 = document.getElementById("errorinfor").style.display;
	if (dis1 == 'none' && dis2 == 'none' && dis3 == 'none') {
		document.getElementById("lookinfor").style.display = "block";
		document.getElementById("billlist").style.display = "block";
		document.getElementById("errorinfor").style.display = "block";
		document.getElementById("userinfor").style.display = "none";
		document.getElementById("workerinfor").style.display = "none";
		document.getElementById("adduser").style.display = "none";
		document.getElementById("NULL1").style.display = "none";
		document.getElementById("NULL2").style.display = "none";
		document.getElementById("NULL3").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#dbe6f4";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#f2f2f2";
		document.getElementById("td2").style.backgroundColor = "#f2f2f2";
		document.getElementById("td7").style.backgroundColor = "#f2f2f2";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	else {
		document.getElementById("lookinfor").style.display = "none";
		document.getElementById("billlist").style.display = "none";
		document.getElementById("errorinfor").style.display = "none";
		document.getElementById("userinfor").style.display = "none";
		document.getElementById("workerinfor").style.display = "none";
		document.getElementById("adduser").style.display = "none";
		document.getElementById("NULL1").style.display = "block";
		document.getElementById("NULL2").style.display = "block";
		document.getElementById("NULL3").style.display = "block";
		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}

}
function showuser() {
	var dis1 = document.getElementById("userinfor").style.display;
	var dis2 = document.getElementById("workerinfor").style.display;
	var dis4 = document.getElementById("adduser").style.display;
	if (dis1 == 'none' && dis2 == 'none' && dis4 == 'none') {
		document.getElementById("userinfor").style.display = "block";
		document.getElementById("workerinfor").style.display = "block";
		document.getElementById("adduser").style.display = "block";
		document.getElementById("lookinfor").style.display = "none";
		document.getElementById("billlist").style.display = "none";
		document.getElementById("errorinfor").style.display = "none";
		document.getElementById("NULL1").style.display = "none";
		document.getElementById("NULL2").style.display = "none";
		document.getElementById("NULL3").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#dbe6f4";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#f2f2f2";
		document.getElementById("td4").style.backgroundColor = "#f2f2f2";
		document.getElementById("td6").style.backgroundColor = "#f2f2f2";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	else {
		document.getElementById("userinfor").style.display = "none";
		document.getElementById("workerinfor").style.display = "none";
		document.getElementById("adduser").style.display = "none";
		document.getElementById("lookinfor").style.display = "none";
		document.getElementById("billlist").style.display = "none";
		document.getElementById("errorinfor").style.display = "none";
		document.getElementById("NULL1").style.display = "block";
		document.getElementById("NULL2").style.display = "block";
		document.getElementById("NULL3").style.display = "block";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
}

function showequipment() {
	document.getElementById("userinfor").style.display = "none";
	document.getElementById("workerinfor").style.display = "none";
	document.getElementById("adduser").style.display = "none";
	document.getElementById("lookinfor").style.display = "none";
	document.getElementById("billlist").style.display = "none";
	document.getElementById("errorinfor").style.display = "none";
	document.getElementById("NULL1").style.display = "block";
	document.getElementById("NULL2").style.display = "block";
	document.getElementById("NULL3").style.display = "block";
	showpage(8);
}
function shownotice() {
	document.getElementById("userinfor").style.display = "none";
	document.getElementById("workerinfor").style.display = "none";
	document.getElementById("adduser").style.display = "none";
	document.getElementById("lookinfor").style.display = "none";
	document.getElementById("billlist").style.display = "none";
	document.getElementById("errorinfor").style.display = "none";
	document.getElementById("NULL1").style.display = "block";
	document.getElementById("NULL2").style.display = "block";
	document.getElementById("NULL3").style.display = "block";
	showpage(9);
}
function showdata() {
	document.getElementById("userinfor").style.display = "none";
	document.getElementById("workerinfor").style.display = "none";
	document.getElementById("adduser").style.display = "none";
	document.getElementById("lookinfor").style.display = "none";
	document.getElementById("billlist").style.display = "none";
	document.getElementById("errorinfor").style.display = "none";
	document.getElementById("NULL1").style.display = "block";
	document.getElementById("NULL2").style.display = "block";
	document.getElementById("NULL3").style.display = "block";
	showpage(10);
}
function showpage(page) {
	if (page == 1) {
		document.getElementById("page1").style.display = "block";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page6").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#dbe6f4";
		document.getElementById("td2").style.backgroundColor = "#f2f2f2";
		document.getElementById("td7").style.backgroundColor = "#f2f2f2";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";

	}
	if (page == 2) {
		document.getElementById("page2").style.display = "block";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page6").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#f2f2f2";
		document.getElementById("td2").style.backgroundColor = "#dbe6f4";
		document.getElementById("td7").style.backgroundColor = "#f2f2f2";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";

	}
	if (page == 3) {
		document.getElementById("page3").style.display = "block";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page6").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#dbe6f4";
		document.getElementById("td4").style.backgroundColor = "#f2f2f2";
		document.getElementById("td6").style.backgroundColor = "#f2f2f2";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	if (page == 4) {
		document.getElementById("page4").style.display = "block";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page6").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#f2f2f2";
		document.getElementById("td4").style.backgroundColor = "#dbe6f4";
		document.getElementById("td6").style.backgroundColor = "#f2f2f2";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}

	if (page == 6) {
		document.getElementById("page6").style.display = "block";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#f2f2f2";
		document.getElementById("td4").style.backgroundColor = "#f2f2f2";
		document.getElementById("td6").style.backgroundColor = "#dbe6f4";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	if (page == 7) {
		document.getElementById("page6").style.display = "none";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page7").style.display = "block";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#f2f2f2";
		document.getElementById("td2").style.backgroundColor = "#f2f2f2";
		document.getElementById("td7").style.backgroundColor = "#dbe6f4";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	if (page == 8) {
		document.getElementById("page6").style.display = "none";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "block";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#dbe6f4";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	if (page == 9) {
		document.getElementById("page6").style.display = "none";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "block";
		document.getElementById("page10").style.display = "none";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#dbe6f4";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#cfdef3";
	}
	if (page == 10) {
		document.getElementById("page6").style.display = "none";
		document.getElementById("page2").style.display = "none";
		document.getElementById("page1").style.display = "none";
		document.getElementById("page4").style.display = "none";
		document.getElementById("page3").style.display = "none";
		document.getElementById("page7").style.display = "none";
		document.getElementById("page8").style.display = "none";
		document.getElementById("page9").style.display = "none";
		document.getElementById("page10").style.display = "block";

		document.getElementById("Td1").style.backgroundColor = "#cfdef3";
		document.getElementById("Td2").style.backgroundColor = "#cfdef3";
		document.getElementById("Td3").style.backgroundColor = "#cfdef3";
		document.getElementById("Td4").style.backgroundColor = "#cfdef3";
		//改变的颜色  CCFFFF  初始颜色66CC99
		document.getElementById("td1").style.backgroundColor = "#cfdef3";
		document.getElementById("td2").style.backgroundColor = "#cfdef3";
		document.getElementById("td7").style.backgroundColor = "#cfdef3";

		document.getElementById("td3").style.backgroundColor = "#cfdef3";
		document.getElementById("td4").style.backgroundColor = "#cfdef3";
		document.getElementById("td6").style.backgroundColor = "#cfdef3";
		document.getElementById("data").style.backgroundColor = "#dbe6f4";
	}
}
