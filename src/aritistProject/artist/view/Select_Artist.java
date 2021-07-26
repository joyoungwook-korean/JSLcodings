package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;

import java.util.List;

public class Select_Artist {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        List<ArtistVO> list = dao.select_Artist();
        for(ArtistVO vo : list){
            System.out.println(vo);
        }
    }
}
