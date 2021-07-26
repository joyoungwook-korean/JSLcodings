package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;

import java.util.List;

public class Select_Max_mem {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        List<ArtistVO> list = dao.select_Join_Max_mem();
        for(ArtistVO vo : list){
            System.out.print(vo.getArtist_id()+" \t "+vo.getArtist_name()+" \t "+vo.getArtist_gender()+" \t ");
            System.out.print(vo.getPoint()+" \t "+vo.getSerial_no()+" \t "+vo.getAvg());
            System.out.println();
        }
    }
}
