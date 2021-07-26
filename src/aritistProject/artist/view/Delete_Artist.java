package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;

import java.util.List;
import java.util.Scanner;

public class Delete_Artist {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("채점 번호 : " );
        dao.delete_Artist(scanner.next());
        System.out.println();
        List<ArtistVO> list = dao.select_Artist();
        for(ArtistVO vo : list){
            System.out.println(vo);
        }
    }
}
