public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
		//MODIFIED KMP
        String text = s;
        String pattern = p;
        int count = 0;
        int[] KMP = KMPpreprocess(pattern);
        int i = 0;
        int j = 0;
        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j > 0) {
                    j = KMP[j-1];
                } else {
                    i++;
                } 
            }
            if(j == pattern.length()) {
                i = i-j+1;//reset i to next char than curr starting point
                count++;
                j = 0;
            }
        }
        return count;
	}
    
    public static int[] KMPpreprocess(String pattern) {
        int[] KMP = new int[pattern.length()];
        int l = 0;
        int r = 1;
        
        while(r < pattern.length()) {
            if(pattern.charAt(l) == pattern.charAt(r)) {
                KMP[r] = l+1;
                l++;
                r++;
            } else {
                if(l > 0) {
                    l = KMP[l-1];
                } else {//l becomes 0
                    KMP[r] = 0;
                    r++;
                }
            }
        }
        return KMP;
    }

}
