<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付成功</title>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
 <% 
    String costShow = request.getParameter("key");
    String cs[]=costShow.split("/");
    String result=cs[0];
  
  %>
<div class="container text-center">
 <h2>成功支付清单</h2>
 <br>
 <hr>
 <h2>支付成功！感谢你的支持！</h2>
 <br>
 <h4>流水号：12345</h4>
 <br>
 <h4>缴费号：1234567</h4>
 <br>
 <h4>缴费金额：<%=result %> 元</h4>
 
</div>
</body>
</html>