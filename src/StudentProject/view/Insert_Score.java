package StudentProject.view;

import StudentProject.model.StudentDAO;
import StudentProject.model.StudentVO;
import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Insert_Score {
    public static void main(String[] args) {
        StudentDAO dao = StudentDAO.getInstance();
        StudentVO vo = new StudentVO();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String[] check = new String[3];
            System.out.print("학년 : ");
            vo.setSyear(scanner.next());
            System.out.print("반 : ");
            vo.setSclass(scanner.next());
            System.out.print("번호 : ");
            vo.setSno(scanner.next());
            check[0] = vo.getSyear();
            check[1] = vo.getSclass();
            check[2] = vo.getSno();
            if(dao.check_Student(check)){
                System.out.println("등록된 학생이 없습니다.");
                continue;
            }else {
                System.out.println("성적이 등록 됩니다.");
                break;
            }
        }
        System.out.print("국어 : ");
        vo.setKor(scanner.nextInt());
        System.out.print("영어 : ");
        vo.setEng(scanner.nextInt());
        System.out.print("수학 : ");
        vo.setMat(scanner.nextInt());
        dao.insert_Score(vo);

        List<StudentVO> list = dao.select_Score();
        for(StudentVO pritn_vo : list){
            System.out.println("학년 \t 반\t 번호\t 국어\t 영어\t 수학\t 총점\t 평균");
            System.out.print(pritn_vo.getSyear() + "\t " +
                    pritn_vo.getSclass()+ "\t " +
                    pritn_vo.getSno()+ "\t " +
                    pritn_vo.getSname()+ "\t " +
                    pritn_vo.getKor()+ "\t " +
                    pritn_vo.getEng()+ "\t " +
                    pritn_vo.getMat()+ "\t " +
                    pritn_vo.getTot()+ "\t " +
                    pritn_vo.getAvg());
            System.out.println();
        }


    }
}
