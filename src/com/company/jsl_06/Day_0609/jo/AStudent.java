package com.company.jsl_06.Day_0609.jo;

public class AStudent {
    int num;
    String name;
    int phone_num;
    Score score;
    int up=0;
    public static int arr_j[] = new int[1000];
    public static int cnt=0;
/*
    public AStudent() {
    }
*/
    /*
    public AStudent(int num, String name, int phone_num, int[] arr) {
        this.num = num;
        this.name = name;
        this.phone_num = phone_num;
        arr_j = arr;
    }*/

    public AStudent(int num, String name, Score score){
        this.num = num;
        this.name= name;
        this.score = score;
    }

    public void psps(){
        int j=0;
        System.out.print("번호  : "+num + " " + "이름 : "+name + " ");
        System.out.println();
        for(int i=0; i< Exam_05.a; i++){
            int tot=0;

            while (true) {
                if (score.arr[i][j] == 0) break;
                System.out.print(score.arr[i][j] + " ");
                tot += score.arr[i][j];
                j++;
            }
            i++;

            System.out.print(tot);
            System.out.println();
        }
    }


     void paa(){
        System.out.println(num);
    }


    void printddd(){
        System.out.println(cnt);
        for(int i=0; i< cnt; i++){
            System.out.println(arr_j[i]);
        }
    }

    void setArr_j(int a){
        System.out.print("점수 : ");
        arr_j[cnt] = a;
        cnt++;
    }


}
