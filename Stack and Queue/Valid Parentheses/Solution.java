class Solution {
    public boolean isValid(String s) {
    
        Stack<Character> stack = new Stack<Character>();
        char[] br = s.toCharArray();
        for(char c : br) {
            //pushing all opening brackets into stack
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.empty())
                    return false;
                //')'='('+1 &'['=']'+2 &'{'='}'+2
                else if(c == stack.peek()+1 || c == stack.peek()+2)
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty() ? true : false;
        
    }
}
