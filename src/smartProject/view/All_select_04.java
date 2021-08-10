package smartProject.view;


import smartProject.model.SmartDAO;
import smartProject.model.SmartVO;

import java.util.ArrayList;
import java.util.List;

public class All_select_04 {
    public static void main(String[] args) {
        SmartDAO dao = SmartDAO.getInstance();
        List<SmartVO> list = dao.select_All_Pro_And_Work_And_process();
        System.out.println("작업지시번호 \t제품코드\t준비\t인쇄\t코팅\t합지\t접합\t포장 \t 최종공정일자 \t 최종공정시간");
        for (SmartVO vo1 : list) {
            List<String> list_p = new ArrayList<>();
            list_p = vo1.getP_px();
            System.out.print(vo1.getW_workno() + " \t " +vo1.getP_code()+"\t");
            for (String p : list_p) {
                System.out.print(p + "\t");
            }
            System.out.print("\t"+vo1.getW_lastdate() + " \t\t ");
            System.out.println(vo1.getW_lasttime());
        }
    }
}
