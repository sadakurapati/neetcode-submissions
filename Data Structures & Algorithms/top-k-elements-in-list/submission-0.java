class Solution {
    record ElementFrequency(int num, int frequency){}
    public int[] topKFrequent(int[] nums, int k) {
        // Calculate the numbers frequency
        Map<Integer, Integer> elFrequencyMap = new HashMap<>();
        for(int num: nums) {
            elFrequencyMap.merge(num, 1, Integer::sum);
        }
        // MIN Heap
        PriorityQueue<ElementFrequency> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.frequency, b.frequency)
        );
        for(var entry: elFrequencyMap.entrySet()) {
            pq.offer(new ElementFrequency(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[pq.size()];
        int i = pq.size() - 1;
        while(!pq.isEmpty()) {
            ElementFrequency el = pq.poll();
            ans[i] = el.num;
            i--;
        }
        return ans;
    }
}
