package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;

import java.util.Scanner;

public class Insert_Artist {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        ArtistVO vo = new ArtistVO();
        Scanner scanner = new Scanner(System.in);

        vo.setArtist_id(scanner.next());
        vo.setArtist_name(scanner.next());
        vo.setArtist_gender(scanner.next());
        vo.setArtist_birth(scanner.next());
        vo.setTalent(scanner.next());
        vo.setAgency(scanner.next());
        dao.insert_artist(vo);

    }
}
