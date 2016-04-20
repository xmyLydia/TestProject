package com.srTest;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        charge.getInstance().setCharge(scanner.nextInt(),scanner.nextInt());
        System.out.println(""+discount.getInstance().getDiscount()+" "+charge.getInstance().getCharge());
    }
}
