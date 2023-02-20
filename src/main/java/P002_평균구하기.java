import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 점수 = 점수 / 최고점 * 100
   평균 = (점수1 + 점수2 + ... + 점수n) /최고점 * 100 / N(총 과목의 개수)
*/
public class P002_평균구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 시험을 본 과목의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        double sum = 0, max = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum += n;
            max = Math.max(max, n);
        }
        double answer = sum / max * 100.0 / N;
        System.out.println(answer);
    }
}
