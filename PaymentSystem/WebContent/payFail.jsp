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
<div class="container text-center">
 <h2> 支付失败清单</h2>
 <br>
 <hr>
 <h2>支付失败！请重新支付！</h2>
 <br>
 	<input type="button" class="btn btn-lg btn-success text-center" onclick="window.location.href='PayPlatform.jsp'" value="重新支付" />
</div>
</body>
</html>