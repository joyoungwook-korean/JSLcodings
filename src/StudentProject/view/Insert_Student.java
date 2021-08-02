package StudentProject.view;

import StudentProject.model.StudentDAO;
import StudentProject.model.StudentVO;

import java.util.List;
import java.util.Scanner;

public class Insert_Student {
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

                break;
            }else {
                System.out.println("해당 학생이 있습니다.");
                continue;
            }
        }
        System.out.print("이름 : ");
        vo.setSname(scanner.next());
        System.out.print("생년월일 : ");
        vo.setBirth(scanner.next());
        System.out.print("성별(M/F) : ");
        vo.setGender(scanner.next());
        scanner.nextLine();
        System.out.print("전화번호 : ");
        vo.setPhone(scanner.nextLine());
        System.out.println();
        dao.insert_Student(vo);

        List<StudentVO> list = dao.select_Student();

        for(StudentVO pritn_vo : list){
            System.out.println("학년 \t 반 \t 번호\t 이름\t \t 성별\t 전화번호");
            System.out.println(pritn_vo);
        }
    }
}
