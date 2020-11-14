package JavaStudy.Gradle_Java;
import java.util.Random;
public class Tile {

    // final class Index {
    //     private final int x;

    //     public Index(int x) {
    //         this.x = x;
    //     }
    // }

    public static int makeRandom() {
        Random random = new Random();
        int r = random.nextInt(7) + 1;
        return r;
    }

    // public static void Worm(int[][] bug, Inxe i, int j) {
        
    // }

    public static void main(String[] args) {
        int bug[][] = new int[8][8];
        //배열 초기화
        // for(int i=0;i<bug.length;i++)
        //     for(int j=0;j<bug[i].length;j++)
        //         bug[i][j] = 0;
        
        //초기 1의 위치 설정
        int i = makeRandom();
        int j = makeRandom();
        bug[i][j] = 1;

        //Worm 함수 생성
        int rand = 0;
        int innercount = 0;
        int Totalcount = 0;
        while(true) {
            if(Totalcount == 63) break;
            rand = makeRandom();
            int row = i; int col = j;
            switch(rand) {
                case 0: 
                    if(i == 0) break;
                    i++;
                    break;
                case 1: 
                    if(i == 0 || j == 7) break;
                    i--; j++;
                    break;
                case 2: 
                    if(j == 7) break;
                    j++;
                    break;
                case 3: 
                    if(i == 7 || j == 7) break;
                    i++; j++;
                    break;
                case 4:
                    if(i == 7) break;
                    i++;
                    break;
                case 5: 
                    if( i == 7  || j == 0) break;
                    i++; j--; 
                    break;
                case 6:
                    if(j == 0 ) break;
                    j--;
                    break;
                case 7: 
                    if(i == 0 || j == 0) break;
                    i--; j--;
                    break;
            }
            innercount++;
            if(bug[i][j] == 1) continue;
            bug[i][j]++;
            if( (row != i || col != j) && bug[i][j] == 1)
                Totalcount++;
        }
        //배열 출력
        for(i=0; i<bug.length;i++) {
            for(j=0;j<bug[i].length;j++)
                System.out.print(bug[i][j]+" ");
            System.out.println();    
        }
        System.out.println("count:"+Totalcount+", incount:"+innercount);
    }
}
