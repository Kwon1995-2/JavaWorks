package JavaStudy.Gradle_Java;
import java.util.*;
public class Tile2 {
    public static int makeRandom() {
        Random random = new Random();
        int r = random.nextInt(7) + 1;
        return r;
    }
    public static void view(int[][] array) {
        for(int[] i: array) {
            for(int j:i)
                System.out.printf("%3d ",j);
                // if (j == -1) System.out.print(j+ " ");
                // else         System.out.print(" " + j+ " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //원래 배열
        int bug[][] = new int[8][8];
        //marking 배열 및 초기화
        int[][] bigbug = new int[10][10];
        for(int i=0;i<10;i++){
            bigbug[0][i] = -1; bigbug[9][i] = -1;
            bigbug[i][0] = -1; bigbug[i][9] = -1;
        } 
        //방향 배열 int[][] var -> java style 선언
        int[][] dir = {{-1,-1,0,1,1,1,0,-1},{0,1,1,1,0,-1,-1,-1}}; //{row}, {col}
        
        //방향 설정
        int ran=0, row=makeRandom(), col=makeRandom();
        int x, y;
        bug[row][col] = 1;

        //루프 돌리기
        int count=0; int Totalcount = 0;
        while(true){
            if(count == 63) break;
            Totalcount++;
            ran = makeRandom();
            x = row + dir[0][ran]; y = col + dir[1][ran];
            if(bigbug[x+1][y+1] == -1) continue;
            else { //if(bigbug[x+1][y+1] == 0 && bug[x][y] == 0) {
                if(bug[x][y]++ == 0) {
                    //bigbug[x+1][y+1]++;
                    count++;
                }
            row = x;
            col = y;
            //System.out.print(count+" ");
            }
        }
        //무한루프 탈출 못하면 밑에 닫지 않는다.
        view(bug);
        view(bigbug);
        System.out.print("count:"+count+", Totalcount:"+Totalcount);
    }   
}
