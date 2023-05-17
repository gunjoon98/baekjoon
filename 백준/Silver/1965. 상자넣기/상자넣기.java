import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] sizes = new int[N];
		int[] dp = new int[N];
		int answer = 1;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) sizes[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			int max_dp = 0;
			for(int j=0; j<i; j++) {
				if(sizes[j] < sizes[i]) max_dp = Math.max(max_dp, dp[j]);
			}
			dp[i] = max_dp + 1;
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}