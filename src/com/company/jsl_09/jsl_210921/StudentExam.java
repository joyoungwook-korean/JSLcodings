package com.company.jsl_09.jsl_210921;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

//DB�� ����� �ҽ��ڵ� ������ �߿�**
public class StudentExam {
    public static void main(String[] args) throws Exception{
        File file = new File("student.txt");
        Scanner sc = new Scanner(System.in);
        Set<Student> ts = new TreeSet<>();
        int korTot=0,engTot=0,matTot=0;
        double avg;
        if(file.exists()) {	// ������ �����Ѵٸ� exists���
            ObjectInputStream ois = new ObjectInputStream
                    (new BufferedInputStream
                            (new FileInputStream(file))); // �����ٰ�
            ts = (TreeSet)ois.readObject();
        }
        System.out.println("학생");
        while(true) {
            System.out.println("[1. 학생등록]");
            System.out.println("[2. 전체출력]");
            System.out.println("[3. 학생종료]");
//			int menu = System.in.read()-48;// �ƽ�Ű�ڵ�� �Է� �� (1�� �Է��ϸ� �ƽ�Ű�ڵ� 49�� ����)
//			System.in.read();System.in.read();	//�ϳ��� ����̴� �˾ƵѰ�
//			System.out.println(menu);
            int menu = Integer.parseInt(sc.nextLine());
            if(menu<1 || menu>3) {
                System.out.println("시스템 오류");
                continue;
            }
            if(menu==1) { //�Է��۾�
                System.out.print("등록:");
                String[] hak = sc.nextLine().split(",");
                Student st = new Student(hak[0],hak[1],
                        Integer.parseInt(hak[2]),	//������ Ÿ�� ������ ��� Integer���
                        Integer.parseInt(hak[3]),
                        Integer.parseInt(hak[4]));
                //�ߺ�Ȯ��s

                if(ts.contains(st)) {	//contains(st) �ߺ� üũ ������
                    System.out.println(ts.contains(st));
                    System.out.println("중복");
                }else {
                    ts.add(st);
                    System.out.println(hak[1]+"학생등록완료");
                }
            }else if(menu==2) {	//��ü���
                System.out.println("입력자료순");
                System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");

                for(Student s : ts) {
                    System.out.println(s);
                }


                //��ȣ�� �������� �������� ���� �޼ҵ� ȣ��
                System.out.println("번호 순으로 출력");
                System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");
                for(Student s : ts) {
                    korTot += s.getKor();
                    engTot += s.getEng();
                    matTot += s.getMat();
                    System.out.println(s);
                }
                System.out.print("총점 : "+" \t "+korTot+" \t "+engTot+" \t "+matTot);
            }else {//����
                ObjectOutputStream oos = new ObjectOutputStream
                        (new BufferedOutputStream
                                (new FileOutputStream(file)));
                oos.writeObject(ts);
                oos.close();
                System.out.println("종료");
                break;
            }
        }
    }//main() ��
    static void bunAscSort(List<Student> list) {
        for(int x=0; x<list.size()-1; x++) {
            for(int y=+1; y<list.size(); y++) {
                if(Integer.parseInt(list.get(x).getBun()) > Integer.parseInt(list.get(y).getBun())) {
                    Student st1 = list.get(x);
                    Student st2 = list.get(y);
                    list.set(x, st2);
                    list.set(y, st1);
                }
            }
        }
    }

}
