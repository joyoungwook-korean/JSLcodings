package ContestProject.view;

import ContestProject.model.ContestDAO;
import ContestProject.model.ContestVO;

import java.util.List;
import java.util.Scanner;

public class Insert_entry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContestDAO dao = ContestDAO.getInstance();
        ContestVO vo = new ContestVO();
        System.out.println("참가자 정보 등록 화면");
        vo.setEntry_no(dao.last_EntryNum());
        System.out.println("참가 번호 : " + vo.getEntry_no());
        System.out.print("성명 : " );
        vo.setEntry_name(scanner.next());
        while (true){
            System.out.print("주민번호 : ");
            String jumin = scanner.next();
            boolean check = dao.check_jumin(jumin);
            if(check==true){
                vo.setEntry_jumin(jumin);
                break;
            }else{
                continue;
            }
        }
        System.out.print("참가부분 : ");
        vo.setEntry_type(scanner.next());
        System.out.print("지역 : ");
        vo.setEntry_area(scanner.next());
        dao.insert_to_entry(vo);


        //----------select
        List<ContestVO> list = dao.select_to_entry();
        System.out.println("참가번호 \t 성명 \t 주민번호 \t 참가부문 \t 지역");
        for(ContestVO print_vo : list){
            System.out.println(print_vo.getEntry_no() + " \t " +print_vo.getEntry_name()+ " \t " +
                    print_vo.getEntry_jumin()+ " \t " + print_vo.getEntry_type()+ " \t " +print_vo.getEntry_area());
        }

    }
}
