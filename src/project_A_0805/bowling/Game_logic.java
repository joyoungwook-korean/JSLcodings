package project_A_0805.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game_logic {
    private static final int STRIKE_SPARE = 10;

    //토탈 로직
    public int game_Tot(List<Integer> game_List) {
        int one_game_tot = 0;
        int game_Su = 0;

        for (int i = 0; i < game_List.size(); i++) {
            if (game_List.get(i) == STRIKE_SPARE) {
                one_game_tot += one_Game(game_List.get(i) + game_List.get(i + 1) + game_List.get(i + 2));
                game_Su++;

            } else if (game_List.get(i) + game_List.get(i + 1) == STRIKE_SPARE) {
                one_game_tot += one_Game(game_List.get(i) + game_List.get(i + 1) + game_List.get(i + 2));
                game_Su++;
                i++;
            } else {
                one_game_tot += one_Game(game_List.get(i) + game_List.get(i + 1));
                game_Su++;
                i++;
            }
            if (game_Su == 10) {
                break;
            }
        }
        return one_game_tot;

    }

    //한판 게임 로직
    private int one_Game(int... a) {
        int sum = 0;
        for (int sum_temp : a) {
            sum += sum_temp;
        }
        return sum;
    }

    public List<Integer> set_To_Int_List(String a){
        // 스플릿으로 공백 사이를 나누어줌
        String[] a_sp= a.split(" ");
        // String[] 배열을 int[] 형 배열로 변경
        int[] nums = Arrays.stream(a_sp).mapToInt(Integer::parseInt).toArray();
        //게임 리스트를 만듦
        List<Integer> list = new ArrayList<>();
        //입력오류와 list로 숫자를 넣어줌
        for(int num_temp : nums){
            list.add(check_Num(num_temp));
        }
        return list;
    }

    //입력 오류 로직
    private int check_Num(int num){
        if(num>10 || num<0){
            System.out.println("입력 오류 !");
            System.exit(0);
        }
        return num;
    }
}
