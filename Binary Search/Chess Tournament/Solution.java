import java.util.*;
public class Solution {

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // Write your code here.    
        Arrays.sort(positions);
        int low = 1;
        int high = positions[n-1] - positions[0];
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(isValid(positions, n, mid, c)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    public static boolean isValid(int[] positions, int n, int min_dist, int tot_players) {
        //place first player in first room
        int curr_loc = positions[0];
        int placed_players = 1;
        
        for(int i = 1; i < n; i++) {
            if(positions[i] - curr_loc >= min_dist) {
                placed_players++;
                curr_loc = positions[i];
            }
            if(placed_players == tot_players) {
                return true;
            }
        }
        return false;
    }
}
