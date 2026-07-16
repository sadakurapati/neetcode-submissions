class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort based on interval starts in asc
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0, prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
                ans++;
                prevEnd = Math.min(prevEnd, end);
            } else { // no removal
                prevEnd = end;
            }
        }
        return ans;
    }
}
