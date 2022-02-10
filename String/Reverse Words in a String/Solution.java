class Solution {
    public String reverseWords(String s) {
        //O(1) SPACE
        String res = "";
        int index = 0;
        String temp = "";
        while(index < s.length()) {
            if(s.charAt(index) != ' ') {
                temp += s.charAt(index);
            } else {
                if(res == "") {
                    res = temp;
                } else {
                    res = temp + " " + res;
                }
                while(index+1 < s.length() && s.charAt(index+1) == ' ')
                    index++;
                temp = "";
            }
            index++;
        }
        if(temp!="") {
            if(res == "") {
                res = temp;
            } else {
                res = temp + " " + res;
            }
        }
        return res;
    }
}
