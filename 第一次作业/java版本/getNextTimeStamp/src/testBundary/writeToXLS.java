package testBundary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class writeToXLS {

	public writeToXLS() {
		// TODO Auto-generated constructor stub
	}
	public void writeExcelBo( String fileName , ArrayList<String> arrList ){
		WritableWorkbook wwb = null;    
		 try{
			 wwb = Workbook.createWorkbook(new File(fileName));    
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		 if(wwb!=null){
			 WritableSheet ws = wwb.createSheet("sheet1", 0);  
			 for(int i=0;i<arrList.size();i++){
				  
					 Label labelC = new Label(0, i, arrList.get(i));    
					 try{
						 ws.addCell(labelC);
					 }catch(RowsExceededException e){
						 e.printStackTrace();
					 }catch(WriteException e){
						 e.printStackTrace();
					 }
				 
			 }
			 try{
				 wwb.write();
				 wwb.close();
			 }catch(IOException e){
				 e.printStackTrace();
			 }catch(WriteException e){
				 e.printStackTrace();
			 }
		 }
	}
   
}
