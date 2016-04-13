package getNextTimeStamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class NextTimeStamp {
//输入时间（年月日）输出下一天的年月日
	//年的格式是1600年到2500年
	
	//月的格式是1到12
	
	//日的格式是31,28,29,30
	public String[] getinput(){
		//获取输入并且分割存入数组
		 Scanner input =new Scanner(System.in);
         System.out.println("please input the year month day and seperate them with space: ");
	     String line=input.nextLine();
         String arr[]=line.split(" ");
		 return arr;
	}
	boolean  varification(String[] arr){
		int daylimit;
		//进行输入验证
		if(arr.length==3){
		  int year=Integer.parseInt(arr[0]);
		  int month=Integer.parseInt(arr[1]);
		  int day=Integer.parseInt(arr[2]);
		  if(year>=2000&&year<=2099){
			  //对年进行判断
			  if(month>0&&month<13){
				  //对月进行判断
				  switch(month){
				  case 2:{
					  if(year/400==0||(year/4==0&&year/100!=0)){
						  //是闰年
						  daylimit=29;
					  }
					  else daylimit=28;
				  }
				  case 4:daylimit=30;
				  case 6:daylimit=30;
				  case 9:daylimit=30;
				  case 11:daylimit=30;
				  default:daylimit=31;
				  }
				  //对日进行判断
				  if(day>0 && day <=daylimit){
					  //年月日都符合规范
					  return true;
				  }
				  else return false;
			  }
			      else return false;
		  }
		  else return false;
		}
			 
			else return false;
	}
    public String[] inputNextTime(String[] arr)  {
    	//输出第二天 
    	if(varification(arr)){
    	try{
    	String format=arr[0]+"-"+arr[1]+"-"+arr[2];//使用calendar的年月日格式   
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Calendar cd=Calendar.getInstance();
    	cd.setTime(sdf.parse(format));
    	cd.add(Calendar.DATE, 1);
    	
    	String[] result = (sdf.format(cd.getTime())).split("-");
    	//System.out.println(sdf.format(cd.getTime())); 
    	//System.out.println(result[0]+","+result[1]+","+result[2]);
    	//return sdf.format(cd.getTime());
    	return result;
    }catch(Exception e){
    	String[] error ={"error"};
    	return error;
    }
    	}
    	else {
    		String[] error ={"error"};
        	return error;
    	}
    		
    	}
}
 