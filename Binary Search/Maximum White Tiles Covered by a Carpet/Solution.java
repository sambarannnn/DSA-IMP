class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int res = 0;
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);//sort ranges according to starting pos
        //we will always start from first index of each range to get max whte tiles
        //so for the starting tile of each range, find the prefix sum of white tiles
        int[] prefixTiles = new int[tiles.length];
        prefixTiles[0] = tiles[0][1] - tiles[0][0] + 1;
        for(int i = 1; i < tiles.length; i++) {
            prefixTiles[i] = prefixTiles[i-1] + (tiles[i][1] - tiles[i][0] + 1);
        }
        
        for(int i = 0; i < tiles.length; i++) {
            int start = tiles[i][0];
            int end = start + carpetLen - 1;
            int maxRange = bSearchUpper(tiles, end);//first occurence of range ending with greater or equal to carpet Ending

            
            int whites = 0;
            if(i > 0) 
                whites = prefixTiles[maxRange] - prefixTiles[i-1];
            else
                whites = prefixTiles[maxRange];
            //System.out.println(whites);
            if(end < tiles[maxRange][1]) {
                whites -= tiles[maxRange][1] - Math.max(end, tiles[maxRange][0] - 1);
            }
            
            res = Math.max(whites, res);
        }
        return res;
    }
    public int bSearchUpper(int[][] tiles, int end) {
        int l = 0;
        int r = tiles.length-1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(tiles[mid][1] < end) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l == tiles.length ? l - 1 : l;
    }
}
