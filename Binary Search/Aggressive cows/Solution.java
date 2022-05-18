//https://www.spoj.com/problems/AGGRCOW/
import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
		    int n = s.nextInt();
		    int c = s.nextInt();
		    int[] stalls = new int[n];
		    for(int i = 0; i < n; i++) {
		        stalls[i] = s.nextInt();
		    }
		    Arrays.sort(stalls);
		    //1 2 4 8 9
		    
		    int minDiff = Integer.MAX_VALUE;
            for (int i=0; i<n-1; i++)
                minDiff = Math.min(stalls[i+1] - stalls[i], minDiff);
		    //min distance between 2 cows can be minDiff
		    //max distance between 2 cows can be 9 - 1
		    
		    int low = minDiff;
		    int high = stalls[stalls.length-1] - stalls[0];
		    //find various candidates for minimum distance and check if this is a viable min distance to fit in all the cows
		    //if we find a viable min distance, then check for higher distances if we find a viable alternative
		    while(low <= high) {
		        
		        int mid = low + (high-low)/2;
		        //System.out.println(low + " " + mid + " " + high);
		        if(isPossible(stalls, mid, c)) {
		            low = mid + 1;
		        } else {
		            high = mid - 1;
		        }
		    }
		    System.out.println(high);
		}
	}
	
	private static boolean isPossible(int[] stalls, int min, int cows) {
	    //place first cow at pos 0
	    int placed = 1;
	    int prev_loc = 0;
	    for(int i = 1; i < stalls.length; i++) {
	        if(stalls[prev_loc] + min <= stalls[i]) {//if we can place here (only if dist between prev location and current location is more than min req dist)
	            placed++;
	            prev_loc = i;
	        }
	        if(placed == cows) {
	            return true;
	        }
	    }
	    return false;
	}
}
