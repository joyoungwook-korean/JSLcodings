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
    }

    public int setMoney() {
        if(10>parkTime){
            this.money = 0;
        }else if((30>=parkTime)&&(parkTime>=10)){
            this.money = 500;
        }else{
            this.money = ((parkTime-10)/10)*500;
        }
        if(this.money>=30000){
            this.money = 30000;
        }
        return this.money;
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
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    void pirntCar(){
        System.out.println(carNo + "\t" + parkTime + "\t" + money);
    }








}
