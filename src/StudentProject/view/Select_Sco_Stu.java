package StudentProject.view;

import StudentProject.model.StudentDAO;
import StudentProject.model.StudentVO;

import java.text.DecimalFormat;
import java.util.List;

public class Select_Sco_Stu {
    public static void main(String[] args) {
        int kor=0, eng=0, mat=0;
        StudentDAO dao = StudentDAO.getInstance();
        List<StudentVO> list = dao.select_Stu_Sco();
        System.out.println("학년-반-번호\t 국어\t 영어\t 수학\t 총점\t 평균");

        for(StudentVO pritn_vo : list){
          kor += pritn_vo.getKor();
            eng+= pritn_vo.getEng();
            mat += pritn_vo.getMat();
            System.out.print(pritn_vo.getFull_num() + "\t " +
                    pritn_vo.getSname()+ "\t " +
                    pritn_vo.getGender() + "\t " +
                    pritn_vo.getKor()+ "\t " +
                    pritn_vo.getEng()+ "\t " +
                    pritn_vo.getMat()+ "\t " +
                    pritn_vo.getTot()+ "\t " +
                    pritn_vo.getAvg());
            System.out.println();
        }
        DecimalFormat format = new DecimalFormat("0.0");
        System.out.println("\t\t\t\t학년 총점 : " + kor +" \t "+  eng+" \t "+mat);
        System.out.println("\t\t\t\t학년 평균 : " + format.format(kor/(float)list.size())
                 +" \t "+  format.format(eng/(float)list.size())+" \t "+format.format(mat/(float)list.size()));
    }
}
