package com.company.JSL_08.jsl_210823.model;

import com.company.JSL_08.jsl_210823.util.DBLogic;
import com.company.JSL_08.jsl_210823.util.DBManager;
import com.company.JSL_08.jsl_210823.util.OracleDBManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopDAO {
    public DBLogic dbLogic;

    public ShopDAO() {
        DBManager dbManager = new OracleDBManager();
        dbLogic = new DBLogic(dbManager.getConnection());
    }

    public void update_Shop_01(CommVO vo) {
        dbLogic.con_Update("insert into tbl_member_001 values (?,?,?,?,?,?,?)"
                , vo.getCustno(), vo.getCustname(), vo.getPhone(), vo.getGender(),
                vo.getJoindate(), vo.getGrade(), vo.getCity());
    }

    public List<Map<String, Object>> select_Shop_03() {
        List<Map<String, Object>> list = dbLogic.con_Select("select * from tbl_member_001");
        for (Map<String, Object> map : list) {
            if (map.get("GENDER").equals("M")) map.replace("GENDER", "male");
            else map.replace("GENDER", "female");

            if (map.get("GRADE").equals("A")) map.replace("GRADE", "VIP");
            else if (map.get("GRADE").equals("B")) map.replace("GRADE", "일반");
            else map.replace("GRADE", "직원");
        }
        return list;
    }


    public int check_CustNo() {
        List<Map<String, Object>> list = dbLogic.con_Select("select max(custno) as custno from tbl_member_001");
        int no = 100001;
        if (list.get(0).get("CUSTNO") != null) {
            no = (int) list.get(0).get("CUSTNO") + 1;
        }
        return no;
    }

}
