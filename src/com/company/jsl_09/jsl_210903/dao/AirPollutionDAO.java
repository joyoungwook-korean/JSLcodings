package com.company.jsl_09.jsl_210903.dao;

import com.company.jsl_09.jsl_210903.util.DBLogic;
import com.company.jsl_09.jsl_210903.util.DBManager;
import com.company.jsl_09.jsl_210903.util.OracleDBManager;

import java.util.List;
import java.util.Map;

public class AirPollutionDAO {
    DBLogic dbLogic = null;

    public static AirPollutionDAO getConnection(){
        return new AirPollutionDAO();
    }
    private AirPollutionDAO() {
        DBManager dbManager = new OracleDBManager();
        dbLogic = new DBLogic(dbManager.getConnection());
    }

    public List<Map<String,Object>> select_City_01(){
        String sql ="select city_code,city_name, (RTRIM(city_tel1)||'-'||city_tel2||'-'||city_tel3) as tel,tc.area_code,AREA_NAME, city_admin, city_level\n" +
                " from TBL_CITY_202005 tc, TBL_AREA_202005 ta where tc.area_code=ta.AREA_CODE";
        List<Map<String,Object>> list = dbLogic.con_Select(sql);
        return list;
    }

    public void insert_Test(String date, String am_pm, String code, String num, int val){
        String sql = "insert into TBL_TEST_202005 values (?,?,?,?,?)";
        dbLogic.con_Update(sql, date,am_pm,code,num,val);
    }

    public List<Map<String,Object>> select_Test_03(){
        String sql = "select (SUBSTR(test_date,0,4)||'년'||SUBSTR(test_date,5,2)||'월'||SUBSTR(test_date,7,2)||'일') as date_a," +
                "       test_ampm,pollution,tt.city_code,city_name,ta.AREA_NAME,test_value" +
                " from TBL_TEST_202005 tt , TBL_AREA_202005 ta, TBL_CITY_202005 tc where tt.city_code=tc.city_code and ta.AREA_CODE=tc.AREA_CODE" +
                " order by test_ampm,tc.city_code";
        List<Map<String,Object>> list = dbLogic.con_Select(sql);
        return list;
    }



    public void view_01(List<Map<String,Object>> list){
        System.out.println("관측지점번호\t관측지점명\t권역코드\t권역명칭\t담당전화\t담당자\t직급");
        for(Map<String,Object> map : list){
            System.out.println(map.get("CITY_CODE")+ " \t "+map.get("CITY_NAME")+ " \t "+
                    map.get("TEL") + " \t "+map.get("AREA_NAME")+ " \t "+map.get("AREA_CODE")+ " \t "+
                    map.get("CITY_ADMIN")+ " \t "+
                    change_Level((String) map.get("CITY_LEVEL")));

        }
    }

    public void view_03(List<Map<String,Object>> list){
        System.out.println("관측일자\t측정시기\t대기오염코드\t관측지점번호\t관측지점명\t권역지역명\t측정값");
        for(Map<String,Object> map : list){
            System.out.println(map.get("DATE_A")+" \t "+ change_am_pm((String)map.get("TEST_AMPM"))+" \t "+
                    map.get("POLLUTION")+" \t "+map.get("CITY_CODE")+" \t "+
                    map.get("CITY_NAME")+" \t "+map.get("AREA_NAME")+" \t "+
                    map.get("TEST_VALUE"));
        }
    }

    public List<Map<String,Object>> select_04(){
        String sql = "select  (SUBSTR(test_date,0,4)||'년'||SUBSTR(test_date,5,2)||'월'||SUBSTR(test_date,7,2)||'일') as date_a, "+
        "city_name, TRUNC(sum(test_value)/count(test_value),0) as avg, "+
        "case when TRUNC(sum(test_value)/count(test_value),0) >150 then '매우나쁨' "+
        "when TRUNC(sum(test_value)/count(test_value),0) >80 then '나쁨' "+
        "when TRUNC(sum(test_value)/count(test_value),0) >30 then '보통' "+
        "else '좋음' "+
        "end as PL "+
        "from TBL_TEST_202005 tb , TBL_CITY_202005 tc where tb.city_code=tc.city_code group by city_name,test_date";

        List<Map<String,Object>> list = dbLogic.con_Select(sql);
        return list;
    }

    public void view_04(List<Map<String,Object>> list){
        System.out.println("관측일자\t관측지점명\t일평균수치\t상태");
        for(Map<String,Object> map : list){
            System.out.println(map.get("DATE_A")+" \t "+map.get("CITY_NAME")+" \t "+
                    map.get("AVG")+" \t "+map.get("PL"));
        }
    }

    private String change_Level(String level){
        if(level.equals("1")) return "사원";
        else if(level.equals("2")) return "주임";
        else if(level.equals("3")) return "대리";
        else return "과장";
    }
    private String change_am_pm(String ampm){
        if(ampm.equals("AM")) return "오전";
        else return "오후";
    }


}
