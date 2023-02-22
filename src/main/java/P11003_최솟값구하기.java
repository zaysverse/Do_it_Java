import java.io.*;
import java.util.*;

public class P11003_최솟값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 숫자의 개수
        int T = Integer.parseInt(st.nextToken());       // 슬라이딩 윈도우 개수
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value >= cur)
                deque.removeLast();
            deque.addLast(new Node(cur, i));
            bw.write(deque.getFirst().value+" ");
            if (i - deque.getFirst().index + 1 >= T)
                deque.removeFirst();
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int value;
        int index;

        Node(int v, int i) {
            value = v;
            index = i;
        }
    }
}


