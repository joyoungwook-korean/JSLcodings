package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;
import aritistProject.artist.util.ArtistMysqlManager;

import java.util.List;
import java.util.Scanner;

public class Update_Point {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        Scanner scanner = new Scanner(System.in);
        dao.update_point(scanner.nextInt(),scanner.nextInt());
        List<ArtistVO> list = dao.select_point();
        for (ArtistVO print_vo : list) {
            System.out.println(print_vo.getSerial_no() + " \t " + print_vo.getArtist_id() + " \t " + print_vo.getMento_id() + " \t " + print_vo.getPoint());
        }
    }
}
