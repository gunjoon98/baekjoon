import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		int[] path = new int[N];
		int[] pos = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			path[i] = Integer.parseInt(st.nextToken());
			pos[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int dong_path = Integer.parseInt(st.nextToken());
		int dong_pos = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		//1-북, 2-남, 3-서, 4-동
		for(int i=0; i<N; i++) {
			if(dong_path == 1) {				
				if(path[i] == 1) answer += Math.abs(dong_pos - pos[i]);
				else if(path[i] == 2) answer += Math.min(dong_pos + h + pos[i], w - dong_pos + h + w - pos[i]);
				else if(path[i] == 3) answer += dong_pos + pos[i];
				else answer += w - dong_pos + pos[i];
			}
			
			else if(dong_path == 2) {
				if(path[i] == 2) answer += Math.abs(dong_pos - pos[i]);
				else if(path[i] == 1) answer += Math.min(dong_pos + h + pos[i], w - dong_pos + h + w - pos[i]);
				else if(path[i] == 3) answer += dong_pos + h - pos[i];
				else answer += w - dong_pos + h - pos[i];
			}
			
			else if(dong_path == 3) {
				if(path[i] == 3) answer += Math.abs(dong_pos - pos[i]);
				else if(path[i] == 4) answer += Math.min(dong_pos + w + pos[i], h - dong_pos + w + h - pos[i]);
				else if(path[i] == 1) answer += dong_pos + pos[i];
				else answer += h - dong_pos + pos[i];
			}
			
			else if(dong_path == 4) {
				if(path[i] == 4) answer += Math.abs(dong_pos - pos[i]);
				else if(path[i] == 3) answer += Math.min(dong_pos + w + pos[i], h - dong_pos + w + h - pos[i]);
				else if(path[i] == 1) answer += dong_pos + w - pos[i];
				else answer += h - dong_pos + w - pos[i];
			}
		}
		
		System.out.println(answer);
	}	
}