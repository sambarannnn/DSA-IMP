class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> last_index = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            last_index.put(s.charAt(i), i);
        }
        int currStart = 0;
        int currEnd = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++) {
            currEnd = Math.max(currEnd, last_index.get(s.charAt(i)));
            if(i == currEnd) {
                res.add(currEnd - currStart + 1);
                currStart = i + 1;
            }
        }
        return res;
    }
}
