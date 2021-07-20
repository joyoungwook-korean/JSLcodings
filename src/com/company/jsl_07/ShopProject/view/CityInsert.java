package com.company.jsl_07.ShopProject.view;


import com.company.jsl_07.ShopProject.model.ShopSQL;

import java.util.Scanner;

public class CityInsert {

    public static void main(String[] args) {
        ShopSQL sql = new ShopSQL();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String city = scanner.next();
            if(city.equals("0000")) break;
            sql.insert_City(city, scanner.next());
        }


    }

}
