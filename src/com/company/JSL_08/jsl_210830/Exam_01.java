package com.company.JSL_08.jsl_210830;
class Cat extends Thread{
    public void run(){
        for(int x=0; x<10; x++){
            System.out.println("야옹");
        }try {
            Thread.sleep(500);
        }catch(Exception e){

        }
    }
}

class Dog extends Thread{
    public void run(){
        for(int x=0; x<10; x++){
            System.out.println("멍멍");
        }try {
            Thread.sleep(500);
        }catch(Exception e){

        }
    }
}

public class Exam_01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.start();
        cat.start();
    }
}
