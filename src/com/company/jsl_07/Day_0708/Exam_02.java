package com.company.jsl_07.Day_0708;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Exam_02 {
    public static void main(String[] args) throws IOException {
        Properties properties= new Properties();
        String path=Exam_02.class.getResource("database.properties").getPath();

        properties.load(new FileReader(path));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);




    }
}
