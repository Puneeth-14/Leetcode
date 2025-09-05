class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // Step 1: Ignore leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits to number
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            
            // Step 4: Clamp values to 32-bit signed int range
            if (num * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (num * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            
            i++;
        }
        
        return (int) (num * sign);
    }
}
