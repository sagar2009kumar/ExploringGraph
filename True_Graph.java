import java.io.*;
import java.util.*;

class True_Graph {

	static ArrayList<Integer> al[];

 	static int n = 10;

	public static void main(String args[]) throws IOException, Exception {

		al = new ArrayList[n];

		for(int i = 0; i < n; i++) {

			al[i] = new ArrayList<Integer>();
		
		}
		
		// Adding edges to the directed graph

		al[2].add(4);
		al[1].add(2);
		al[1].add(3);
		print();
		dfs_main();
	}

	static void dfs_main() {

		for(int i = 0; i < n; i++) {

			if(!vis[i]) {

				dfs(i);
		
				System.out.println(i);
			}

		}

	}

	static boolean vis[] = new boolean[n];

	static void dfs(int curr) {

		vis[curr] = true;

		for(int i = 0; i < al[curr].size(); i++) {

			if(!vis[al[curr].get(i)]) {

				dfs(al[curr].get(i));

			}
		
			System.out.print(al[curr].get(i)+" ");

		}

		System.out.println();
			
	}

	static void print() {

		for(int i = 0; i < n; i++) {

			for(int j = 0; j < al[i].size(); j++) {

				System.out.print(al[i].get(j)+" ");
			}
				
			System.out.println();
		
		}

	}
}
