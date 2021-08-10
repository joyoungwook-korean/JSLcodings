package smartProject.view;

import smartProject.model.SmartDAO;
import smartProject.model.SmartVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Process_Insert_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartDAO dao = SmartDAO.getInstance();
        SmartVO vo = new SmartVO();
        List<String> list = new ArrayList<>();
        System.out.println("작업 공정 등록 화면");
        while (true) {
            System.out.print("작업지시번호 : ");
            String work_num = scanner.next();
            if (dao.check_work_num(work_num)) {
                vo.setW_workno(work_num);
                break;
            } else {
                System.out.println("등록된 작업지시번호가 존재하지 않습니다.");
                continue;
            }
        }

        int cnt = 0;
        String temp[] = {"재료준비", "인쇄공정", "코팅공정", "합지공정", "접합공정", "포장적재"};
        while (true) {
            System.out.print(temp[cnt] + "(Y/N) ");
            String y_or_n = scanner.next().toUpperCase();
            if (Check_Y_or_N(y_or_n)) {
                cnt++;
                list.add(y_or_n);
            } else {
                System.out.println("입력 오류");
            }
            if (list.size() == 6) {
                vo.setP_px(list);
                break;
            }
        }

        while (true) {
            System.out.print("최종작업일자 : ");
            String last_work = check_lastdate(scanner.next());
            if (last_work == null) {
                System.out.println("입력오류");
                continue;
            } else {
                vo.setW_lastdate(last_work);
                break;
            }
        }

        while (true) {
            System.out.print("최종작업시간 : ");
            String time = scanner.next();
            if (time.length() == 4) {
                vo.setW_lasttime(time);
                break;
            }
        }

        dao.insert_Smart_Process(vo);
        List<SmartVO> list1 = dao.select_All_Process();
        System.out.println("작업지시번호 \t준비\t인쇄\t코팅\t합지\t접합\t포장 \t 최종공정일자 \t 최종공정시간");
        for (SmartVO vo1 : list1) {
            List<String> list_p = new ArrayList<>();
            list_p = vo1.getP_px();
            System.out.print(vo1.getW_workno() + " \t ");
            for (String p : list_p) {
                System.out.print(p + "\t");
            }
            System.out.print(vo1.getW_lastdate() + " \t ");
            System.out.println(vo1.getW_lasttime());
        }


    }

    private static boolean Check_Y_or_N(String a) {
        return a.equals("Y") || a.equals("y") || a.equals("N") || a.equals("n");
    }

    private static String check_lastdate(String a) {
        String[] temp_date = a.split("-");
        if (temp_date.length == 3) {
            return temp_date[0] + temp_date[1] + temp_date[2];
        } else if (a.length() == 8) {
            return a;
        } else return null;
    }
}
