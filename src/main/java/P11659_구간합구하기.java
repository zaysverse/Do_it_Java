import java.util.Scanner;

public class P11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dataNo = sc.nextInt();      // 데이터의 개수
        int quizNo = sc.nextInt();      //질의 개수
        int[] arr = new int[dataNo + 1];

        //구간합
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        //질의
        for(int q=0;q<quizNo;q++){
            int i=sc.nextInt(),j=sc.nextInt();
            System.out.println(arr[j]-arr[i-1]);
        }

        /* [배열이 0부터 시작할 경우]
        arr[0] = sc.nextInt();
        for (int i = 1; i < dataNo; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        for (int q = 0; q < quizNo; q++) {
            int i = sc.nextInt(), j = sc.nextInt();
            if(i==1) System.out.println(arr[j-1]);
            else System.out.println(arr[j - 1] - arr[i - 2]);
        }
         */
    }
}
