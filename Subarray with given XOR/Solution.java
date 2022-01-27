public class Solution {
    public int solve(int[] A, int B) {
        int xsum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : A) {
            xsum = xsum ^ num;
            if(map.containsKey(xsum ^ B)) {
                count += map.get(xsum^B);
            }
            if(xsum == B) {
                count += 1;
            }
            map.put(xsum, map.getOrDefault(xsum, 0)+1);
        }
        return count;
    }
}
