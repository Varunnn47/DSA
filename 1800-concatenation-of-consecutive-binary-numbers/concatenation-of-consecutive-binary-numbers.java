class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int bi= 0;
        int MOD = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bi++;
            }
            result = ((result << bi) + i) % MOD;
        }
        return (int) result;
    }
}