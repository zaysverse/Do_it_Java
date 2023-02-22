import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P12891_DNA비밀번호 {
    static int[] checkDNA;                // 조건을 충족했는지
    static int[] minDNA;                 // 부분 문자열에 포함돼야 할 A, C, G, T의 최수 개수
    static int valid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   // DNA 문자열의 길이
        int T = Integer.parseInt(st.nextToken());   // 부분 문자열의
        int count = 0;
        valid = 0;
        checkDNA = new int[4];
        minDNA = new int[4];
        String dnaString = br.readLine();
        char[] dnaChar = dnaString.toCharArray();   // DNA 문자열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minDNA[i] = Integer.parseInt(st.nextToken());
            if (minDNA[i] == 0) valid++;
        }

        for (int i = 0; i < T; i++) {
            Add(dnaChar[i]);
        }
        if (valid == 4)
            count++;
        for (int i = T; i < S; i++) {
            int j = i - T;
            Add(dnaChar[i]);
            Remove(dnaChar[j]);
            if (valid == 4)
                count++;
        }
        System.out.println(count);
        br.close();
    }

    public static void Add(char c) {
        switch (c) {
            case 'A':
                checkDNA[0]++;
                if (checkDNA[0] == minDNA[0]) valid++;
                break;
            case 'C':
                checkDNA[1]++;
                if (checkDNA[1] == minDNA[1]) valid++;
                break;
            case 'G':
                checkDNA[2]++;
                if (checkDNA[2] == minDNA[2]) valid++;
                break;
            case 'T':
                checkDNA[3]++;
                if (checkDNA[3] == minDNA[3]) valid++;
                break;
        }
    }

    public static void Remove(char c) {
        switch (c) {
            case 'A':
                if (checkDNA[0] == minDNA[0]) valid--;
                checkDNA[0]--;
                break;
            case 'C':
                if (checkDNA[1] == minDNA[1]) valid--;
                checkDNA[1]--;
                break;
            case 'G':
                if (checkDNA[2] == minDNA[2]) valid--;
                checkDNA[2]--;
                break;
            case 'T':
                if (checkDNA[3] == minDNA[3]) valid--;
                checkDNA[3]--;
                break;
        }
    }
}
