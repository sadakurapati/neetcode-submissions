class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int cnt = 0, prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if(curr[0] < prevEnd){
                cnt++;
                prevEnd = Math.min(prevEnd, curr[1]);
            } else {
                prevEnd = curr[1];
            }
        }
        return cnt;
    }
}
