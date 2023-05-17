import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	
	static int H,W;
	static char[][] grid;
	static boolean[][] visit;
	static int[] x_pos = {-1, 1, 0, 0};
	static int[] y_pos = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			grid = new char[H][W];
			visit = new boolean[H][W];
			for(int i=0; i<H; i++) {
				String line = br.readLine();
				for(int j=0; j<W; j++) {
					grid[i][j] = line.charAt(j);
				}
			}
			
			System.out.println(dfsAll());
		}
	}
	
	static int dfsAll() {
		int count = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(!visit[i][j] && grid[i][j] == '#') {
					dfs(i,j);
					count++;
				}
			}
		}
		return count;
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int new_x = x + x_pos[i];
			int new_y = y + y_pos[i];
			if(new_x < 0 || new_x >= H || new_y < 0 || new_y >= W) continue;
			if(visit[new_x][new_y] || grid[new_x][new_y] == '.') continue; 
			dfs(new_x,new_y);
		}
	}
}