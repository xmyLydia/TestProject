package com.srTest;

/**
 * Created by ryw on 2016/4/20.
 */
public class discount {

    private int talkTime;
    private int noPayTimesThisYear;



    private double discount=0;

    private static class Singleton{
        private static discount instance = new discount();
    }
    public static discount getInstance(){
        return Singleton.instance;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getNoPayTimesThisYear() {
        return noPayTimesThisYear;
    }

    public void setNoPayTimesThisYear(int noPayTimesThisYear) {
        this.noPayTimesThisYear = noPayTimesThisYear;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDiscount(int talkTime, int noPayTimesThisYear) {
        setTalkTime(talkTime);
        setNoPayTimesThisYear(noPayTimesThisYear);
        if(noPayTimesThisYear<0){
            this.discount=-2;
        }else {
            if ((talkTime > 0 && talkTime < 60) || talkTime == 60) {
                if (noPayTimesThisYear < 2) {
                    this.discount = 0.01;
                }
            } else if ((talkTime > 60 && talkTime < 120) || talkTime == 120) {
                if (noPayTimesThisYear < 3) {
                    this.discount = 0.015;
                }
            } else if ((talkTime > 120 && talkTime < 180) || talkTime == 180) {
                if (noPayTimesThisYear < 4) {
                    this.discount = 0.02;
                }
            } else if ((talkTime > 180 && talkTime < 300) || talkTime == 300) {
                if (noPayTimesThisYear < 4) {
                    this.discount = 0.025;
                }
            } else if (talkTime > 300) {
                if (noPayTimesThisYear < 7) {
                    this.discount = 0.03;
                }
            } else {
                this.discount = -1;
            }
        }
    }

}
