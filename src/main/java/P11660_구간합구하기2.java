import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N*N 배열, (X1,Y1)~(X2,Y2)까지의 합 구하기.
구간합 : S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j]
질의 : S[X2][Y2] - S[X1-1][Y2] - S[X2][Y1-1] + S[X1-1][Y1-1]
 */

public class P11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       //2차원 배열의 크기
        int quizNo = Integer.parseInt(st.nextToken());    //질의 개수
        int[][] A = new int[N + 1][N + 1];
        int[][] S = new int[N + 1][N + 1];

        //2차원 배열 입력받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //합배열 구하기
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j];
            }
        }

        //질의
        for(int q=0;q<quizNo;q++){
            st=new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
        }
        br.close();
    }
}
