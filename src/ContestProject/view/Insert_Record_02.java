package ContestProject.view;

import ContestProject.model.ContestDAO;
import ContestProject.model.ContestVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Insert_Record_02 {

    public static void main(String[] args) {
        ContestDAO dao = ContestDAO.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("경연점수 등록 화면");
        ContestVO vo = new ContestVO();
        while (true) {
            System.out.print("참가번호 : ");
            String entry_no = scanner.next();
            boolean check = dao.check_EntryNum(entry_no);
            if (check == true) {
                vo.setEntry_no(entry_no);
                break;
            } else {
                continue;
            }
        }
        System.out.println("심사위원 심사점수(1~100)");
        List<ContestVO> list = dao.select_re();
        for (int i = 0; i < list.size(); i++) {
            ContestVO vo2 = list.get(i);
            List<String> list2 = vo2.getRname();
            List<Integer> list_jum = new ArrayList<>();
            for (String s : list2) {
                System.out.print(s +":" );
                while (true){
                    int jum = scanner.nextInt();
                    if(dao.check1_100(jum)==true){
                        list_jum.add(jum);
                        break;
                    }else{
                        continue;
                    }
                }
            }
            vo.setScore(list_jum);
        }
        dao.insert_to_record(vo);

        System.out.println("참가번호 \t 점수1 \t 점수2 \t 점수3 \t 점수4 \t 점수5 \t 최대점수 \t 최소점수 \t 합계 \t 평균");
        List<ContestVO> select_list = dao.select_to_record();
        for(ContestVO select_vo : select_list){
            System.out.print(select_vo.getEntry_no() +" \t ");
            for(int aa : select_vo.getScore()){
                System.out.print(aa+" \t ");
            }
            System.out.println(select_vo.getAve(select_vo.getAve()));
        }

    }
}
