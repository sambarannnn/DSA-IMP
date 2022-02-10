class Solution {
    public int myAtoi(String s) {
        int index = 0;
        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if(index == s.length()) {
            return 0;
        }
        
        int sign = 1;
        if(s.charAt(index) == '-') {
            index++;
            sign = -1;
        } else if(s.charAt(index) == '+') {
            index++;
        }
        long sum = 0;
        while(index < s.length()) {
            if(!Character.isDigit(s.charAt(index))) {
                break;
            }
            sum = sum * 10 + (s.charAt(index) - '0');
            if(sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(sign == -1 && sign*sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) sum*sign;
    }
}
