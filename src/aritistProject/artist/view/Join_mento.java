package aritistProject.artist.view;

import aritistProject.artist.model.ArtistDAO;
import aritistProject.artist.model.ArtistVO;

import java.util.List;

public class Join_mento {
    public static void main(String[] args) {
        ArtistDAO dao = ArtistDAO.getInstance();
        List<ArtistVO> vo = dao.select_Join_Mento();
        for(ArtistVO print_vo : vo){
            System.out.print(print_vo.getSerial_no() +" \t "+print_vo.getArtist_id()+" \t "+print_vo.getArtist_name()+" \t ");
            System.out.print(print_vo.getArtist_birth()+" \t "+print_vo.getPoint()+" \t "+print_vo.getString_Point()+" \t "+print_vo.getMento_name());
            System.out.println();
        }

    }
}
