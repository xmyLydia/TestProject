<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<title>支付平台</title>
</head>
<body>
<div class="container">
<% 
	String username = new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
	 
    String costShow = request.getParameter("key");
    String cs[]=costShow.split("/");
    String cost=cs[0];
  %>
<h1>支付平台</h1>
<br>
<div class="panel panel-default ">
 <div class="panel-heading">
  <h3 class="panel-title"> &nbsp;&nbsp;&nbsp;支付金额 ￥: <%=cost  %></h3>
  <br>
 </div>
 <div class="form">
 <form name="form1" action="AliSuccess.jsp" method="post" onSubmit="return check()">
  <div class="panel-body">
   <div class="col-xs-10 col-sm-3" >  
  <div class="row">
  <div class="col-xs-10  " > 
   <h4>您在安全的环境中，<br><br>请放心使用</h4>
   
  <br>
  <br>
  <br>
  <h4>请填写密码</h4>
  <br> 
  	<input type="password" id="userPWD" name="userPWD" class="form-control" placeholder="支付密码">
  	</div>   	 
  	</div>
  	<br>
  	<br>
  	<form action="AliSuccess.jsp" method="get"><input type="hidden" name="key" value=<%=costShow %>><input type="hidden" name="user" value=<%=username %>/><input type="submit" class="btn btn-lg btn-success text-center" onclick="window.location.href='AliSuccess.jsp'" value="确认支付" /></form>
  </div>
  <div class="col-xs-2 col-md-offset-5">
   <img src="scan.jpg" class="img-responsive" alt="Cinque Terre">
  
  </div>
  </div>
  </form>
  </div>
  </div>
</div>

</body>
</html>