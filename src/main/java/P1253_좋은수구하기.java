import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        int niceNum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);
        for (int cur = 0; cur < N; cur++) {
            int i = 0, j = N - 1;
            while (i < j) {
                long find = A[cur];
                if (A[i] + A[j] == find) {
                    if (i != cur && j != cur) {
                        niceNum++;
                        break;
                    } else if (i == cur) i++;
                    else if (j == cur) j--;
                } else if (A[i] + A[j] < find)
                    i++;
                else
                    j--;
            }
        }
        System.out.println(niceNum);
        br.close();
    }
}
