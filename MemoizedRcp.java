/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priyank_shah;

/**
 *
 * @author priya
 */
import java.util.Arrays;
public class MemoizedRcp {
    static int size[] = {0,1,2,3,4,5,6,7,8,9,10};
    static int profit[] = {0,1,5,8,10,13,17,17,20,24,26};
    static int s[] = new int[size.length];
	

	static int r[] = new int[size.length];
	
	static public int memoizedRCP(int n)
	{
		 int f=0;
		 if (n==0)
			 return 0;
		 else
			 if(r[n]!=0)
			 {
				 return r[n];
			 }
		
		 f=profit[1]+memoizedRCP(r[n-1]);
		 
		 for(int i=1;i<=n;i++)
		 {
			 if(f<profit[i]+memoizedRCP(n-i))
			 {
				 f= profit[i]+memoizedRCP(n-i);
				 s[n]=i;
			 }
			 
		 }
		 r[n]=f;
		 
		 return f;
	}
	
	
	public static void main(String[] args) {
        
        
       memoizedRCP(10);
       System.out.println(Arrays.toString(r));
       System.out.println(Arrays.toString(s));

	}
}
