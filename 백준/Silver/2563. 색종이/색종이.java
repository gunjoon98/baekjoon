import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] matrix = new boolean[100][100];
		int N = Integer.parseInt(br.readLine());
		
		for(int t=0; t<N; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					matrix[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(matrix[i][j]) answer++;
			}
		}
		System.out.println(answer);
	}	
}