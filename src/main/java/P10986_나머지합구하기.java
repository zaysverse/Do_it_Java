import java.util.Scanner;

/*
N개의 수. 배열 A[N]. 연속된 부분의 합이 M의 나누어 떨어지는 구간의 개수를 구하라.
C[합배열 % M]++  =>  조합 n개 중 2개를 뽑아서 선택 -> n*(n-1)/2
1. 0 ~ C[0]
2. 1이상 인덱스부터 조합 선택
answer = 1번 + 2번
 */
public class P10986_나머지합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] A = new long[N];
        long[] C = new long[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if (i != 0) A[i] += A[i - 1];
            C[(int) (A[i] % M)]++;
        }

        long answer = C[0];
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) answer += C[i] * (C[i] - 1) / 2;
        }

        System.out.println(answer);

    }
}
