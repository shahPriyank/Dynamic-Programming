/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priyank_shah;

import java.util.Arrays;

/**
 *
 * @author priya
 */
public class RcpWithLimits {
    public static void main(String[] args) {
        int z = 4;  // rod of length k-1
//          int k = 4;

        int c_i[] = {0,3,4,15,2,3};
        int k = c_i.length;
        int l_i[] = {0,4,2,1,2,3};
//        int c_i[] = {0,1,1,4};
//        int l_i[] = {0,2,2,1};

        int dp[][] = new int[k][z];
        for (int i = 0; i < k; i++) {
            for (int n = 0; n < z; n++) {
                if(i==0 ||n==0){
                    dp[i][n]=0;
                }
                else {
                    int maxi = dp[i-1][n];
                    int q = 1;
                    while (n-q*i>=0 && q<=l_i[i]) {                        
                        maxi = Math.max(maxi,q*c_i[i]+dp[i-1][n-q*i]);
                        q++;
                    }
                    dp[i][n] = maxi;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }
    
    
}
