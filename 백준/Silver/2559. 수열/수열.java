import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += num[i];
		}
		
		int answer = sum;
		int previous = 0;
		for(int next=K; next<N; next++) {
			sum -= num[previous];
			sum += num[next];
			answer = Math.max(answer, sum);
			previous++;
		}
		System.out.println(answer);
	}	
}