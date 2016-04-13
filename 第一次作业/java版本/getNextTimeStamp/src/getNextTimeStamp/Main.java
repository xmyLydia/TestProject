package getNextTimeStamp;

import java.util.Scanner;

import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		//new DateUI(new JTextField()); 
		NextTimeStamp time = new NextTimeStamp();
		String[] arr = time.getinput();
		while(!time.varification(arr)){
			System.out.println("input error,input again:");
			arr = time.getinput();
		}
	 String[] result = time.inputNextTime(arr);
	 
	}

}
