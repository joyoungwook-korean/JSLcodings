//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package smartProject.view;

import java.util.*;

import smartProject.model.SmartDAO;
import smartProject.model.SmartVO;

public class Product_Insert_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartDAO dao = SmartDAO.getInstance();
        new ArrayList();

        while (true) {
            while (true) {
                System.out.println("제품 등록 화면");
                String code = scanner.next();
                if (dao.check_Code(code)) {
                    System.out.println("이미 등록된 코드 입니다.");
                } else {
                    SmartVO vo1 = new SmartVO();
                    vo1.setP_code(code);
                    System.out.print("제품명 : ");
                    vo1.setP_name(scanner.next());
                    System.out.print("제품규격 : ");
                    vo1.setP_size(scanner.next());
                    System.out.print("제품구분 : ");
                    vo1.setP_type(scanner.next());
                    System.out.print("제품단가 : ");
                    vo1.setP_price(scanner.nextInt());
                    dao.insert_Smart_Product(vo1);
                    System.out.println("제품등록을 계속합니다(Y/N)? ");
                    if (!Check_Y_or_N(scanner.next())) {
                        List<SmartVO> list = dao.select_All_Smart_Product();
                        System.out.println("제품코드 \t 제품명 \t  \t  제품규격 \t  \t 제품구분 \t 제품단가");
                        Iterator var6 = list.iterator();
                        while (var6.hasNext()) {
                            vo1 = (SmartVO) var6.next();
                            System.out.println(vo1.getP_code() + " \t " + vo1.getP_name() + " \t \t " + vo1.getP_size() + " \t " + vo1.getP_type() + " \t " + Currency.getInstance(Locale.KOREA).getSymbol() + vo1.getP_price());
                        }

                        return;
                    }
                }
            }
        }
    }

    private static boolean Check_Y_or_N(String a) {
        return a.equals("Y") || a.equals("y");
    }
}
