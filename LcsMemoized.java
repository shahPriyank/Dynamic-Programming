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
public class LcsMemoized {

    static int L[][];

    static int lcsMemoized(char[] X, char[] Y, int m, int n) {
        if (L[m][n] > 0) {
            return L[m][n];
        }
        if (m == 0 || n == 0) {
            return 0;
        } else {
            int i = 0;
            int j = 0;
            for (i = 1; i <= m; i++) {
                for (j = 1; j <= n; j++) {

                    if (X[i-1] == Y[j-1]) {
                        L[m][n] = 1 + lcsMemoized(X, Y, i - 1, j - 1);
                    } else {
                        L[m][n] = Math.max(lcsMemoized(X, Y, i - 1, j), lcsMemoized(X, Y, i, j - 1));
                    }

                }
            }
        return L[m][n];
        }
        
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        L = new int[m + 1][n + 1];
        int ans = lcsMemoized(X, Y, m, n);
        System.out.println(ans);
        System.out.println(Arrays.deepToString(L));

    }

}
