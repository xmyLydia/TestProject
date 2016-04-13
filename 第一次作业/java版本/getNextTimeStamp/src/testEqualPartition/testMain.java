package testEqualPartition;

import java.util.ArrayList;

import testBundary.writeToXLS;
//等价类划分测试
public class testMain {

	public testMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		PartitionTest test = new PartitionTest();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList = test.PartitionTestToWrite();
		
		writeToXLS writeToXls = new writeToXLS();
		writeToXls.writeExcelBo("testPartition.xls",arrList);
	}

}
