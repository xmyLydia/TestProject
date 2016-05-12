package com.srTest;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

import java.io.*;
/**
 * Created by ryw on 2016/4/26.
 */
public class doExl {
    /**读取Excel文件的内容
     * @param file  待读取的文件
     * @return
     */
    public static String[][] readExcel(File file) {
        Workbook wb = null;
        try {
            //构造Workbook（工作薄）对象
            wb = Workbook.getWorkbook(file);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (wb == null)
            return null;

        //获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
        Sheet[] sheet = wb.getSheets();
        String result[][];

        if (sheet != null && sheet.length > 0) {

            int rowNum = sheet[0].getRows();
            result = new String[rowNum-1][3];
            //第一个是当月通话分钟
            //第二个是当年迄今为缴纳次数
            //第三个往年未缴纳金额
            //得到当前工作表的行数
            for (int j = 1; j < rowNum; j++) {
                //得到当前行的所有单元格
                Cell[] cells = sheet[0].getRow(j);
                if (cells != null && cells.length > 0) {
                    //对每个单元格进行循环
                    for (int k = 2; k < 5; k++) {
                        //读取当前单元格的值
                        result[j-1][k-2] = cells[k].getContents();
                    }
                }
            }
            //最后关闭资源，释放内存
            wb.close();
            return result;
        } else {
            //最后关闭资源，释放内存
            wb.close();
            result = null;
            return result;
        }

    }
    /**生成一个Excel文件n
     * @param file  要生成的Excel文件
     */
    public static void writeExcel(File file,Double result[][]){
        WritableWorkbook wwb = null;
        try {
            //首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
            Workbook rwb = Workbook.getWorkbook(file);
            //打开一个文件的副本，并且指定数据写回到原文件
            wwb = Workbook.createWorkbook(new File("listCostResult.xls"),rwb);//copy
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        if(wwb!=null){
            //创建一个可写入的工作表
            //Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
            WritableSheet ws = wwb.getSheet(0);
            WritableCell wc = ws.getWritableCell(0,0);
            int rowNum=result.length;
            //下面开始添加单元格
            for(int i=1;i<rowNum+1;i++){

                    //这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
                    Number labelC = new Number(7, i, result[i-1][0]);
                    Number labelD=new Number(8,i,result[i-1][1]);
                    //将生成的单元格添加到工作表中
                        try {
                            ws.addCell(labelC);
                            ws.addCell(labelD);
                        } catch (WriteException e) {
                            e.printStackTrace();
                        }
                    }


            }

            try {
                //从内存中写入文件中
                wwb.write();
                //关闭资源，释放内存
                wwb.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }

}