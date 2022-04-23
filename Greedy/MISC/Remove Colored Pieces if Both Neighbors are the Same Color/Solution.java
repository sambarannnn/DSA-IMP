class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0;
        int bobMoves = 0;
        for(int i = 1; i < colors.length()-1; i++) {
            if(colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)) {
                if(colors.charAt(i) == 'A') {
                    aliceMoves++;
                } else {
                    bobMoves++;
                }
            }
        }
        return aliceMoves > bobMoves;
    }
}
