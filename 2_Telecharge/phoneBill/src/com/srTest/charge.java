package com.srTest;

/**
 * Created by ryw on 2016/4/20.
 */
public class charge {
    private double noPayAmountBefore=0;
    private double base=25.0;
    private double charge;

    private static class Singleton{
        private static charge instance = new charge();
    }
    public static charge getInstance(){
        return Singleton.instance;
    }
    public double getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(int talkTime, int noPayTimesThisYear,int noPayAmountBefore) {
        discount.getInstance().setDiscount(talkTime, noPayTimesThisYear);
        setNoPayAmountBefore(noPayAmountBefore);
        this.charge=Arith.add(base,Arith.add(Arith.mul(this.noPayAmountBefore,0.05),Arith.mul(talkTime,Arith.mul(0.15,Arith.sub(1,discount.getInstance().getDiscount())))));
                //+noPayAmountBefore*0.05+talkTime*0.15*(1-discount.getInstance().getDiscount());
    }

    public double getNoPayAmountBefore() {
        return noPayAmountBefore;
    }

    public void setNoPayAmountBefore(int noPayAmountBefore) {
        this.noPayAmountBefore = noPayAmountBefore;
    }
}
