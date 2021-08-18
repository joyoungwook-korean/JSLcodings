package project_A_0805.bowling;

import org.omg.CORBA.MARSHAL;

import java.util.*;
import java.util.stream.Collectors;

public class Game_logic {
    private static final int ZERO = 0;
    private static final int STRIKE_SPARE = 10;
    private List<Integer> game_for_List;
    private static int player;
    private static Map<Integer,Integer> rank = new HashMap<>();

    // Setter로 받을 시
    public void set_to_pl_list(int player, String game){
        game_for_List = set_To_Int_List(game);
        this.player = player;
    }

    public Game_logic() {
    }

    //생성자로 받을 시
    public Game_logic(BowlingPlayer_VO game_temp) {
        game_for_List = set_To_Int_List(game_temp.getPlayer_Game_jum());
        this.player = game_temp.getPlayer();
    }

    //토탈 로직
    private static int game_Tot(List<Integer> game_List) {
        // 게임 수 체크
        int game_Su = 1;
        int one_game_tot = 0;

        for (int i = 0; i < game_List.size(); i++) {
            //스트라이크 구현로직
            if (game_List.get(i) == STRIKE_SPARE) {
                one_game_tot += one_Game(game_List.get(i), game_List.get(i + 1), game_List.get(i + 2));
                //스페어 구현로직
            } else if (game_List.get(i) + game_List.get(i + 1) == STRIKE_SPARE) {
                one_game_tot += one_Game(game_List.get(i), game_List.get(i + 1), game_List.get(i + 2));
                i++;
                //그냥 점수 구현 로직
            } else {
                one_game_tot += one_Game(game_List.get(i), game_List.get(i + 1));
                i++;
            }
            game_Su++;
            if (game_Su == 11) {
                rank.put(player,one_game_tot);
                System.out.println();
                break;
            }
        }
        return one_game_tot;

    }


    //한판 게임 로직
    private static int one_Game(int... a) {
        int sum = 0;
        for (int sum_temp : a) {
            sum += sum_temp;
        }
        return sum;
    }

    //게임 출력
    public void game_Print() {
        System.out.println(player + " Player의 점수 ");
        int game_su = 1;

        while (game_su < 11) {
            System.out.print(game_su + " Game   |  ");
            game_su++;
        }

        game_su = 1;
        System.out.println();

        for (int i = 0; i < game_for_List.size(); i++) {
            game_su++;
            //스트라이크
            if (game_for_List.get(i) == STRIKE_SPARE) {
                if (game_su == 11) {
                    System.out.print(game_for_List.get(i) + " | " + game_for_List.get(i + 1) + " | " + game_for_List.get(i + 2));
                    break;
                } else System.out.print("10  |  " + ZERO + "    ");
                //스페어
            } else if (game_for_List.get(i) + game_for_List.get(i + 1) == STRIKE_SPARE) {
                if (game_su == 11) {
                    System.out.print(game_for_List.get(i) + " | " + game_for_List.get(i + 1) + " | " + game_for_List.get(i + 2));
                    break;
                } else System.out.print(game_for_List.get(i) + "  |  " + game_for_List.get(i + 1) + "     ");
                i++;
                //그냥 점수
            } else {
                System.out.print(game_for_List.get(i) + "  |  " + game_for_List.get(i + 1) + "     ");
                i++;
            }
        }


        game_su = 1;
        System.out.println();

        for (int i = 0; i < game_for_List.size(); i++) {

            game_su++;
            //스트라이크
            if (game_for_List.get(i) == STRIKE_SPARE) {
                System.out.print(" STRIKE( "+ one_Game(game_for_List.get(i),game_for_List.get(i+1),game_for_List.get(i+2)) +" )");
                //스페어
            } else if (game_for_List.get(i) + game_for_List.get(i + 1) == STRIKE_SPARE) {
                if(game_su==11) System.out.print(" SPARE( " + one_Game(game_for_List.get(i),game_for_List.get(i+1), game_for_List.get(i+2)) + " ) ");
                else System.out.print(" SPARE( " + one_Game(game_for_List.get(i),game_for_List.get(i+1)) + " ) ");
                i++;
                //그냥 점수
            } else {
                System.out.print("    " + one_Game(game_for_List.get(i), game_for_List.get(i + 1)) + "    ");
                i++;
            }
            if (game_su == 11) {
                System.out.println();
                break;
            }
        }
        System.out.println( " 총점 : "+ game_Tot(game_for_List));


    }


    //입력받은 라인을 리스트 형식으로 변경
    public List<Integer> set_To_Int_List(String a) {
        // 스플릿으로 공백 사이를 나누어줌
        String[] a_sp = a.split(" ");
        // String[] 배열을 int[] 형 배열로 변경
        int[] nums = Arrays.stream(a_sp).mapToInt(Integer::parseInt).toArray();
        //게임 리스트를 만듦
        List<Integer> list = new ArrayList<>();
        //입력오류와 list로 숫자를 넣어줌
        for (int num_temp : nums) {
            list.add(check_Num(num_temp));
        }
        return list;
    }

    //랭크 출력
    public void rank_Order(){
        List<Map.Entry<Integer, Integer>> entries =
                rank.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());
        int cnt = rank.size();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println("rank : "+ cnt+" Player : " + entry.getKey() + ", "
                    + "Score : " + entry.getValue());
            cnt--;
        }
    }

    //입력 오류 로직
    private  int check_Num(int num) {
        if (num > 10 || num < 0) {
            System.out.println("입력 오류 !");
            System.exit(0);
        }
        return num;
    }
}
