class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        
        // Bitmask for primes (index = set bits count)
        int primeMask = 665772; 
        // binary representation has bits set at prime positions
        
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (((primeMask >> bits) & 1) == 1) {
                count++;
            }
        }
        
        return count;
    }
}