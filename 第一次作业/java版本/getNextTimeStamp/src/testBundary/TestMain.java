package testBundary;

import java.util.ArrayList;

public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	writeXls xls = new writeXls();
	//	xls.writeExcelBo("test.xls");
		BundaryValueTest test = new BundaryValueTest();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList = test.BundaryValueTestToWrite();
		
		writeToXLS writeToXls = new writeToXLS();
		writeToXls.writeExcelBo("testBundary.xls",arrList);
	}

}
