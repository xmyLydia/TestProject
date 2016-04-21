		<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
		
		
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>
		  <head>
		<%@ page import="java.io.*" %>
		<%@ page import="jxl.Cell"%>
		<%@ page import="jxl.CellType"%>
		<%@ page import="jxl.Sheet"%>
		<%@ page import="jxl.Workbook"%>
		<%@ page import="jxl.read.biff.BiffException"%>
		<%@ page import="Payment.*" %> 
		<title>支付清单</title>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		  </head>
		 <body >
		 <div class="container">
		 <h1>支付方式</h1>
	 
		
		<br> 
		 
		  <br>
		 <br>
		 <hr>
		  <h2>清单</h2>
		 <%
		 String costToAli="";
		request.setCharacterEncoding("UTF-8");
		try {
		String path=request.getParameter("filename");
		InputStream is = new FileInputStream("E:/listCost.xls");
		Workbook read_workbook = Workbook.getWorkbook(is);
		Sheet sheet = read_workbook.getSheet(0);
		suppXlsbean cell_style = new suppXlsbean();
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		int rowspan = 0;
		int colspan = 0;
		out.print("<table border='1' cellpadding='0' cellspacing='0' style='font-size: 20px;border-collapse:collapse' bordercolor='#000000'>");
		for (int i = 0; i < rows; i++) {
		out.print("<tr>");
		for (int j = 0; j < 7 ; j++) {
		Cell cell = sheet.getCell(j, i);
		cell_style.ReadRange(sheet,i,j);
		rowspan = cell_style.getRowspan();
		colspan = cell_style.getColspan();
		String contents = null;
		if(cell.getType() == CellType.EMPTY){
		cell_style.setBetweenRowColumn(i,j);
		int min_row = cell_style.getMin_row();
		int max_row = cell_style.getMax_row();
		int min_col = cell_style.getMin_column();
		int max_col = cell_style.getMax_column();
		if( min_row < i && i <= max_row && min_col <= j && j<= max_col){
		j = max_col;
		continue;
		}
		contents = "&nbsp;";
		out.print("<td width='"+(8*colspan)+"' rowspan='"+rowspan+"' colspan='"+colspan+"'>"+contents+"</td>");
		j += colspan-1;
		continue;
		} else {
		
		contents = cell.getContents();
        if(j==4){
        	costToAli=contents;
		}
		out.print("<td align='center'"
		+"rowspan='"+rowspan+"'"
		+"colspan='"+colspan+"'"
		+"bGcolor='"+cell_style.getBgcolor(cell)+"'" 
		+"<Font color='"+cell_style.getFontColor(cell)+"'" 
		+"height='50'"
		+" width='"+(2000*colspan)+"'>"
		+contents+"</Font></td>");
		j += colspan-1;
		continue;
		}
		}
		out.print("</tr>");
		}
		read_workbook.close();
		is.close();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (BiffException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} 
		out.println();
		%> 
	
		<table class="table">
   <form action="AliLogin.jsp" method="get"><th  ><br><input type="hidden" name="key" value=<%=costToAli %>/><input type="submit" class="btn btn-lg btn-success text-center" onclick="window.location.href='AliLogin.jsp'" value="支付宝" /></th></form> <form action="BankCard.jsp" method="get"><th  ><br><input type="hidden" name="key" value=<%=costToAli %>/><th ><br><input type="submit" class="btn btn-lg btn-success text-center" onclick="window.location.href='BankCard.jsp'" value="银行卡" /></th></form>
   </table>
		 
		 
		</div>
	 
		 </body>
		
		</html>
		 