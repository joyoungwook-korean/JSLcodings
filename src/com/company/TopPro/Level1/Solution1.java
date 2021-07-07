package com.company.TopPro.Level1;

public class Solution1 {
    public static void main(String[] args) {


    }
    public String solution(String[] participant, String[] completion) {
        int max_people = 100000;
        int cnt=0;
        String answer = "11";

        if(participant.length> 1){
            if(participant.length<max_people){
                for(int i=0; i<participant.length;i++){
                    for(int y=1; y<participant.length;y++){
                        if(participant[i]==participant[y]){
                            cnt++;
                        }
                    }
                }

                for(int i=0; i<participant.length;i++){
                    for(int y=0; y<completion.length;y++){
                        if(participant[i].equals(completion[y])){
                            if(cnt==2) {
                                cnt--;
                                continue;
                            }else{
                                break;
                            }
                        }else{
                            answer = participant[i];
                        }
                    }
                }

            }
        }


        return answer;
    }
}
