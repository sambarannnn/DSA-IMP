class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        List<Integer> starts = new ArrayList<Integer>();
        List<Integer> ends = new ArrayList<Integer>();
        for(int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1]);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int i = 0;
        int j = 0;
        int currCount = 0;
        
        for(i = 0; i < persons.length; i++) {
            int visitTime = persons[i];
            int bloomNum = bSearchUpper(starts, visitTime);
            int deadNum = bSearchLower(ends, visitTime);
            int alive = bloomNum-deadNum;
            persons[i] = alive;
        }
        return persons;
    }
    public int bSearchUpper(List<Integer> arr, int ele) {
        //find index of first greater element
        //that will be number of bloomed flowers at this instant of time
        int l = 0;
        int r = arr.size()-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr.get(mid) <= ele) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
    public int bSearchLower(List<Integer> arr, int ele) {
        //find index of first greater or equal element SINCE WE DO NOT WANT TO COUNT CURRENT INSTANTS DEATH IN THIS INSTANT
        //that will be number of dead flowers at this instant of time
        int l = 0;
        int r = arr.size()-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr.get(mid) < ele) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
