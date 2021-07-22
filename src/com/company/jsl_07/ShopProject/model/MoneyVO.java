package com.company.jsl_07.ShopProject.model;

import java.text.DecimalFormat;

public class MoneyVO {
    private int custno;
    private int saleno;
    private int pcost;
    private int amount;
    private int price;
    private String pcode;
    private String sdate;

    DecimalFormat decimalFormat = new DecimalFormat("###,###");


    public int getCustno() {
        return custno;
    }

    public void setCustno(int custno) {
        this.custno = custno;
    }

    public int getSaleno() {
        return saleno;
    }

    public void setSaleno(int saleno) {
        this.saleno = saleno;
    }

    public int getPcost() {
        return pcost;
    }

    public void setPcost(int pcost) {
        this.pcost = pcost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        decimalFormat.format(price);
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    @Override
    public String toString() {

        return
                  custno +
                "\t" + saleno +
                          "\t" + pcost +
                          " \t" + amount +
                          "\t" + decimalFormat.format(price) +
                          " \t" + pcode+
                          "\t" + sdate;
    }
}
