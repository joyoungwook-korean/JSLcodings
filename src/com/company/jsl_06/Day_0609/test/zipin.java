package com.company.jsl_06.Day_0609.test;

public class zipin {
    String  id, name,zipcode;
    String arr[][] = new String[1][2];

    MemberData memberData = new MemberData();

    public zipin( String id, String name,String  zipcode) {
        this.zipcode = zipcode;
        this.id = id;
        this.name = name;
    }

    public void getzipcode() {
        for(int x =0; x<memberData.ziparr.length; x++){
            if(memberData.ziparr[x][0].equals(zipcode)){
                arr[0] = memberData.ziparr[x];
                break;
            }else{
                break;
            }
        }
    }


    void printZip(){
        getzipcode();
        System.out.println(id + "\t" + name+ "\t" +  arr[0][0] +
                "\t"+arr[0][1]+ "\t"+arr[0][2]);
    }
}
