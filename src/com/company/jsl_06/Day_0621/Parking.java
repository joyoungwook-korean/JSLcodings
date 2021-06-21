package com.company.jsl_06.Day_0621;

public class Parking {

    String carNo;
    int parkTime;
    int money;

    public Parking(String carNo, int parkTime, int money) {
        this.carNo = carNo;
        this.parkTime = parkTime;
        this.money = money;
    }

    public Parking(String carNo, int parkTime) {
        this.carNo = carNo;
        this.parkTime = parkTime;
        this.money = setMoney();
    }


    public int setMoney() {
        if(10>parkTime){
            money = 0;
        }else if((30>=parkTime)&&(parkTime>=10)){
            money = 500;
        }else{
            money = ((parkTime-10)/10)*500;
        }
        if(this.money>=30000){
            money = 30000;
        }
        return money;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public int getParkTime() {
        return parkTime;
    }

    public void setParkTime(int parkTime) {
        this.parkTime = parkTime;
        this.money = setMoney();
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    void printCar(){
        System.out.println(getCarNo() + "\t" + getParkTime() + "\t\t" +getMoney() );
    }


}
