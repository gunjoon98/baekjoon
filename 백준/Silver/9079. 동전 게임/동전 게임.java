import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	static int[] discovered;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			char[] arr = new char[9];
			for(int i=0; i<3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<3; j++) arr[i*3 + j] = st.nextToken().charAt(0);
			}
			
			int num = toBinary(arr);
			discovered = new int[512];
			Arrays.fill(discovered, -1);
			System.out.println(bfs(num));
		}
	}
	
	static int bfs(int start) {
		int[][] next_ops = {
				{0,1,2},
				{3,4,5},
				{6,7,8},
				{0,3,6},
				{1,4,7},
				{2,5,8},
				{0,4,8},
				{2,4,6}};
		
		Queue<Integer> queue = new LinkedList<>();
		discovered[start] = 0;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int node = queue.remove();
			
			if(isAnswer(node)) return discovered[node];
			
			for(int i=0; i<8; i++) {
				int next = bitReverse(node, new int[] {next_ops[i][0], next_ops[i][1], next_ops[i][2]});
				if(discovered[next] == -1) {
					discovered[next] = discovered[node] + 1;
					queue.add(next);
				}
			}
		}
		return -1;
	}
	
	static int toBinary(char[] arr) {
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 'T') num = num | 1 << arr.length-1-i;
		}
		return num;
	}
	
	static int bitReverse(int num, int[] index_arr) {
		for(int index : index_arr) {
			index = 8 - index; 
			int bit = num & (1 << index);
			
			if(bit == 0) num = num | (1 << index);
			else num = num & ~(1 << index);
		}
		return num;
	}
	
	static boolean isAnswer(int num) {
		if(num == 0 || num == 511) return true;
		else return false;
	}
}