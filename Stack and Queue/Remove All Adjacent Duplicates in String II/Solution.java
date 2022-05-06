class Pair {
    char ch;
    int freq;
    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<Pair>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().ch == c && stack.peek().freq == k-1) {
                stack.pop();
            } else {
                if(!stack.isEmpty() && stack.peek().ch == c) {
                    stack.peek().freq++;
                } else {
                    stack.push(new Pair(c, 1));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(Pair p : stack) {
            while(p.freq-- > 0)
                res.append(p.ch);
        }
        return res.toString();
    }
}
