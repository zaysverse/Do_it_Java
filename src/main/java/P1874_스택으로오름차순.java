import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.Stack;

public class P1874_스택으로오름차순 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int top = 1;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (top <= cur) {
                while (top <= cur) {
                    stack.push(top++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();
                if (pop > cur) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}

