class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int ns = 0;
        int nt = 0;
        
        while(i >= 0 || j >= 0) {
            while(i >= 0 && (s.charAt(i) == '#' || ns > 0)) {
                if(s.charAt(i) == '#') {
                    ns++;
                    i--;
                } else if(ns > 0) {
                    ns--;
                    i--;
                }
            }
            while(j >= 0 && (t.charAt(j) == '#' || nt > 0)) {
                if(t.charAt(j) == '#') {
                    nt++;
                    j--;
                } else if(nt > 0) {
                    nt--;
                    j--;
                }
            }
            if((i < 0 && j >= 0) || (i >= 0 && j < 0)) {
                // System.out.println(i + " " + j);
                return false;
            }
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
