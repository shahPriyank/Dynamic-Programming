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
public class RcpWithSize {
    public static void main(String[] args) {
//        int size[] = {0,2,3,5,6,8};
//        int p_i[] = {0,3,2,1,4,4};
        int size[] = {0,2,2};
        int p_i[] = {0,10,15};
//        int r[] = new int[size[size.length-1]+1];
        int r[] = new int[21];
        
//        for (int n = 0; n <= size[size.length-1]; n++) {
        for (int n = 0; n <= 20; n++) {
            if(n<size[1]){
                r[n]=0;
            }
            else{
            int maxi = r[n-size[1]]+p_i[1];
            for (int i = 2; i <= size.length-1; i++) {
                if(n>=size[i]){
                maxi = Math.max(maxi, r[n-size[i]]+p_i[i]);
                }
            }
            r[n] = maxi; 
            }
        }
        System.out.println(Arrays.toString(r));
    }
}
