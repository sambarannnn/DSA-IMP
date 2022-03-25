class Solution {
    class cityComparator implements Comparator<int[]> {
        public int compare(int[] costs1, int[] costs2) {
            //DIFFERENCE : CITYB - CITYA
            //MORE DIFFERENCE : CITYB IS (MORE) HIGHER THAN CITYA
            int difference1 = costs1[1] - costs1[0];
            int difference2 = costs2[1] - costs2[0];
            //SORT ACCORDING TO HIGHEST CITYB FARES FROM LEFT TO RIGHT
            //DESCENDING CITYB FARES
            if(difference2 > difference1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new cityComparator());
        //DESCENDING CITYB FARES
        //so for first n/2 entries, travel to cityA
        //for next n/2 entries, travel to cityB
        
        int totalCost = 0;
        for(int i = 0; i < costs.length/2; i++) {
            totalCost += costs[i][0];
        }
        for(int i = costs.length/2; i < costs.length; i++) {
            totalCost += costs[i][1];
        }
        return totalCost;
    }
}
