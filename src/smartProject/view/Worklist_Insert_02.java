package smartProject.view;

import smartProject.model.SmartDAO;
import smartProject.model.SmartVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Worklist_Insert_02 {
    public static void main(String[] args) {
        SmartDAO dao = SmartDAO.getInstance();
        Scanner scanner = new Scanner(System.in);
        SmartVO vo = new SmartVO();

        while (true){
            String worker = dao.check_Worklist_Num();
            System.out.println("작업 지시 등록 화면 :" + worker);
            vo.setW_workno(worker);
            System.out.print("제품 코드 : " );
            String p_code = scanner.next();
            if(!dao.check_Code(p_code)){
                System.out.println("등록된 제품 코드가 없습니다");
                continue;
            }
            vo.setP_code(p_code);
            while (true){
                System.out.print("수량 : ");
                int quen = scanner.nextInt();
                if(!check_quen(quen)){
                    System.out.println("입력오류");
                    continue;
                }else {
                    vo.setW_quentity(quen);
                    break;
                }
            }

            while (true){
                System.out.print("작업 시작일 : ");
                String start_work = check_workdate(scanner.next());
                if(start_work==null){
                    System.out.println("입력오류");
                    continue;
                }else  {
                    vo.setW_workdate(start_work);
                    break;
                }
            }
            dao.insert_Smart_Worklist(vo);
            System.out.print("작업지시등록을을 계속합니다(Y/N)? ");
            if(!Check_Y_or_N(scanner.next())){
                List<SmartVO> list = dao.select_All_Product_And_Worklist();
                System.out.println("작업지시자번호 \t 제품코드 \t 제품명 \t\t\t 제품규격 \t\t 제품구분 \t 수량 \t 작업시작일");
                for(SmartVO vo1 : list){
                    System.out.println(vo1.getW_workno() + " \t\t "+ vo1.getP_code()+ " \t "+vo1.getP_name()
                            + " \t\t "+vo1.getP_size()+ " \t\t "+vo1.getP_type()+ " \t "+vo1.getW_quentity()+ " \t "+vo1.getW_workdate());
                }

                break;
            }

        }

    }

    private static boolean check_quen(int a){
        if(a<=999 && a>=1){
            return true;
        }else{
            return false;
        }
    }
    private static String check_workdate(String a){
        String[] temp_date = a.split("-");
        if(temp_date.length ==3){
            return temp_date[1]+temp_date[2];
        }else if(a.length() == 8) {
            return a.substring(4,8);
        }else return null;
    }

    private static boolean Check_Y_or_N(String a) {
        return a.equals("Y") || a.equals("y");
    }
}
