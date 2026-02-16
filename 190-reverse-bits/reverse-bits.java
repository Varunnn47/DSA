public class Solution {
    public int reverseBits(int n) {
        int b=0;
        for (int i=0;i<32;i++){
            b<<=1;
            b|=(n&1);
            n>>=1;
        }        
        return b;
    }
}
