import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //재료의 개수
        int M = Integer.parseInt(br.readLine());    // 갑옷이 완성되는 번호의 합
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int[] ingredients = new int[N];

        for (int i = 0; i < ingredients.length; i++)
            ingredients[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(ingredients);

        //투포인터 사용
        int i = 0, j = N - 1;
        while (i < j) {
            if (ingredients[i] + ingredients[j] < M)
                i++;
            else if (ingredients[i] + ingredients[j] > M)
                j--;
            else {
                count++;
                i++;
                j--;
            }
        }

/*  중첩 반복문 사용 (투포인터 사용 X)
        for (int i = 0; i < ingredients.length; i++) {
            for (int j = i + 1; j < ingredients.length; j++) {
                if (ingredients[i] + ingredients[j] == M) {
                    count++;
                    break;
                }
            }
        }

 */
        System.out.println(count);
        br.close();
    }
}
