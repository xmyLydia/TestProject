package com.srTest;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Scanner scanner=new Scanner(System.in);
        charge.getInstance().setCharge(scanner.nextInt(),scanner.nextInt());
        System.out.println(""+discount.getInstance().getDiscount()+" "+charge.getInstance().getCharge());*/
        File file=new File("listCost.xls");
        String source[][];
        Double result[][];
        source = doExl.readExcel(file);
        if(source!=null){
            result=new Double[source.length][2];
            for (int i=0;i<source.length;i++){
                System.out.println(""+source[i][0]+" "+source[i][1]+" "+source[i][2]);
                charge.getInstance().setCharge(Integer.parseInt(source[i][0]),Integer.parseInt(source[i][1]),
                        Integer.parseInt(source[i][2]));
                result[i][0]=discount.getInstance().getDiscount();
                result[i][1]=charge.getInstance().getCharge();
                System.out.println(""+discount.getInstance().getDiscount()+" "+charge.getInstance().getCharge());
                discount.getInstance().setDiscount(0);
            }
            doExl.writeExcel(file,result);
        }else {
            System.out.println("NoSources");
        }
    }
}
