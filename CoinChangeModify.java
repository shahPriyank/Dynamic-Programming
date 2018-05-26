/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priyank_shah;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;/**
 *
 * @author priya
 */
public class CoinChangeModify {

    static int[] coinSet = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    static List<List<Integer>> possibleWays = new ArrayList<>();
    static List<Integer> currentWay = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> countOfCoins = new ArrayList<>();
        makeChange(20, 0, countOfCoins);
        //System.out.print(possibleWays);
    }

    private static int makeChange(int amount, int startCoinIdx, List<Integer> coinsSoFar) {
        if(startCoinIdx == coinSet.length){
            if(amount == 0){
                possibleWays.add(coinsSoFar);
//                if(coinsSoFar.size()==2){
                    System.out.println(coinsSoFar);
//                }
            }
            //System.out.println(coinsSoFar);
            return 0;
        }
        for(int count = 0;(count*coinSet[startCoinIdx]) <= amount;count++){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i < coinsSoFar.size();i++) 
                temp.add(coinsSoFar.get(i));
            for(int i = 0;i < count;i++) 
                temp.add(coinSet[startCoinIdx]);
            if(coinsSoFar.size()>3){
                temp.clear();
            }
            else{
                makeChange(amount - (count * coinSet[startCoinIdx]),startCoinIdx+1, temp);
            }
            temp.clear();
        }
        return 0;
    }
}
// This code is contributed by Pankaj Kumar
