import java.util.Scanner;

public class P2018_연속된자연수의합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, start_index = 1, end_index = 1;
        int sum = start_index;
        int N = sc.nextInt();

        while (end_index <= N) {
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum+=end_index;
            }
        }
        System.out.println(count);
    }
}
