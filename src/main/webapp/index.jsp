<%@page import="fandystoretestweb.FandyStoreTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
TESTING FANDY STORE
<br>
<button onclick="rebootdevice('OPPO')">Reboot OPPO A95</button>
<button onclick="rebootdevice('Xiaomi')">Reboot Xiaomi Mi 6</button>
<button onclick="rebootdevice('Nexus 5')">Reboot Nexus 5</button>
<button onclick="testaplikasi()">Testing Aplikasi</button>
<div id="statusReboot"></div>
<script type="text/javascript">
function rebootdevice(device){
	document.getElementById("statusReboot").innerHTML = "Loading reboot...";
	var url="reboot.jsp?device="+device;
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
	  document.getElementById("statusReboot").innerHTML = this.responseText;
	  }
	xhttp.open("GET", url, true);
	xhttp.send();
}
function testaplikasi(){
	document.getElementById("statusReboot").innerHTML = "Loading testing...";
	var url="testing.jsp";
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
	  document.getElementById("statusReboot").innerHTML = this.responseText;
	  }
	xhttp.open("GET", url, true);
	xhttp.send();
}
</script>
</body>
</html>