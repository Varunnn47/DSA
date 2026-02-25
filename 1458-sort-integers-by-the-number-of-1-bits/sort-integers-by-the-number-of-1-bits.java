import java.util.*;
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nu=new Integer[arr.length];       
        for(int i=0;i< arr.length;i++){
            nu[i]=arr[i];
        }      
        Arrays.sort(nu,(a,b)->{
            int bitA=Integer.bitCount(a);
            int bitB=Integer.bitCount(b);           
            if(bitA==bitB)
                return a-b;
            else
                return bitA-bitB;
        });       
        for(int i=0;i<arr.length;i++){
            arr[i]=nu[i];
        }       
        return arr;
    }
}