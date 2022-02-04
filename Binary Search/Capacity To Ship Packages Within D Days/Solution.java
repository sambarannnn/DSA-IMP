class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(days > weights.length)//cant have empty days
            return -1;
        
        //similar to allocate min no of max_pages of books
        //every day needs to be utilised
        //we have to take shipments in contiguous order
        
        //least possible weight is min weight in case of  days = weights.length
        //max possible weight is if we have only one day then all the weights shipped in one day
        
        //find leftmost occurence of valid max_weight in one day
        
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int weight : weights) {
            low = Math.min(low, weight);
            high += weight;
        }
        //now we have our search space
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(isValid(weights, days, mid)) {//valid max_weight, lets try to minimize
                high = mid-1;
            } else {
                low = mid+1;//max_weight too less, lets increase
            }
        }
        return low;
    }
    public static boolean isValid(int[] weights, int max_days, int max_weight) {
        int day_count = 1;
        int curr_weight = 0;
        for(int i = 0; i < weights.length; i++) {
            curr_weight += weights[i];
            if(curr_weight > max_weight) {//if this day's weight exceeds max_weight
                day_count++;
                curr_weight = weights[i];
                if(curr_weight > max_weight)//incase this one weight is more than current max_weight, not possible
                    return false;
            }
        }
        return (day_count > max_days) ? false : true;//if distribution acc to current max_weight needs more days than max_days then return false
    }
}
