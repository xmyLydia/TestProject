<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  	  <head>
			<%@ page import="java.io.*" %> 
		<%@ page import="jxl.Cell"%>
		<%@ page import="jxl.CellType"%>
		<%@ page import="jxl.Sheet"%>
		<%@ page import="jxl.Workbook"%>
		<%@ page import="jxl.read.biff.BiffException"%>
		<%@ page import="Payment.*" %>  
		<%@ page import="jxl.Workbook" %>
		<%@ page import="jxl.write.*" %>
		<%@ page import="jxl.read.*" %>
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
    String user[] = new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8").split("/");
    String username=user[0];
  
  %>
<div class="container text-center">
 <h2>成功支付清单</h2>
 <br>
 <hr>
 <h2>银行卡支付成功！感谢你的支持！</h2>
 <br>
 <h4>流水号：12345</h4>
 <br>
 <h4>缴费号：1234567</h4>
 <br>
 <h4>缴费金额：<%=result %> 元</h4>
 <hr>
  
 
		 <div class="container">
		<br> 
		 
		  <br>
		 <br>
		 <hr>
		  <h2>清单</h2>
		 <%
		 String costToAli="";
		 String payPerson="";
		 int theRow=0;
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
		
		for(int m=1;m<rows;m++){
			Cell cellUser = sheet.getCell(5, m);
			payPerson=cellUser.getContents();
			if(payPerson.equals(username)){
				theRow=m;
				break;
			}
		}
		// out.println(theRow+"#####");
		out.print("<table border='1' cellpadding='0' cellspacing='0' style='font-size: 20px;border-collapse:collapse' bordercolor='#000000'>");
		for (int i = 0; i < 3; i++) {
		out.print("<tr>");
		for (int j = 0; j < 7 ; j++) {
		
		Cell cell = sheet.getCell(j, i);
		
		String contextForRow= cell.getContents();
		if(j==0){
			if(contextForRow.equals(username)){
				theRow=i;
			}
		}
		
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
		
	
	 	if(i==0||i==theRow){
        if(j==6){
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
		}
		//theRow=0;
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
	<br>
	<br>
	<br>
		<%//向表格写入支付方式 
	 WritableWorkbook book = null;
	 try {
	      //Excel获得文件
	      Workbook wb = Workbook.getWorkbook(new File("E:/listCost.xls"));

	      //打开一个文件的副本，并且指定数据写回到原文件
	      book = Workbook.createWorkbook(new File("E:/listCost.xls"), wb); 
	      WritableSheet sheet =  book.getSheet(0);
          //写入支付方式
	      sheet.addCell(new Label(7, theRow, "银行卡"));
	      book.write();
	    }
	    catch (IOException ioe) {
	      ioe.printStackTrace();
	    }
	    catch (BiffException be) {
	      be.printStackTrace();
	    }
	    catch (WriteException we) {
	      we.printStackTrace();
	    }
	    finally {

	      try {
	        if (book != null) {
	          book.close();
	        }
	      }
	      catch (IOException ioe) {
	        ioe.printStackTrace();
	      }
	      catch (WriteException we) {
	        we.printStackTrace();
	      }
	    }
	%>
		</div>
 
</div>
</body>
</html>