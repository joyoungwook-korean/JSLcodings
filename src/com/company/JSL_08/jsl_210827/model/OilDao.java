package com.company.JSL_08.jsl_210827.model;

import com.company.JSL_08.jsl_210827.util.DBLogic;
import com.company.JSL_08.jsl_210827.util.DBManager;
import com.company.JSL_08.jsl_210827.util.OracleDBManager;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OilDao {
    DBLogic dbLogic;

    public OilDao(DBLogic dbLogic) {
        this.dbLogic = dbLogic;
    }

    private static OilDao connecntion(){
        DBManager manager = new OracleDBManager();
        DBLogic logic = new DBLogic(manager.getConnection());
        OilDao oilDao = new OilDao(logic);
        return oilDao;
    }

    public static OilDao getOilDao(){
        return connecntion();
    }

    public List<Map<String,Object>> oil_Exam01(){
        String sql = "select saleno,oildate,oilname,amount,paytype,custname,si.custno,(custtel1||'-'||custtel2||'-'||custtel3) as custtel, creditcard, oilcost, sum(si.oilcost) over (  )as sumcost  from TBL_SALEINFO_202010 si, TBL_OILINFO_202010 oi, TBL_CUSTINFO_202010 ci "+
        "where si.oiltype=oi.oiltype and si.custno=ci.custno(+)";
        List<Map<String, Object>> list = dbLogic.con_Select(sql);

        for(Map<String,Object> map : list){
            if(map.get("PAYTYPE").equals(1)) map.replace("PAYTYPE","현금");
            else map.replace("PAYTYPE","카드");
            if(map.get("CUSTNO")==null) map.replace("CUSTNO","비회원");
            if(map.get("CUSTNAME")==null) map.replace("CUSTNAME","비회원");
            if(map.get("CUSTTEL").equals("--")) map.replace("CUSTTEL","010-0000-0000");
            if(map.get("CREDITCARD")==null) map.replace("CREDITCARD","");
            DecimalFormat format = new DecimalFormat("###,###");
            map.replace("OILCOST", Currency.getInstance(Locale.KOREA).getSymbol()+format.format(Integer.parseInt((String)map.get("OILCOST"))));
            map.replace("SUMCOST", Currency.getInstance(Locale.KOREA).getSymbol()+format.format(Integer.parseInt((String)map.get("SUMCOST"))));
            String year = map.get("OILDATE").toString().substring(0,4);
            String month = map.get("OILDATE").toString().substring(4,6);
            String day = map.get("OILDATE").toString().substring(6,8);
            map.replace("OILDATE",year+"년"+month+"월"+day+"일");
        }

        return list;
    }

    public List<Map<String,Object>> oil_Exam_02(){
        String sql = "select OILDATE,OILNAME,COUNT(OILNAME)||'건' as gun ,sum(OILCOST) as OIL_SUM from TBL_SALEINFO_202010 si , TBL_OILINFO_202010 oi where si.OILTYPE=oi.OILTYPE  group by OILDATE,OILNAME order by OILDATE, OILNAME";
        List<Map<String,Object>> list = dbLogic.con_Select(sql);
        for(Map map : list){
            DecimalFormat format = new DecimalFormat("###,###");
            map.replace("OIL_SUM", Currency.getInstance(Locale.KOREA).getSymbol()+format.format(Integer.parseInt((String)map.get("OIL_SUM"))));
            String year = map.get("OILDATE").toString().substring(0,4);
            String month = map.get("OILDATE").toString().substring(4,6);
            String day = map.get("OILDATE").toString().substring(6,8);
            map.replace("OILDATE",year+"년"+month+"월"+day+"일");
        }

        return list;
    }



}
