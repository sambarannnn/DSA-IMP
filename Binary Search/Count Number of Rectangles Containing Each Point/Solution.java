class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        //heights are varying lesser than widths, so make buckets of heights
        //for each point inside permissable rectangle heights, check for no of permissable rectangle widths
        //use bsearch to find number of widths greater than or equal to point x-coordinate
        //find last index smaller than ele which will give number of smaller widths
        //total no of widths - number of smaller widths = no of proper widths
        TreeMap<Integer, List<Integer>> heightToWidth = new TreeMap<>();
        int maxHeight = 0;
        for(int[] rectangle : rectangles) {
            heightToWidth.putIfAbsent(rectangle[1], new ArrayList<Integer>());
            heightToWidth.get(rectangle[1]).add(rectangle[0]);
            maxHeight = Math.max(maxHeight, rectangle[1]);
        }
        for(int height : heightToWidth.keySet()) {
            Collections.sort(heightToWidth.get(height));//we will perform binary search on them
        }
        int[] res = new int[points.length];
        int index = 0;
        for(int[] point : points) {
            if(point[1] > maxHeight) {
                index++;
                continue;
            }
            int num = 0;
            for(int height : heightToWidth.subMap(point[1], maxHeight+1).keySet()) {
                List<Integer> currWidths = heightToWidth.get(height);
                num += currWidths.size() - bSearch(currWidths, point[0]);
            }
            res[index++] = num;
        }
        return res;
    }

    public int bSearch(List<Integer> arr, int ele) {
        int l = 0;
        int r = arr.size()-1;
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr.get(mid) < ele) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
