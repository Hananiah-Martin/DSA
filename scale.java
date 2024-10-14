import java.util.*;
// Working program with FastReader 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class scale {
	
static  final class FastReader { 
	BufferedReader br; 
	StringTokenizer st; 

	public FastReader() 
	{ 
		br = new BufferedReader( 
			new InputStreamReader(System.in)); 
	} 

	String next() 
	{ 
		while (st == null || !st.hasMoreElements()) { 
			try { 
				st = new StringTokenizer(br.readLine()); 
			} 
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
		return st.nextToken(); 
	} 

	int nextInt() { return Integer.parseInt(next()); } 

	long nextLong() { return Long.parseLong(next()); } 

	double nextDouble() 
	{ 
		return Double.parseDouble(next()); 
	} 

	String nextLine() 
	{ 
		String str = ""; 
		try { 
			if(st.hasMoreTokens()){ 
				str = st.nextToken("\n"); 
			} 
			else{ 
				str = br.readLine(); 
			} 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return str; 
	} 


}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            char grid[][]=new char[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.next().charAt(0);
                }
            }
            for(int i=0;i<n;i=i+k){
                for(int j=0;j<n;j=j+k){
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
            t--;
        }
    }
}
