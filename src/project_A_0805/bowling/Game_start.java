package project_A_0805.bowling;

import java.util.*;

public class Game_start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("몇명이서 플레이 하시겠습니까? ");
        int player = scanner.nextInt();
        scanner.nextLine();
        Game_logic game_logic = new Game_logic();
        for(int i=1; i<=player; i++){
            System.out.println(i + " Player 점수를 입력해 주십시오." );
            String game= scanner.nextLine();
            game_logic.set_to_pl_list(i,game);
            game_logic.game_Print();
            if(i==player) game_logic.rank_Order();
        }

    }
}
