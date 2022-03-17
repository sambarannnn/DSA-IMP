class Solution {
    public int scoreOfParentheses(String s) {
        //each () has score 1
        //for () () score => 1 + 1 = 2
        //for ( () () ), score => 2 * (1 + 1)
        //for (( ()  ()) () ), score => 2 * ( (2 * (1 + 1)) + 1 )
        //now, we can observe a pattern that we are basically counting 2 * depth of each () 
        //for each (), score => Pow(2, depth of that())
        //thus,
        int depth = 0;
        char prev = '_';
        int score = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                depth++;
            } else {
                depth--;
                if(prev == '(') {//this is a valid ()
                    score += Math.pow(2, depth);
                }
            }
            prev = c;
        }
        return score;
        
        //ALTER
        //Using a stack to track
        // Stack<Character> stack = new Stack<Character>();
        // for(char c : s.toCharArray()) {
        //     if(c == '(') {
        //         stack.push(c);
        //     } else {
        //         if(!stack.isEmpty() && stack.peek() == '(') {//new beginning
        //             stack.pop();
        //             stack.push((char)(1 +'0'));//add 1 as a character
        //         } else {
        //             int inner = 0;
        //             while(stack.peek() != '(') {
        //                 inner += stack.pop() - '0';//add all the inner consecutive scores
        //             }
        //             int currTotal = (int)(2 * inner);
        //             stack.pop();//remove the corresponding '('
        //             stack.push((char)(currTotal + '0'));//add this for future eval
        //         }
        //     }
        // }
        // int score = 0;
        // while(!stack.isEmpty()) {
        //     score += stack.pop() - '0';
        // }
        // return score;
    }
}
