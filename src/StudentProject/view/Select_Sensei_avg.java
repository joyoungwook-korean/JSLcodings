package StudentProject.view;

import StudentProject.model.StudentDAO;
import StudentProject.model.StudentVO;

import java.text.DecimalFormat;
import java.util.List;

public class Select_Sensei_avg {
    public static void main(String[] args) {
        StudentDAO dao = StudentDAO.getInstance();
        List<StudentVO> list = dao.select_Sensei();
        DecimalFormat format = new DecimalFormat("0.0");
        System.out.println("학년 \t 반\t 교사명\t 국어총점\t 영어총점\t 수학총점\t 국어평균\t 영어평균\t 수학평균");
        for(StudentVO vo : list){
            System.out.print(vo.getSyear()+ "\t "+vo.getSclass()+ "\t "+vo.getSensei()+ "\t ");
            System.out.println(vo.getKor() + "\t "+vo.getEng()+ "\t "+vo.getMat()
                    + "\t "+format.format(vo.getKor()/(float)vo.getCount())
                    + "\t "+format.format(vo.getEng()/(float)vo.getCount())
                    + "\t "+format.format(vo.getMat()/(float)vo.getCount()));

        }
    }
}
