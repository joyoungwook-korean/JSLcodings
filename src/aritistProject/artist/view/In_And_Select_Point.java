package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;
import aritistProject.artist.util.ArtistMysqlManager;

import java.util.List;
import java.util.Scanner;

public class In_And_Select_Point {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        Scanner scanner = new Scanner(System.in);


        ArtistVO vo = new ArtistVO();
        vo.setSerial_no(scanner.nextInt());
        vo.setArtist_id(scanner.next());
        vo.setMento_id(scanner.next());
        vo.setPoint(scanner.nextInt());
        dao.insert_point(vo);


        List<ArtistVO> list = dao.select_point();

        for (ArtistVO print_vo : list) {
            System.out.println(print_vo.getSerial_no() + " \t " + print_vo.getArtist_id() + " \t " + print_vo.getMento_id() + " \t " + print_vo.getPoint());
        }

    }
}
