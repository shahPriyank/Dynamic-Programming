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
public class SubsetSum {

    static boolean subsum(int[] a, int k) {
        boolean ss[][] = new boolean[a.length + 1][k + 1];

        //ss[0][0]= true;
        for (int x = 0; x <= a.length; x++) {
            ss[x][0] = true;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int t = 1; t <= k; t++) {
                if (t - a[i - 1] >= 0) {
                    boolean temp = ss[i - 1][t - a[i - 1]] || ss[i - 1][t];
                    ss[i][t] = temp;
                } else {
                    ss[i][t] = ss[i - 1][t];
                }
            }
        }

        System.out.println(Arrays.deepToString(ss));
        return ss[a.length][k];
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 4, 6};
        int k = 12;
        boolean ans = subsum(a, k);
        System.out.println(ans);
    }
}
