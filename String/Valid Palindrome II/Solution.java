class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return check(s, left+1, right) || check(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean check(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            right--;
            left++;
        }
        return true;
    }
}
// class Solution {
//     public boolean validPalindrome(String s) {
//         return validPalindrome(s, 0, s.length()-1, 1);
//     }
//     public boolean validPalindrome(String s, int l, int r, int max_delete) {
//         if(l > r) {
//             return true;
//         }
//         if(s.charAt(l) == s.charAt(r)) {
//             return validPalindrome(s, l+1, r-1, max_delete);
//         } else if(max_delete > 0) {
//             return validPalindrome(s, l+1, r, max_delete - 1) || validPalindrome(s, l, r-1, max_delete - 1);
//         } else {
//             return false;
//         }
//     }
// }
