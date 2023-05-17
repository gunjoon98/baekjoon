import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] length = new int[N];
		int[] gas = new int[N];
		
		length[0] = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<N; i++) length[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) gas[i] = Integer.parseInt(st.nextToken());
		
		
		int terminal_city = N-1;
		int cur_city = 0;
		int target_city = 0;
		long money = 0;
		
		while(cur_city < terminal_city) {
			int move = 0;
			target_city = cur_city + 1;
			
			while(target_city < terminal_city && gas[cur_city] <= gas[target_city]) {
				move += length[target_city];
				target_city++;
			}
			move += length[target_city];
			
			money += move * gas[cur_city];
			cur_city = target_city;
		}
		
		System.out.println(money);
	}
}