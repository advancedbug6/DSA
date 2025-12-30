class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length, res = 0;

        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (grid[i][j] > 0 && grid[i][j] <= 9) {
                    if (check(grid, i, j)) res += 1;
                }
            }
        }

        return res;
    }

    public boolean check(int[][] grid, int r, int c) {
        Set<Integer> set = new HashSet();
        //for distinct and 1-9 numbers && row addition && col addition
        int magicNum = -1;

        for (int i = r; i < r + 3; i++) {
            int k = 0;

            for (int j = c; j < c + 3; j++) {
                int temp = grid[i][j];
                // System.out.println(i + "*******" + j);
                k += temp;
                if (temp <= 0 || temp > 9 || set.contains(temp)) return false; else set.add(temp);
            }

            if (magicNum == -1) magicNum = k;
            if (magicNum != k) return false;
        }

        for (int i = c; i < c + 3; i++) {
            int m = 0;
            for (int j = r; j < r + 3; j++) {
                // System.out.println(i + "*******" + j);
                m += grid[j][i];
            }
            if (m != magicNum) return false;
        }

        //for diagonals
        int dia = 0, anti = 0;
        for (int i = 0; i < 3; i++) {
            dia += grid[r + i][c + i];

            anti += grid[r + i][(c + 3) - i - 1];
        }

        if (dia != magicNum || anti != magicNum) return false;

        return true;
    }
}
