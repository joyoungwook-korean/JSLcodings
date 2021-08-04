package ContestProject.view;

import ContestProject.model.ContestDAO;
import ContestProject.model.ContestVO;

import java.util.List;
import java.util.Scanner;

public class select_record_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContestDAO dao = ContestDAO.getInstance();
        String entry_no = "";
        while (true) {
            System.out.println("경연 점수 조회 화면");
            System.out.print("참가 번호를 입력하세요 : ");
            entry_no = scanner.next();
            if (entry_no.equals("")) {
                System.out.println("참가 번호가 입력되지 않았습니다");
                continue;
            } else if (dao.check_EntryNum(entry_no)) {
                if (dao.check_recordNum(entry_no)) {
                    break;
                }
            }
        }

        ContestVO vo = dao.select_Record_alone(entry_no);
        System.out.println("참가번호 " + vo.getEntry_no());
        System.out.println("성명 : " + vo.getEntry_name());
        System.out.println("생년월일 : " + vo.getEntry_jumin());
        System.out.println("참가부문 : " + vo.getEntry_type());
        System.out.println("지역 : " + vo.getEntry_area());
        List<ContestVO> list = dao.select_re();
        int cnt = 0;
        List<Integer> list_jum = vo.getScore();
        for (ContestVO vo2 : list) {
            List<String> vo3 = vo2.getRname();
            for(String s : vo3){
                System.out.println(s + " : " + list_jum.get(cnt));
                cnt++;
            }
        }
        System.out.println("총점 : " + list_jum.get(cnt));
        System.out.print("평균 : " + vo.getAve(vo.getAve()));
    }


}

