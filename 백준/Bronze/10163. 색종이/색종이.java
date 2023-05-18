import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[1001][1001];
		int[] count = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int x_pos=x; x_pos<x+h; x_pos++) {
				for(int y_pos=y; y_pos<y+w; y_pos++) {
					matrix[x_pos][y_pos] = i;
				}
			}
		}
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				count[matrix[i][j]]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(count[i]);
		}
	}	
}