//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package smartProject.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import smartProject.util.SmartMysqlManager;

public class SmartDAO {
    private static SmartDAO instance = new SmartDAO();

    private SmartDAO() {
    }

    public static SmartDAO getInstance() {
        return instance;
    }

    public void insert_Smart_Product(SmartVO vo) {
        String sql_insert = "insert into tbl_product_201909 values(?,?,?,?,?)";
        PreparedStatement pstmt = SmartMysqlManager.con(sql_insert);

        try {
            pstmt.setString(1, vo.getP_code());
            pstmt.setString(2, vo.getP_name());
            pstmt.setString(3, vo.getP_size());
            pstmt.setString(4, vo.getP_type());
            pstmt.setInt(5, vo.getP_price());
            pstmt.executeUpdate();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public List<SmartVO> select_All_Smart_Product() {
        String select_Product = "select * from tbl_product_201909";
        PreparedStatement pstmt = SmartMysqlManager.con(select_Product);
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            rs = pstmt.executeQuery();

            while(rs.next()) {
                SmartVO vo = new SmartVO();
                vo.setP_code(rs.getString("p_code"));
                vo.setP_name(rs.getString("p_name"));
                vo.setP_size(rs.getString("p_size"));
                vo.setP_type(rs.getString("p_type"));
                vo.setP_price(rs.getInt("p_price"));
                list.add(vo);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            SmartMysqlManager.close(pstmt, rs);
        }

        return list;
    }

    public boolean check_Code(String code) {
        String sql = "select p_code from tbl_product_201909 where p_code=?";
        PreparedStatement stmt = SmartMysqlManager.con(sql);
        boolean check_bool = false;

        try {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return check_bool;
    }
}
