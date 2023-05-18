import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N+1];
		List<Integer> line = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) number[i] = Integer.parseInt(st.nextToken());
		
		line.add(1);	
		for(int i=2; i<=N; i++) {
			if(number[i] == 0) line.add(i);
			else line.add(line.size()-number[i], i);
		}
		
		for(int answer : line) {
			System.out.print(answer + " ");
		}
	}	
}