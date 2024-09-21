import java.util.Scanner;

public class MovieEx {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("전체 인원이 몇 명인가요?");
        int wholeP = sc.nextInt(); // 전체 인원을 입력받음

        System.out.println("한 줄에 몇 명이 앉을거?");
        int col = sc.nextInt(); // 몇 명씩 앉을건지

        int row = wholeP / col;
        row = row + ((wholeP % col != 0)? 1 : 0);
        // 전체 인원에서 몇 명씩 앉을건지 확인하고 남은 자리가 없으면 한 줄 추가

        int needSeat = row * col;

        System.out.println("필요한 의자 개수는 " + needSeat);
        System.out.println("row = " + row+", col = " + col);
        System.out.println();

        // 기본 좌석 만들기

        char ch = 'A';
        String[][] seat = new String[row][col];
        // row : 줄 , col : 의자번호
        // int[][] a = new int[main][sub];
        // 이런 이차원 배열이 있다고 하면, main 안에 sub 만큼 배열이 또 생기는거다
        // int[][] a = new int[2][9];
        // 이렇게 하면 a[0],a[1] 안에 또 각각 배열 9개가 들어간다는것!
        // 우리는 줄 안에 의자수를 만드는 거니까 row 라는 좌석이 나란히 있는 줄 안에
        // col(한 줄에 몇 명 앉을지) - 의자갯수를 넣어줘야겠죠!

        for(int i=0; i<row; i++){
            // 1. row가 줄이었으니까 먼저 for 문을 만들어서 줄을 만들어준다
            for(int k=0; k<col; k++){
                // 2. col 만큼 의자를 만들어준다(줄에 의자 배치하기)
                seat[i][k] = ch+""+(k+1);
                // seat[i][k] (문자형임) = 대입됨 ch(A-...) + 빈칸 + k만큼인데 1번부터 시작하려고 +1
                System.out.print("(" + seat[i][k] + ") ");
            }
            ch++; // for 돌아가는 만큼 1씩 추가 (A,B,C,D,E...)
            System.out.println();
        }// 좌석표 만드는 for

        // 예약받을 좌석을 입력받기
        System.out.println("예약하고 싶은 좌석을 확인한 뒤 좌석 번호를 입력해 주세요");
        String target = sc.next(); // 문자열은 nextString() 이런게 아닌가보다(?)

        // 입력받은 좌석을 ** 표시로 바꾸기
        for(int i=0; i<row; i++){
            for(int k=0; k<col; k++){
            // 여기까지는 아까 좌석표 만들고 출력하는 식이랑 똑같다!
            // 이번엔 입력받은 좌석 바꾸기! 라는 조건이 생김. 조건을 추가해주는거니까 if문!
                if(target.equals(seat[i][k])){
                    seat[i][k]="**";
                    // target 이 문자형이라서 그런지 모르겠는데(?)
                    // if(target==seat[i][k]) 이런 형태로 쓸 수가 없다
                }
                System.out.print("("+ seat[i][k] + ") ");
            }
            System.out.println();
        } // ** 만드는 for


    }// main
}// class
