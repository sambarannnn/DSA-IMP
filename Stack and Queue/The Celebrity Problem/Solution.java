class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for(int i = 0; i < n; i++) {
    	    stack.push(i);
    	}
    	
    	while(stack.size() > 1) {
    	    int cand1 = stack.pop();
    	    int cand2 = stack.pop();
    	    if(M[cand1][cand2] == 1) {//1 knows 2
    	        stack.push(cand2);
    	    } else if(M[cand2][cand1] == 1){
    	        stack.push(cand1);
    	    }
    	}
    	int potentialCandidate = stack.pop();
    	// we have to check if this candidate knows anyone
    	//and if everyone knows this candidate
    	boolean candKnowsAnyone = false;
    	for(int i = 0; i < n; i++) {
    	    if(i != potentialCandidate && M[potentialCandidate][i] == 1) {
    	        return -1;
    	    }
    	}
    	boolean everyoneKnowsCand = true;
    	for(int i = 0; i < n; i++) {
    	    if(i != potentialCandidate && M[i][potentialCandidate] == 0) {
    	        return -1;
    	    }
    	}
    	return potentialCandidate;
    }
}
