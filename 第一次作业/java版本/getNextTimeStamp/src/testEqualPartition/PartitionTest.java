package testEqualPartition;
import java.io.File;
import java.util.ArrayList;

import jxl.*; 
import getNextTimeStamp.*;
public class PartitionTest{
	
        public  ArrayList<String> PartitionTestToWrite(){
		    NextTimeStamp   timer = new NextTimeStamp();     
		    //writeXLS用于记录基本答案和计算结果之间的比较结果，即测试结果
		    ArrayList<String> writeXLS = new ArrayList<String>();
		    int i;
	        Sheet sheet;
	        Workbook book;
	        Cell cell1,cell2,cell3,cell4;
	        try { 
	            //t.xls为要读取的excel文件名
	            book= Workbook.getWorkbook(new File("partition.xls")); 
	            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
	            sheet=book.getSheet(0); 
	            //获取左上角的单元格
	            cell1=sheet.getCell(0,0);
	            System.out.println("标题："+cell1.getContents()); 
	            i=1;
	            while(true)
	            {
	                //获取每一行的单元格 
	                cell1=sheet.getCell(0,i);//（列，行）
	                cell2=sheet.getCell(1,i);
	                cell3=sheet.getCell(2,i);
	                cell4=sheet.getCell(3,i);
	                 if("".equals(cell1.getContents())==true)    //如果读取的数据为空
	                  break;
	                 System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()); 
	                //进行输入输出的判断
	                String[] arr = {cell1.getContents(),cell2.getContents(),cell3.getContents()};
	                 System.out.println(arr[0]+"!"+arr[1]+"!"+arr[2]);
	                //函数调用得到的计算结果
	                String[] result = timer.inputNextTime(arr);
	                
	                //从用例文件中得到的结果
	                String basicAnswer = cell4.getContents();
	             //   System.out.println(basicAnswer);
	               
	                if(i < 6){//前7个测试用例通过逗号分割得到用于验证结果的标准答案
	                	 String xlsExpect[]=basicAnswer.split(",");
	                	 if(result.length==3){//若计算结果是日期
	                		 if(Integer.parseInt(xlsExpect[0])==Integer.parseInt(result[0])&&Integer.parseInt(xlsExpect[1])==Integer.parseInt(result[1])&&Integer.parseInt(xlsExpect[2])==Integer.parseInt(result[2]))
	     	                {
	     	                	System.out.println("correctly match");
	     	                	writeXLS.add("correctly match");
	     	                }
	     	                else{
	     	                	System.out.println("error match");
	     	                	writeXLS.add("error match");
	     	                } 
	                	 }
	                	 else{
	                		 //若计算结果是“error”但此时标准答案无“error”，则匹配错误
	                		 System.out.println("error match  ");
	                		 writeXLS.add("error match");
	                	 }
	                }
	                
	                else{//后面7到15号用例则是“error”所以不必分割
	            
	                	if(result.length==3){//若标准答案为“error"但是计算结果不是
	                		System.out.println("error match");
	                		writeXLS.add("error match");
	                	}else{
	                		System.out.println("correctly match");
	                		writeXLS.add("correctly match");
	                	}
	                }
	          
	                i++;
	            }
	            book.close(); 
	        }
	        catch(Exception e)  { }
			return writeXLS; 
	}
     
}