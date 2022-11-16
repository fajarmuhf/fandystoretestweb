<%
String device = request.getParameter("device");
if(device.equals("OPPO")){
	out.print(fandystoretestweb.OPPOA95Controller.restart()); 
}
else if(device.equals("Xiaomi")){
	out.print(fandystoretestweb.XiaomiController.restart()); 
}
else if(device.equals("Nexus 5")){
	out.print(fandystoretestweb.Nexus5Controller.restart()); 
}
else{
	out.print("Not Found "+device);
}
%>