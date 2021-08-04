package ContestProject.view;

import ContestProject.model.ContestDAO;
import ContestProject.model.ContestVO;

import java.util.List;

public class select_rank_04 {
    public static void main(String[] args) {
        ContestDAO dao = ContestDAO.getInstance();
        List<ContestVO> list = dao.select_all_rank();
        System.out.println("참가번호 \t 성명 \t 생년월일 \t 참가부문 \t 지역 \t 총점 \t 평균 \t 등수");
        for(ContestVO vo : list){
            System.out.println(vo.getEntry_no() + " \t " +vo.getEntry_name()+ " \t " +vo.getEntry_jumin()
                    + " \t " +vo.getEntry_type()+ " \t " +vo.getEntry_area()+ " \t " +vo.getTot()
                    + " \t " +vo.getAve()+ " \t " +vo.getMax());
        }
    }
}
