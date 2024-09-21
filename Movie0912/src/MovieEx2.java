import java.util.Scanner;

public class MovieEx2 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("총인원수 입력");
        int wholeP = sc.nextInt();

        System.out.println("한 줄에 앉고싶은 사람수");
        int col = sc.nextInt();

        //입력받은 값만큼 앉고 넘치는 사람이 있다면 줄을 추가해주는 식
        int row = wholeP / col; // 전체 인원수를 의자갯수로 나누면 몇 줄이 필요한지 알 수 있다
        row = row + ((wholeP%col != 0) ? 1 : 0);
        // 나머지가 있으면 한 줄을 row+1 추가해서 늘리고, 그렇지 않으면 걍 두자
        int needSeat = row * col;

        System.out.println(row+ " 줄이 필요합니다");
        System.out.println("필요한 의자 갯수는 = " + needSeat + "개 입니다");
        System.out.println();

        String[][] seat = new String[row][col];
        // String 배열에 담음
        char chRow = 'A';

        for(int i=0; i<row; i++){
            for(int k=0; k<col; k++){
                seat[i][k] = chRow+""+(k+1);
                System.out.print("(" + seat[i][k] + ") ");
                if(wholeP%needSeat != 0){
                    seat[i][k] = "**";
                }
            }
            chRow++;
            System.out.println();
        }

    }
}
