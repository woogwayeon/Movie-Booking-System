/*
    극장 예약 시스템
    전체 40명
    한 줄에 몇 명 앉아야 하는지 물어보고 // 10명씩
*/

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("전체 인원이 몇명인가요");
        int total = sc.nextInt();

        System.out.println("한 줄에 몇 명이 앉을건가요");
        int col = sc.nextInt();

        // 40/10 = 4, 40/9=4+1 - 총 자리가 45개?

        int row = total / col;
        row = row + ((total % col != 0) ? 1 : 0); // 나머지 자리
        // 남는 사람이 못앉으면 안되니까 줄 늘려주자 그래서 나머지가 생기면 한 줄 더 해주는식

        System.out.println(row + ", " + col);
        String[][] seat = new String[row][col]; // int 배열의 배열
        char ch = 'A';
        //기본 좌석을 입력하고
        for(int a=0; a<row; a++){
            for(int b=0; b<col; b++){
                seat[a][b]=ch+""+(b+1);
            }
            ch++;
        }
        //예약좌석을 **로 변경하고
        System.out.println("예약할 좌석 번호를 입력해 주세요");
        String target = sc.next();

        for(int a=0; a<row; a++){
            for(int b=0; b<col; b++){
                if(target.equals(seat[a][b])){
                    seat[a][b]="**";
                }
            }
        }

        //출력처리만 진행
        for(int a=0; a<row; a++){
            for(int b=0; b<col; b++){
                System.out.print("("+seat[a][b]+") ");
            }
            System.out.println();
        }




        //for (int i = 0; i < row; i++) {       // 바깥의 for - 행

            //for (int j = 1; j <= col; j++){   // 안쪽 for - 열

                //System.out.print("(" + (char) (ch + i) + j + ") ");

            //}
            //System.out.println();

            // 전체 인원보다 큰 자리수만큼은 비활성화 시켜야 한다!

        /*
            (A1)(A2)(A3)(A4)(A5)...(A9)
            (B1)(B2)(B3)(B4)(B5)...(B9)
            (C1)(C2)(C3)(C4)(C5)...(C9)
            (D1)(D2)(D3)(D4)(D5)...(D9)
            (E1)(E2)(E3)(E4)(**)...(**)

            A1 자리를 예약합니다
            (00)(A2)(A3)(A4)(A5)...(A9)
            (B1)(B2)(B3)(B4)(B5)...(B9)
            (C1)(C2)(C3)(C4)(C5)...(C9)
            (D1)(D2)(D3)(D4)(D5)...(D9)
            (E1)(E2)(E3)(E4)(**)...(**)
         */

        //}// for

    } // main
}