class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for (int stone: stones) {
            pq.offer(stone);
        }
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(Math.abs(first - second));
        }
        return pq.peek();
    }
}
