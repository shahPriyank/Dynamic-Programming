import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

// Change name of file and class from "NetId" to your net id
public class pks170030Project6363 {
    static int VERBOSE = 0;
    static int solutionArray[];
    static int dp[][];
    // static int dp[][];

    static class Jewel {
		public int weight, profit, min, max, fine, cap;
		Jewel(int w, int p, int n, int x, int f, int c) {
		    weight = w;  profit = p;  min = n;  max = x;  fine = f;  cap = c;
		}

		public int getWeight(){
			return weight;
		}

		public int getProfit(){
			return profit;
		}

		public int getMin(){
			return min;
		}

		public int getMax(){
			return max;
		}

		public int getFine(){
			return fine;
		}

		public int getCap(){
			return cap;
		}

		public String toString() { 
			return weight + " " + profit + " " + min + " " + max + " " + fine + " " + cap; 
		}
	}

    static class Pair {
		public int p, n;
		Pair(int p, int n) {
		    this.p = p;  this.n = n;
		}

		public String toString() {
			return p + " " + n;
		}
	}

    public static Pair process(int G, Jewel[] items, int n) {
		// Code to be written

		int calculate = 0;
        int limit = 0;
		/*int*/ solutionArray = new int[n+1];
		/*int*/ dp = new int[n+1][G + 1];
        int count[][] = new int[n+1][G + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= G; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                else {
                    int maxi = Integer.MIN_VALUE;
                    int q = 0;
                    limit = limitOfQ(items,i,j);
                    while (q <= limit) {
                        calculate = minVal(items, i, q);
                        maxi = maxOf2Nos(maxi, q * items[i].getProfit() + dp[i - 1][j - q * items[i].getWeight()] - calculate);
                        q++;
                    }
                    dp[i][j] = maxi;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= G; j++) {
                if(i==0){
                    count[i][j] = 1;
                }
                else{
                    int q = 0;
                    limit = limitOfQ(items,i,j);
                    while (q <= limit) {
                    	calculate = minVal(items, i, q);
                       	if (dp[i][j] == q * items[i].getProfit() + dp[i - 1][j - q * items[i].getWeight()] - calculate){
                                count[i][j] += count[i-1][j-q*items[i].getWeight()];
                            }
                        q++;
                    }
                }
            }
        }
		return new Pair(dp[n][G], count[n][G]);
    }

    public static void enumerate(int[] solutionArray, int i, int g, Jewel[] items, int[][] dp){
    	if (i==0) {
    		for (int p=1;p<solutionArray.length;p++) {
    			System.out.print(solutionArray[p]+ " ");
    		}
    		System.out.println();
    	}
    	else{
    		int limit = limitOfQ(items,i,g);
    		int q = 0;
    		while (q<=limit) {
    			int calculate = minVal(items,i,q);
    			if (dp[i][g] == dp[i-1][g-q*items[i].getWeight()]+q*items[i].getProfit()-calculate) {
    				solutionArray[i] = q;
    				enumerate(solutionArray,i-1,g-q*items[i].getWeight(), items, dp);
    			}
    			q++;
    		}
    	}
    }

    public static int minVal(Jewel[] items, int i, int q){
    	if(q<items[i].getMin()){
    		return minOf2Nos(items[i].getCap(), items[i].getFine() * (items[i].getMin() - q));
    	}
    	else{
    		return 0;
    	}
    }

    public static int minOf2Nos(int a, int b){
    	return (a < b) ? a : b;
    }
    
    public static int maxOf2Nos(int a, int b){
    	return (a < b) ? b : a;
    }

    public static int limitOfQ(Jewel[] items, int i, int j){
    	return minOf2Nos(j/items[i].getWeight(),items[i].getMax());
    }

    public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
		if(args.length == 0 || args[0].equals("-")) {
		    in = new Scanner(System.in);
		} else {		
		    File inputFile = new File(args[0]);
		    in = new Scanner(inputFile);
		}
		if (args.length > 1) {
		    VERBOSE = Integer.parseInt(args[1]);
		}
		int G = in.nextInt();
		int n = in.nextInt();
		Jewel[] items = new Jewel[n+1];
		for(int i=0; i<n; i++) {
		    int index = in.nextInt();
		    int weight = in.nextInt();
		    int profit = in.nextInt();
		    int min = in.nextInt();
		    int max = in.nextInt();
		    int fine = in.nextInt();
		    int cap = in.nextInt();
		    items[index] = new Jewel(weight, profit, min, max, fine, cap);
		    if(VERBOSE > 0) { System.out.println(index + " " + items[index]); }
		}
		Pair answer = process(G, items, n);
		System.out.println(answer);
		if(VERBOSE>0){
       		enumerate(solutionArray, n, G, items, dp);
    	}
    }
}