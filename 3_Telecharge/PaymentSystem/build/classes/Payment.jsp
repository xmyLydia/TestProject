<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电信支付平台</title>
<style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #FFE4C4 0%, #FFE4C4 100%);
	background-image:-o-linear-gradient(bottom, #FFE4C4 0%, #FFE4C4 100%);
	background-image:-moz-linear-gradient(bottom, #FFE4C4 0%, #FFE4C4 100%);
	background-image:-webkit-linear-gradient(bottom, #FFE4C4 0%, #FFE4C4 100%);
	background-image:-ms-linear-gradient(bottom, #FFE4C4 0%, #FFE4C4 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 300px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
	
	
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: #EE9572;
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #0D0D0D;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
 
 <div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>手机账单缴费</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form name="form1" action="suppxls.jsp" method="post" onSubmit="return check()">
				 
				 
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
					<input type="button" class="btn btn-block btn-lg btn-info text-center" onclick="window.location.href='LOGIN.jsp'" value="手机账单缴费" />
					</div>
				</div>
			 
			</form>
			</div>
		</div>
	</div>
</div> 

 
 
 	
</body>
</html>