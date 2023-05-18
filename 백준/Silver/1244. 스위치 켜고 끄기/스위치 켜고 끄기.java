import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int switch_num = Integer.parseInt(br.readLine());
		boolean[] switches = new boolean[switch_num + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=switch_num; i++) {
			if(Integer.parseInt(st.nextToken()) == 1) switches[i] = true;
			else switches[i] = false;
		}
		
		int student_num = Integer.parseInt(br.readLine());
		for(int i=0; i<student_num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				int temp = target;
				while(temp <= switch_num) {
					switches[temp] = !switches[temp];
					temp += target; 
				}
			}
			else {
				switches[target] = !switches[target];
				int start = target - 1;
				int end = target + 1;
				while(start >= 1 && end <= switch_num && switches[start] == switches[end]) {
					switches[start] = !switches[start];
					switches[end] = !switches[end];
					start--;
					end++; 
				}
			}
		}
		
		for(int i=1; i<=switch_num; i++) {
			if(switches[i]) System.out.print(1 + " ");
			else System.out.print(0 + " ");

			if(i % 20 == 0) System.out.println();
		}
	}	
}