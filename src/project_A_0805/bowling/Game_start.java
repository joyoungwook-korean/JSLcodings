package project_A_0805.bowling;

import java.util.*;

public class Game_start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        Game_logic ss = new Game_logic();
        System.out.println(ss.game_Tot(ss.set_To_Int_List(a)));
    }
}
