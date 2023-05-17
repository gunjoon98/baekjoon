import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        select = new boolean[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(f(0));
    }

    static int f(int select_num) {
        if(select_num == N) {
           return cal();
        }

        int answer = Integer.MAX_VALUE;
        select[select_num] = false;
        answer = Math.min(answer, f(select_num+1));

        select[select_num] = true;
        answer = Math.min(answer, f(select_num+1));
        select[select_num] = false;
        return answer;
    }

    static int cal() {
        boolean trueGroup = false;
        boolean falseGroup = false;
        for(int i=0; i<N; i++) {
            if(select[i]) trueGroup = true;
            else falseGroup = true;
        }
        if(!trueGroup || !falseGroup) return Integer.MAX_VALUE;

        int trueGroupPoint = 0;
        int FalseGroupPoint = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(select[i] && select[j]) trueGroupPoint += matrix[i][j];
                if(!select[i] && !select[j]) FalseGroupPoint += matrix[i][j];
            }
        }
        return Math.abs(trueGroupPoint - FalseGroupPoint);
    }
}
