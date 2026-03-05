class Solution {
    public int minOperations(String s) {

        int chan = 0;
        int cha = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i % 2 == 0) {
                if (s.charAt(i) != '0') chan++;
                if (s.charAt(i) != '1') cha++;
            } 
            else {
                if (s.charAt(i) != '1') chan++;
                if (s.charAt(i) != '0') cha++;
            }
        }

        return Math.min(chan,cha);
    }
}