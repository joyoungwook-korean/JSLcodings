package StudentProject.view;

import StudentProject.model.StudentDAO;

import java.util.Scanner;

public class Delete_Sc_St {
    public static void main(String[] args) {
        StudentDAO dao = StudentDAO.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("학번 입력 : ");
        dao.delete_student(scanner.next());
    }
}
