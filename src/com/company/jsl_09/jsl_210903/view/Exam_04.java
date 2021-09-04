package com.company.jsl_09.jsl_210903.view;

import com.company.jsl_09.jsl_210903.dao.AirPollutionDAO;

public class Exam_04 {
    public static void main(String[] args) {
        AirPollutionDAO dao = AirPollutionDAO.getConnection();
        dao.view_04(dao.select_04());
    }
}
