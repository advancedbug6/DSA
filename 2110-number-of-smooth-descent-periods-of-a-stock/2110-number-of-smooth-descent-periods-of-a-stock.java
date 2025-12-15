class Solution {

    public long getDescentPeriods(int[] p) {
        long res = 1;
        int streak = 1;

        for (int i = 1; i < p.length; i++) {
            if (p[i] - p[i - 1] == -1) {
                streak += 1;
                res += streak;
            } else {
                streak = 1;
                res += streak;
            }
        }

        return res;
    }
}
