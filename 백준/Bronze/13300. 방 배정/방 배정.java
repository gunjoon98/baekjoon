import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N, K;
		int[][] count = new int[7][2];
		int answer = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int agree = Integer.parseInt(st.nextToken());
			count[agree][sex]++;
		}
		
		for(int i=1; i<=6; i++) {
			for(int j=0; j<=1; j++) {
				if(count[i][j] == 0) continue;
				else if(count[i][j] <= K) answer += 1;
				else {
					int room = count[i][j] / K;
					if(count[i][j] % K > 0) room += 1;
					answer += room;
				}
			}
		}
		
		System.out.println(answer);
	}	
}